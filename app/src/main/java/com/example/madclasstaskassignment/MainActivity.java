package com.example.madclasstaskassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText id,name,contact;
    private TextView txtView;
    private Button button;

    Student student1;

    DatabaseController database = new DatabaseController(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.txtId);
        name=findViewById(R.id.txtName);
        contact=findViewById(R.id.txtContact);



        txtView=findViewById(R.id.vRecorde);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String studentName=name.getText().toString();
                String studentContact=contact.getText().toString();
                int studentId=Integer.valueOf(id.getId());

                student1=new Student();
                student1.setId(studentId);
                student1.setName(studentName);
                student1.setContact(studentContact);

                database.addStudent(student1);

                Toast.makeText(MainActivity.this, "Add Data Successfuly", Toast.LENGTH_SHORT).show();
            }
        });
    }

}