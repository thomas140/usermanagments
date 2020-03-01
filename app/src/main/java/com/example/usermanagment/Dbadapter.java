package com.example.usermanagment;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class Dbadapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="user_info";
    private static final String tableName="reg_info";
    private static final int verion=2;
    private static final String id="_id";
    private static final String fullName="FullName";
    private static final String userName="UserName";
    private static final String Email="Email";
    private static final String gender="Gender";
    private static final String PhoneNo="Phone";
    private static final String Password="Password";
    String columns[]={id, fullName, userName, gender, Email, PhoneNo,Password};

    public Dbadapter(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int verion){
        super(context, dbName,factory,verion);
    }
//    public DBAdapter(Context context){
//        super(context,dbName,null,verion);
//    }

    public static String getId() {
        return id;
    }

    public Cursor query(String sql, String[] selectargs){
        SQLiteDatabase db= getWritableDatabase();
        return db.rawQuery(sql,selectargs);
    }
    public void insertData(String name, String userName, String gender,String Email, String PhoneNo,  String Password){
        SQLiteDatabase db= getWritableDatabase();
        String sql = "Insert into Students values(101," +name+ "varchar(30),"+ userName +"varchar(15)," +gender +"varchar(15),"+ Email+"varchar(20), "+PhoneNo +"varchar(15)," +Password+"varchar(15))" ;
        db.close();
    }
    public void insertRecord(String name, String userName, String gender,String Email, String PhoneNo,  String Password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.fullName,fullName);
        contentValues.put(this.userName,userName);
        contentValues.put(this.gender,gender);
        contentValues.put(this.Email,Email);
        contentValues.put(this.PhoneNo,PhoneNo);
        contentValues.put(this.Password,Password);
        db.insert(tableName,null ,contentValues);

    }

    public void updateData(String name, String userName, String gender,String Email, String PhoneNo,  String Password, int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql= "Update Students Set FullName= ?, username= ?, Gender= ?, Email= ?, PhoneNo= ?, Password= ? where id= ?";
        SQLiteStatement statement= db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, fullName);
        statement.bindString(2, userName);
        statement.bindString(3, gender);
        statement.bindString(4, Email);
        statement.bindString(5, PhoneNo);
        statement.bindString(6, Password);
        statement.bindDouble(7,(double)id);

        statement.execute();
        db.close();
    }
    public void deleteData(String fullName){
        SQLiteDatabase db= getWritableDatabase();
        db.delete(tableName,"fullName "+"=\"" + fullName+"\"", null);
        db.close();
    }
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    public Cursor getAllData(){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery("Select * from Students",null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE Students("+ getId() +" INTEGER PRIMARY KEY AUTOINCREMENT, FullName Text, username Text, Gender Text, Email Text, PhoneNo Text, Password Text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists "+ tableName);
        onCreate(db);
    }
}

