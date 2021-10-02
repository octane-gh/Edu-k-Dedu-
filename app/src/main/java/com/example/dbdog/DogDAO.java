package com.example.dbdog;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogDAO {

    @Query("SELECT * FROM DogDB")
    List<Dog> getAll();

    @Insert
    void addDog(Dog dogs);

    @Query("SELECT MAX(id) FROM DogDB")
    int getMaxId();

    @Delete
    void deleteAll(Dog...dogs);

}
