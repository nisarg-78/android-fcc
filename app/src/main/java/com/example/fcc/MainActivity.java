package com.example.fcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // FORCED LIGHT MODE
        setContentView(R.layout.activity_main);

        Button btnIdiotScore = findViewById(R.id.btnIdiotScore);
        TextView tvIdiotScore = findViewById(R.id.tvIdiotScore);
        EditText etName = findViewById(R.id.etName);
        Button btnName = findViewById(R.id.btnName);
        TextView tvJoke = findViewById(R.id.tvJoke);
        ImageView ivJoke = findViewById(R.id.ivJoke);

        tvIdiotScore.setText("Welcome!");

        btnIdiotScore.setOnClickListener(view -> {
            Random r = new Random();
            int range = 101;
            int score =  r.nextInt(range);
            if (score < 10){
                Toast.makeText(getApplicationContext(),"YOU ARE DOM!",Toast.LENGTH_SHORT).show();
            }
            tvIdiotScore.setText(score + "/100");
        });

        btnName.setOnClickListener(view -> {
                System.out.println("Click");
                if(etName.getText().length() > 0){
                    tvJoke.setVisibility(View.VISIBLE);
                    ivJoke.setVisibility(View.VISIBLE);

                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    tvJoke.setVisibility(View.INVISIBLE);
                                    ivJoke.setVisibility(View.INVISIBLE);
                                }
                            },
                            5000
                    );

                }else{
                    Toast.makeText(getApplicationContext(),"YOU ARE DOM!",Toast.LENGTH_SHORT).show();
                }

        });
    }
}