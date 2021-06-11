package com.example.contrasenyes_segures.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PasswordDAO {
    @Query("SELECT * FROM password")
    List<Password> getAll();

    @Query("SELECT * FROM password WHERE password_id = :id")
    Password getPass(int id);

    @Insert
    void insertPass(Password password);

    @Update
    void updatePass(Password password);

    @Delete
    void delete(Password password);
}