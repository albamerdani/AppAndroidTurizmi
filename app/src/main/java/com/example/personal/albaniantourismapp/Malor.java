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

public class Malor extends AppCompatActivity {
    private Button akomodim_mal;
    private Button theth, razem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malor);

        vende_malore();
        akomodim_mal = (Button)findViewById(R.id.resort_mal);
        theth = (Button)findViewById(R.id.th);
        razem = (Button)findViewById(R.id.rz);

        akomodim_mal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resort_malor();
            }
        });
        theth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theth();
            }
        });
        razem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                razem();
            }
        });
    }

    ConnectionDB connection = new ConnectionDB();
    Connection lidhje = connection.Conn();

    public void vende_malore(){
        Statement st = null;

        try{
            st = lidhje.createStatement();
            ResultSet rs = st.executeQuery("SELECT (Vendi, Pershkrimi) FROM turizmi WHERE Lloji = 'malor'");

            while(rs.next()){
                System.out.println(rs.getString("Vendi"), rs.getString("Pershkrimi"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void resort_malor(){
        Intent int_mal = new Intent(this, Resorte_malore.class);
        startActivity(int_mal);
    }

    public void theth(){
        Intent th = new Intent(this, Theth.class);
        startActivity(th);
    }

    public void razem(){
        Intent rz = new Intent(this, Razem.class);
        startActivity(rz);
    }
}
