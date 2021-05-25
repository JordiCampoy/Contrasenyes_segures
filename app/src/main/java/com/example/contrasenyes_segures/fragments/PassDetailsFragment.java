package com.example.contrasenyes_segures.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.contrasenyes_segures.R;
import com.example.contrasenyes_segures.cryptography.AESCrypt;
import com.example.contrasenyes_segures.database.PassDB;
import com.example.contrasenyes_segures.database.Password;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Base64;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PassDetailsFragment extends Fragment {

    private TextView name;
    private TextView username;
    private TextView password;
    private TextView date;
    private FloatingActionButton fab;
    private Button speech;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        name = (TextView) view.findViewById(R.id.textViewDetailsName);
        username = (TextView) view.findViewById(R.id.textViewDetailsUsername);
        password = (TextView) view.findViewById(R.id.textViewDetailsPassword);
        date = (TextView) view.findViewById(R.id.textViewDetailsDate);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_detail2list);
        speech = (Button) view.findViewById(R.id.speech);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PassDB db = Room.databaseBuilder(getActivity(), PassDB.class, "PassDB").build();
        new Thread(new Runnable() {
            public void run() {
                Password pass = db.passwordDAO().getPass(getArguments().getInt("pass_id"));
                view.post(new Runnable() {
                    public void run() {
                        name.setText(pass.nameOfStoredPass);
                        username.setText(pass.username);
                        String pass_txt = null;
                        try {
                            pass_txt = AESCrypt.decrypt(pass.password_text);
                            password.setText(pass_txt);
                        } catch (Exception e) {
                        }
                        date.setText(pass.setup_date);
                    }
                });
            }
        }).start();

        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient().newBuilder()
                      .build();
                RequestBody body = RequestBody.create(("{'text': '" + password.getText().toString() + "'}").getBytes());
                Request request = new Request.Builder()
                      .url("https://europe-west2-sylvan-triumph-314611.cloudfunctions.net/text2Speech")
                      .addHeader("Content-Type", "application/json")
                      .method("POST", body)
                      .build();


                client.newCall(request).enqueue(new Callback() {
                  @Override
                  public void onFailure(@NotNull Call call, @NotNull IOException e) {
                      e.printStackTrace();
                  }

                  @Override
                  public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                      if (response.isSuccessful()) {
                          String speech64 = response.body().string();
                          reproduceAudio(speech64);

                          /*v.post(new Runnable() { TODO: add change pause and play button
                              @Override
                              public void run() {
                              }
                          });*/
                      }
                  }
                    });
                }
            });

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavHostFragment.findNavController(PassDetailsFragment.this)
                                .navigate(R.id.action_ThirdFragment_to_FirstFragment);
                    }
                });
            }
    public void reproduceAudio(String speech64) {
        try{
            String url = "data:audio/mp3;base64,"+speech64;
            MediaPlayer mediaPlayer = new MediaPlayer();

            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setVolume(100f, 100f);
                mediaPlayer.setLooping(false);
            } catch (IllegalArgumentException e) {
                Toast.makeText(getActivity(), "You might not set the DataSource correctly!", Toast.LENGTH_LONG).show();
            } catch (SecurityException e) {
                Toast.makeText(getActivity(), "You might not set the DataSource correctly!", Toast.LENGTH_LONG).show();
            } catch (IllegalStateException e) {
                Toast.makeText(getActivity(), "You might not set the DataSource correctly!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer player) {
                    player.start();
                }
            });

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                }
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}