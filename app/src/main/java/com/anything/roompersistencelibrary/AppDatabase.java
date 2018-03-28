package com.anything.roompersistencelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.os.Build;

import junit.runner.Version;

/**
 * Created by ambar on 28/3/18.
 */
@Database(entities = {User.class,},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();


}
