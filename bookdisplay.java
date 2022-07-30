package com.example.mad_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class bookdisplay extends AppCompatActivity {
    DBHelper db=new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdisplay);
        Cursor cursor=db.getBdata();
        if(cursor.getCount()==0)
            Toast.makeText(bookdisplay.this, "No data found", Toast.LENGTH_LONG).show();

        StringBuffer stringBuffer=new StringBuffer();
            while (cursor.moveToNext()){
                stringBuffer.append("Vehicle Number--->"+cursor.getString(0)+"\n");
                stringBuffer.append("Full Name---->"+cursor.getString(1)+"\n");
                stringBuffer.append("Phone------->"+cursor.getString(2)+"\n");
                stringBuffer.append("Username--->"+cursor.getString(3)+"\n");
                stringBuffer.append("Booking ID---->"+cursor.getString(4)+"\n");

                stringBuffer.append("\n");

        }
        AlertDialog.Builder builder=new AlertDialog.Builder(bookdisplay.this);
        builder.setCancelable(true);
        builder.setTitle("Your Bookings");

        builder.setMessage(stringBuffer.toString());
        builder.show();
    }
}