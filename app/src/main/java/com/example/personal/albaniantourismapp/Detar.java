package com.example.personal.albaniantourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detar extends AppCompatActivity {

    private Button akomodim_det;
    private Button pogradec, dhermi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detar);

        vende_bregdetare();
        akomodim_det = (Button)findViewById(R.id.resort_det);
        pogradec = (Button)findViewById(R.id.pg);
        dhermi = (Button)findViewById(R.id.dhr);

        akomodim_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resort_detar();
            }
        });

        pogradec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pogradec();
            }
        });

        dhermi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dhermi();
            }
        });
    }

    ConnectionDB connection = new ConnectionDB();
    Connection lidhje = connection.Conn();

    public void vende_bregdetare(){
        Statement st = null;

        try{
                st = lidhje.createStatement();
                ResultSet rs = st.executeQuery("SELECT (Vendi, Pershkrimi) FROM turizmi WHERE Lloji = 'bregdetar'");

                    while(rs.next()){
                    System.out.println(rs.getString("Vendi"), rs.getString("Pershkrimi"));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }


    public void resort_detar(){
        Intent intent_det = new Intent(this, Resorte_detar.class);
        startActivity(intent_det);
    }

    public void pogradec(){
        Intent pg = new Intent(this, Pogradec.class);
        startActivity(pg);
    }

    public void dhermi(){
        Intent dh = new Intent(this, Dhermi.class);
        startActivity(dh);
    }
}
