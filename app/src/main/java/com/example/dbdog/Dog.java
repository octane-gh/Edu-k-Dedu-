package com.example.dbdog;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "DogDB")
public class Dog {
    @PrimaryKey
    @NonNull
    int id;
    @ColumnInfo(name = "high")
    int high;
   @ColumnInfo(name = "fur")
    String fur; //шерсть
   @ColumnInfo(name = "colour")
    String colour;
  @ColumnInfo(name = "weight")
    int weight;

    public Dog(int high, String fur, String colour, int weight, int id) {
       this.id = id;
        this.high = high;
        this.fur = fur;
        this.colour = colour;
        this.weight = weight;
    }
}

