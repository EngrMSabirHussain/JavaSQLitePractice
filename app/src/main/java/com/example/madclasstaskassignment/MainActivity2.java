package com.example.madclasstaskassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Adapter adapter;
    RecyclerView recyclerView;
    DatabaseController d;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        d= new DatabaseController(MainActivity2.this);

        recyclerView=findViewById(R.id.rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));

        ArrayList<Student> student=d.getAllStudent();
        adapter= new Adapter(d.getAllStudent(),MainActivity2.this);
        recyclerView.setAdapter(adapter);
    }
}