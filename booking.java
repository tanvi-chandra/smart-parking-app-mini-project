package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class booking extends AppCompatActivity {
    EditText vhn,FN,pno,bid;
    TextView ct;
    Button book;
    DBHelper db=new DBHelper(this);
   Login ln=new Login();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        getSupportActionBar().hide();
        vhn=(EditText) findViewById(R.id.vn);
        FN=(EditText) findViewById(R.id.fn);
        pno=(EditText) findViewById(R.id.phno);
        bid=(EditText) findViewById(R.id.bid);
        ct=(EditText) findViewById(R.id.city);
        Intent in=getIntent();
        String cn=in.getStringExtra("city");
        ct.setText("Mangalore");
        //bid.setEnabled(false);
        book=(Button) findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vnn=vhn.getText().toString();
                String fn=FN.getText().toString();
                String phone=pno.getText().toString();
                String bbid=bid.getText().toString();

                String un="aaaaaa";
                Log.i("un",un);
                if(vnn.equals("")||fn.equals("")||phone.equals("")||bbid.equals("")){
                    Toast.makeText(booking.this, "Please enter all the details", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean insertB=db.insertBook(vnn,fn,phone,un,bbid);

                    if(insertB){
                        Toast.makeText(booking.this, "Your Slot is Booked**", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),bookdisplay.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(booking.this, "Your Slot is not Booked**", Toast.LENGTH_LONG).show();
                    }
                }



            }
        });
    }
}