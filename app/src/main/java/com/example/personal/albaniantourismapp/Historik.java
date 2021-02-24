package com.example.personal.albaniantourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Historik extends AppCompatActivity {
    private Button akomodim_histori;
    private Button shkoder, berat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historik);

        vende_historike();

        akomodim_histori = (Button)findViewById(R.id.resort_histori);
        shkoder = (Button)findViewById(R.id.sh);
        berat = (Button)findViewById(R.id.br);

        akomodim_histori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resort_histori();
            }
        });
        shkoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shkoder();
            }
        });
        berat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                berat();
            }
        });
    }

    ConnectionDB connection = new ConnectionDB();
    Connection lidhje = connection.Conn();

    public void vende_historike(){
        Statement st = null;

        try{
            st = lidhje.createStatement();
            ResultSet rs = st.executeQuery("SELECT (Vendi, Pershkrimi) FROM turizmi WHERE Lloji = 'historik'");

            while(rs.next()){
                System.out.println(rs.getString("Vendi"), rs.getString("Pershkrimi"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
    public void resort_histori(){
        Intent intent_histori = new Intent(this, Resorte.class);
        startActivity(intent_histori);
    }
    public void shkoder(){
        Intent sh = new Intent(this, Shkodra.class);
        startActivity(sh);
    }

    public void berat(){
        Intent br = new Intent(this, Berat.class);
        startActivity(br);
    }
}
