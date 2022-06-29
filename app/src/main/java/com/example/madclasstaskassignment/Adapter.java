package com.example.madclasstaskassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context context;
    DatabaseController d;
    ArrayList<Student> studentsList;

    public Adapter(ArrayList<Student> student, Context context) {
        this.studentsList=student;
        this.context = context;
    }

    @NonNull
    @Override

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout, parent, false);
        myViewHolder vh = new myViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.id.setText(""+studentsList.get(position).getId());
        holder.name.setText(studentsList.get(position).getName());
        holder.rollNo.setText(studentsList.get(position).getContact());


    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, rollNo, id;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sName);
            rollNo = itemView.findViewById(R.id.rNumber);
            id = itemView.findViewById(R.id.sid);
        }
    }
}
