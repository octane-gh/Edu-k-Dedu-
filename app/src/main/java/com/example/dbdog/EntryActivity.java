package com.example.dbdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EntryActivity extends AppCompatActivity {


    private MaterialButton btnNext;
    private TextInputLayout layoutHigh;
    private TextInputLayout layoutWeight;
    private TextInputLayout layoutFur;
    private TextInputLayout layoutColour;
    private TextInputEditText editTextHigh;
    private TextInputEditText editTextWeight;
    private TextInputEditText editTextFur;
    private TextInputEditText editTextColour;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        db = AppDatabase.create(this, false);

        btnNext = findViewById(R.id.next_button);
        layoutHigh = findViewById(R.id.height_text_input);
        layoutWeight = findViewById(R.id.weight_text_input);
        layoutFur = findViewById(R.id.fur_layout);
        layoutColour = findViewById(R.id.colout_text_input);
        editTextHigh = findViewById(R.id.height_edit_text);
        editTextWeight = findViewById(R.id.weight_edit_text);
        editTextFur = findViewById(R.id.fur_edit_text);
        editTextColour = findViewById(R.id.colour_edit_text);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int textHigh = Integer.parseInt(editTextHigh.getText().toString());
                int textFury  = Integer.getInteger(editTextFur.getText().toString());
                editTextColour.getText().toString();
                Integer.valueOf(editTextWeight.toString();
                addDog(view);



            }
        });
    }



        public void addDog(View v){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    DogDAO dogDAO = db.dogDAO();
                    dogDAO.addDog(new Dog(Integer.parseInt(editTextHigh.getText().toString()), editTextFur.getText().toString(), editTextColour.getText().toString(), Integer.valueOf(editTextWeight.toString()), dogDAO.getMaxId() + 1 ));
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }
            }).start();}

            public void deleteDB(){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DogDAO dogDAO = db.dogDAO();
                        dogDAO.deleteAll();
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        startActivity(intent);
                    }
                }).start();
            }



    }
