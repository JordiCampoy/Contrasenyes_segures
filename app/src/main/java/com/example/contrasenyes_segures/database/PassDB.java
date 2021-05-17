package com.example.contrasenyes_segures.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Password.class}, version = 1)
public abstract class PassDB extends RoomDatabase {
    public abstract PasswordDAO passwordDAO();
    public abstract UserDAO userDAO();

    public static final String NAME = "passDB";

}