package com.anything.roompersistencelibrary;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    TextInputLayout userName,Email,description;
    Button btnAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userName = (TextInputLayout) findViewById(R.id.userName);
        Email = (TextInputLayout) findViewById(R.id.email);
        description = (TextInputLayout) findViewById(R.id.description);
        btnAddUser = (Button) findViewById(R.id.btnAddUser);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries().build();



        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i <1 ; i++) {
                    db.userDao().insertAll(new User(userName.getEditText().getText().toString(),
                            description.getEditText().getText().toString(),
                            Email.getEditText().getText().toString()));
                }
                
                startActivity(new Intent(UserActivity.this,MainActivity.class));
            }
        });

    }
}
