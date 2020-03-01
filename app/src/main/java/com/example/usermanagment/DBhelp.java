package com.example.usermanagment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    int version=1;
    String uid="uid";
    public  static  final String DATABASE_NAME="my_database";
    public  static  final String c1="FullName";
    public  static  final String c2="UserName";
    public  static  final String c3="Email";
    public  static  final String c4="Password";
    public  static  final String c5="Phone";
    public  static  final String c6="Gender";
    public  static  final String table_name="User";
    String create;
    Context context;

    public DBhelper(@Nullable Context context ) {
        super(context, "DATABASE_NAME", null, 1);
        create = "CREATE TABLE"+table_name+"("
                +uid+" VARCHAR(20) primary key,"
                +c1+" VARCHAR(20),"
                +c2+" VARCHAR(20),"
                +c3+" VARCHAR(20),"
                +c4+" VARCHAR(20),"
                +c5+" VARCHAR(20))"
                +c6+" VARCHAR(20),";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.exeSQL("CREATE TABLE" +table_name+ (FullName TEXT,UserName TEXT,Email TEXT,Password TEXT,Phone TEXT,Gender TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.exeSQL("DROP TABLE IF EXSITS"+table_name);
        onCreate(db);

    }
}
