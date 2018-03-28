package com.anything.roompersistencelibrary;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
  //  ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        users = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            User user = new User("Ambar","ambar.ara123@gmail.com","programmer");
//            users.add(user);
//        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,
                "production").allowMainThreadQueries().build();
        List<User> users= db.userDao().getAllUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new UserAdapter(users);

        recyclerView.setAdapter(recyclerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserActivity.class));
            }
        });
    }

}
