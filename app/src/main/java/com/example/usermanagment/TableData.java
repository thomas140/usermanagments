package com.example.usermanagment;
import android.provider.BaseColumns;

public class TableData extends Object {

    public TableData()
    {
    }



    public  static abstract class TableInfo implements BaseColumns
    {
        public static final String FullName="fullName";
        public static final String UserName="userName";
        public static final String Email="Email";
        public static final String Password="Password";
        public static final String Phone="Phone";
        public static final String Gender="Gender";
        public static final String TABLE_NAME="reg_info";
        public static final String DATABASE_NAME="user_info";

    }



