package com.example.usermanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _register;
    EditText _txtFullName,_txtUserName,_txtEmail,_txtPassword,_txtPhone,_txtGender;

    RecyclerView recyclerView;
    List userlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DBhelper(this);
        _register=(Button)findViewById(R.id.register);
        _txtFullName=(EditText)findViewById(R.id.FullName);
        _txtUserName=(EditText)findViewById(R.id.txtUserName);
        _txtEmail=(EditText)findViewById(R.id.txtEmail);
        _txtPassword=(EditText)findViewById(R.id.txtPassword);
        _txtPhone=(EditText)findViewById(R.id.txtPhone);
        _txtGender=(EditText)findViewById(R.id.txtgender);
        _register.set.OnClickListener(new_OnClickListener()){
            @Override
            public void onClick(View v){
                db=openHelper.getWritableDatabase();
                String FullName=_txtFullName.getText().toString();
                String UserName=_txtUserName.getText().toString();
                String Email=_txtEmail.getText().toString();
                String Password=_txtPassword.getText().toString();
                String phone=_txtPhone.getText().toString();
                String Gender=_txtGender.getText().toString();


            }

        }
        public void insertdata(String FullName, String UserName, String Email, String Password, String Phone,String gender)
        ContentValues contentValues = new ContentValues()
        contentValues.put(DBhelper.c1,_txtFullName);
        contentValues.put(DBhelper.c2,_txtUserName);
        contentValues.put(DBhelper.c3,_txtEmail);
        contentValues.put(DBhelper.c4,_txtPassword);
        contentValues.put(DBhelper.c5,_txtPhone);
        contentValues.put(DBhelper.c6,_txtGender);
        long id = db.insert(DBhelper.)

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        userlist=new ArrayList();
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        userlist.add(new User("Abebe","abe@gmail.com","1212","090908987","abe","male"));
        AdapterUser adapterUser=new AdapterUser(getApplicationContext(),userlist);
        recyclerView.setAdapter(adapterUser);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Intent intent=new Intent(getApplicationContext(),UserDetail.class);
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }
}
