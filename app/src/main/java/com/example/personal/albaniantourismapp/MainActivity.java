package com.example.personal.albaniantourismapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {
        private Button turizem, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turizem = (Button)findViewById(R.id.turizem);
        ConnectionDB lidhje = new ConnectionDB();
        lidhje.Conn();
        explore();
        administrator();
    }

    public void explore(){
        turizem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turizmi();
            }
        });
    }

    public void administrator(){
        turizem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin();
            }
        });
    }


    public void turizmi(){
        Intent intent = new Intent(this, Turizem.class);
        startActivity(intent);
    }


    public void admin(){
        Intent intent = new Intent(this, Administrator.class);
        startActivity(intent);
    }


}
