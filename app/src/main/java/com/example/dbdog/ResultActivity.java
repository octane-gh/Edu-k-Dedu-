package com.example.dbdog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {


    private ListAdapter adapter;
    private RecyclerView listDog;
    private AppDatabase dogDB;
    private List<Dog> dogs;
    private List<ItemView> listItemDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listDog = findViewById(R.id.list_dog);
        listDog.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listItemDog = new ArrayList<ItemView>();

        Intent intent = getIntent();
        ArrayList<Dog> intentList = new ArrayList<Dog>();
        //intentList.add( );
        dogs = intentList;
        getItem();





    }


    public void generateDogs(Dog dog) {
        ItemView itemViewDog = new ItemView("Black", "White", 1, 1);
        Toast.makeText(getApplicationContext(), String.valueOf(dog.weight), Toast.LENGTH_LONG).show();
        if (dog.weight <= 3) {
            itemViewDog.weight = dog.weight;
        } else if (3 < dog.weight && dog.weight <= 15) {
            itemViewDog.weight = dog.weight - 3;
        } else if (16 <= dog.weight && dog.weight <= 30) {
            itemViewDog.weight = dog.weight - 4;
        } else if (31 <= dog.weight && dog.weight <= 150) {
            itemViewDog.weight = dog.weight - 6;
        }

        if (dog.high < 14)
            itemViewDog.high = 14;
        else if (14 <= dog.high && dog.high < 31) {
            itemViewDog.high = dog.high - 4;
        } else if (31 <= dog.high && dog.high <= 50) {
            itemViewDog.high = dog.high - 5;
        } else if (51 <= dog.high && dog.high <= 79) {
            itemViewDog.high = dog.high - 6;
        }
        listItemDog.add(itemViewDog);




    }

    public void getItem() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DogDAO dogDAO = dogDB.dogDAO();
                dogs = dogDAO.getAll();
                setAdapter(listItemDog);
                generateDogs(dogs.get(0));
            }
        }).start();

        return ;
    }

    public void setAdapter(List<ItemView> dogs) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new ListAdapter(dogs);
                listDog.setAdapter(adapter);
            }
        });
    }


   /* public void addDog(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DogDAO dogDAO = dogDB.dogDAO();
                dogDAO.addDog(new Dog(dogDAO.getMaxId() + 1, 5, "Шерсточка", "Black", 66));
                setUpdatableApter(dogs, new Dog(dogDAO.getMaxId() + 1, 6, "Шерсточка", "Black", 66));

            }
        }).start();
    }*/


    public void setUpdatableApter(List<Dog> dogs, Dog dog) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dogs.add(dog);
                adapter.notifyDataSetChanged();
            }
        });
    }
}