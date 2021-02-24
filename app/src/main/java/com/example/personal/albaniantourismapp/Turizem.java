package com.example.personal.albaniantourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Turizem extends AppCompatActivity {
    private Button sea, mountain, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turizem);

        sea = (Button)findViewById(R.id.bregdetar);
        mountain = (Button)findViewById(R.id.malor);
        history = (Button)findViewById(R.id.historik);

    turizemDetar();
    turizemMalor();
    turizemHistorik();

}

    public void turizemDetar(){
        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turizmiDetar();
            }
        });
    }

    public void turizmiDetar(){
        Intent intent = new Intent(this, Detar.class);
        startActivity(intent);

    }

    public void turizemMalor(){
        mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turizmiMalor();
            }
        });
    }

    public void turizmiMalor(){
        Intent intent = new Intent(this, Malor.class);
        startActivity(intent);

    }

    public void turizemHistorik(){
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turizmiHistorik();
            }
        });
    }

    public void turizmiHistorik(){
        Intent intent = new Intent(this,Historik.class);
        startActivity(intent);

    }
}
