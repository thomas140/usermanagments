package com.example.usermanagment;


import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.usermanagment.TableData.TableInfo;

import java.util.ArrayList;


public  class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version=1;
    public String CREATE_QUERY=" CREATE TABLE "+ TableData.TableInfo.TABLE_NAME +
            "("+TableData.TableInfo.FullName" TEXT,"+

            TableData.TableInfo.UserName+" TEXT,"+

            TableInfo.Email +" TEXT,"+

            TableData.TableInfo.Password+" INTEGER,"+

            TableData.TableInfo.Phone+" TEXT,"+

            TableData.TableInfo.Gender+" TEXT,");";


    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME,
                null,database_version);
        Log.d("Database operations","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public void putInformation(DatabaseOperations dop,String fn,String sn,
                               String ln,String pn,String gender,
                               String username,String email,String pass)

    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.FullName,fn);
        cv.put(TableData.TableInfo.UserName,sn);
        cv.put(TableData.TableInfo.Email,email);
        cv.put(TableData.TableInfo.Password,pass);
        cv.put(TableData.TableInfo.Phone,pn);
        cv.put(TableData.TableInfo.Gender,gender);


        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operation","one raw inserted");
    }
    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ= dop.getReadableDatabase();
        String[] coloumns = {TableData.TableInfo.FullName, TableData.TableInfo.UserName,
                TableData.TableInfo.Email, TableData.TableInfo.Password, TableData.TableInfo.Phone,
                TableData.TableInfo.Gender,};
        Cursor CR=SQ.query(TableData.TableInfo.TABLE_NAME,coloumns,null,null,null,null,null);

        return CR;
    }
    public ArrayList<TableModel> getAllUsers() {
        ArrayList<TableModel> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TableData.TableInfo.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                TableModel u = new TableModel();
                u.setFullname(cursor.getString(1));
                u.setUsername(cursor.getString(2));
                users.add(u);
            }
            cursor.close();


        }
        return users ;
    }
}



