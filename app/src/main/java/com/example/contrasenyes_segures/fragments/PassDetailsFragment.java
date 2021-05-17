package com.example.contrasenyes_segures.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.contrasenyes_segures.R;
import com.example.contrasenyes_segures.cryptography.AESCrypt;
import com.example.contrasenyes_segures.database.PassDB;
import com.example.contrasenyes_segures.database.Password;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PassDetailsFragment extends Fragment {

    private TextView name;
    private TextView username;
    private TextView password;
    private TextView date;
    private FloatingActionButton fab;

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PassDetailsFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
    }

}
