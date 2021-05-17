package com.example.contrasenyes_segures.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int user_id;

    @ColumnInfo(name = "master_password")
    public String master_password;

    @ColumnInfo(name = "idioma")
    public String idioma;
}
