package com.example.madclasstaskassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.madclasstaskassignment.Params.Params;

import java.util.ArrayList;

public class DatabaseController extends SQLiteOpenHelper {
    public DatabaseController(@Nullable Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="create table " +
                Params.TABLE_NAME +
                "("+Params.COLUMN_ID+" int primary key, " +
                Params.COLUMN_NAME+" text, " +
                Params.COLUMN_ROLL_NUMBER+" int, " +
                Params.COLUMN_CONTACT+" text);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {    }

    void addStudent(Student student){
        SQLiteDatabase database=getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(Params.COLUMN_ROLL_NUMBER,student.getId());
        contentValues.put(Params.COLUMN_NAME,student.getName());
        contentValues.put(Params.COLUMN_CONTACT,student.getContact());

        database.insert(Params.TABLE_NAME,null,contentValues);
        database.close();

    }

    ArrayList<Student> arrayList = new ArrayList<>();



   ArrayList<Student> getAllStudent(){
       ArrayList<Student> lit = new ArrayList<>();

       SQLiteDatabase database= getReadableDatabase();
       String query="SELECT * FROM "+Params.TABLE_NAME+";";

       Cursor cursor=database.rawQuery(query,null);

       while(cursor.moveToNext()){
           Student student =new Student();
           student.setId(cursor.getInt(2));
           student.setName(cursor.getString(1));
           student.setContact(cursor.getString(3));

           lit.add(student);

       }

       cursor.close();
       database.close();
       return lit;
   }

   void updateStudent(Student student){
       SQLiteDatabase database=getWritableDatabase();

       ContentValues contentValues= new ContentValues();
       contentValues.put(Params.COLUMN_NAME,student.getName());
       contentValues.put(Params.COLUMN_ROLL_NUMBER,student.getId());
       contentValues.put(Params.COLUMN_CONTACT,student.getContact());

       database.update(Params.TABLE_NAME,contentValues,Params.COLUMN_ID+"=?",
               new String[]{String.valueOf(student.getId())});
       database.close();
   }

   void deleteStudent(Student student){
       SQLiteDatabase database=getWritableDatabase();
       database.delete(Params.TABLE_NAME,Params.COLUMN_ID+"=?",
               new String[]{String.valueOf(student.getId())});
       database.close();
   }

}
