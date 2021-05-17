package com.example.contrasenyes_segures.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contrasenyes_segures.R;
import com.example.contrasenyes_segures.database.Password;

import java.util.List;

public class PassAdapter extends RecyclerView.Adapter<PassAdapter.ViewHolder> implements View.OnClickListener {

    private LayoutInflater inflater;
    private List<Password> passList;
    private View.OnClickListener listener;

    public PassAdapter(Context context, List<Password> dataSet) {
        this.inflater = LayoutInflater.from(context);
        this.passList = dataSet;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfStoredPass,date;

        public ViewHolder(View view) {
            super(view);

            nameOfStoredPass = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pass_item_layout, viewGroup, false);

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        String title = passList.get(position).nameOfStoredPass;
        String date = passList.get(position).setup_date;
        viewHolder.nameOfStoredPass.setText(title);
        viewHolder.date.setText(date);
    }

    @Override
    public int getItemCount() {
        if (passList != null) {
            return passList.size();
        } else {
            return 0;
        }
    }

}
