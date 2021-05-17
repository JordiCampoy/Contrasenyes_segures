package com.example.contrasenyes_segures.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity
public class Password {
    @PrimaryKey(autoGenerate = true)
    public int password_id;

    @ColumnInfo(name = "nameOfStoredPass")
    public String nameOfStoredPass;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password_text")
    public String password_text;

    @ColumnInfo(name = "setup_date")
    public String setup_date;

}
