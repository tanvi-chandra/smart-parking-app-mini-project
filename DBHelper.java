package com.example.mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String dbname="login.db";

    public DBHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table users(username Text primary key,password Text)");
        DB.execSQL("create Table ParkC(city Text,slotc Text)");
        DB.execSQL("create Table Book(vehicle varchar(20),Fullname varchar(20),phone varchar(20),username Text,bid varchar(20) primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists users");
        DB.execSQL("drop Table if exists ParkC");
        DB.execSQL("drop Table if exists Book");

        onCreate(DB);
    }
    public Boolean inertData(String username,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long results=DB.insert("users",null,contentValues);
        DB.close();

        if(results==-1) {

            return false;
        }
        else
            return true;
    }
    public  Boolean insertPC(String city,String count){
        return true;
    }

    public  Boolean insertBook(String veh,String FlNm,String pho,String un,String bd){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("vehicle",veh);
        contentValues.put("Fullname",FlNm);
        contentValues.put("phone",pho);
        contentValues.put("username",un);
        contentValues.put("bid",bd);

        long result=db.insert("Book",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    /*public int getbid(){
        SQLiteDatabase rdb=this.getReadableDatabase();
        Cursor cursor=rdb.rawQuery("select bid from Book order by bid desc limit 1",null);
        int bidr;
        cursor.moveToFirst();
        bidr = cursor.getInt(0);
        rdb.close();
        return bidr;
    }*/
    public Cursor getBdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Book",null);
        return cursor;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select *from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public  Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
