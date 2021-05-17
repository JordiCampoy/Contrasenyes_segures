package com.example.contrasenyes_segures.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.contrasenyes_segures.R;
import com.example.contrasenyes_segures.adapters.PassAdapter;
import com.example.contrasenyes_segures.database.PassDB;
import com.example.contrasenyes_segures.database.Password;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PassListFragment extends Fragment {

    private RecyclerView recycler;
    private PassAdapter adapter;
    private List<Password> passwordList;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        PassDB db = Room.databaseBuilder(getActivity(), PassDB.class, "PassDB").build();

        new Thread(new Runnable() {
            public void run() {
                passwordList = db.passwordDAO().getAll();

                view.post(new Runnable() {
                    public void run() {
                        adapter = new PassAdapter(getContext(), passwordList);

                        recycler.setAdapter(adapter);
                        adapter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("pass_id", passwordList.get(recycler.getChildAdapterPosition(v)).password_id);
                                NavHostFragment.findNavController(PassListFragment.this)
                                        .navigate(R.id.action_FirstFragment_to_ThirdFragment, bundle);
                            }
                        });
                    }
                });
            }
        }).start();



        fab = view.findViewById(R.id.fab);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PassListFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

}