package com.example.contrasenyes_segures.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.contrasenyes_segures.R;
import com.example.contrasenyes_segures.cryptography.AESCrypt;
import com.example.contrasenyes_segures.database.PassDB;
import com.example.contrasenyes_segures.database.Password;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CreatePassFragment extends Fragment {

    private EditText nameField;
    private EditText usernameField;
    private EditText passwordField;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        nameField = (EditText) view.findViewById(R.id.editTextPassName);
        usernameField = (EditText) view.findViewById(R.id.editTextUsername);
        passwordField = (EditText) view.findViewById(R.id.editTextPassword);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameField.getText().toString();
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();


                PassDB db = Room.databaseBuilder(getActivity(), PassDB.class, "PassDB").build();

                Password pass = new Password();
                pass.nameOfStoredPass = name;
                pass.username = username;
                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                pass.setup_date = dateFormat.format(date);


                try {
                    password = AESCrypt.encrypt(password);
                    pass.password_text = password;
                    new Thread(new Runnable() {
                        public void run() {
                            db.passwordDAO().insertPass(pass);
                        }
                    }).start();
                    Toast.makeText(getActivity(),
                            "@string/correctCreation", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(),
                            "@string/incorrectCreation", Toast.LENGTH_SHORT)
                            .show();
                }


                NavHostFragment.findNavController(CreatePassFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });


        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CreatePassFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}