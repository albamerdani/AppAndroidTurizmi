package com.example.personal.albaniantourismapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrator extends AppCompatActivity {
    private Button shto, ndrysho, fshi;
    private EditText lloji, vendi, pershkrimi, pika_turistike, aktivitete, resorti, sherbime;
    RatingBar rankimi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        shto = (Button)findViewById(R.id.shto);
        ndrysho = (Button)findViewById(R.id.ndrysho);
        fshi = (Button)findViewById(R.id.fshi);
        lloji = (EditText)findViewById(R.id.lloji);
        vendi = (EditText)findViewById(R.id.vendi);
        pershkrimi = (EditText)findViewById(R.id.pershkrimi);
        pika_turistike = (EditText)findViewById(R.id.pika);
        aktivitete = (EditText)findViewById(R.id.aktivitete);
        resorti = (EditText)findViewById(R.id.resorti);
        rankimi = (RatingBar) findViewById(R.id.rankimi);
        sherbime = (EditText)findViewById(R.id.sherbime);

        String type = lloji.getText().toString();
        String place = vendi.getText().toString();
        String shkrimi = pershkrimi.getText().toString();
        String pika = pika_turistike.getText().toString();
        String activity = aktivitete.getText().toString();
        String hotel = resorti.getText().toString();
        String rank = rankimi.getResources().toString();
        String service = sherbime.getText().toString();

        shto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shto();
            }
        });

        ndrysho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ndrysho();
            }
        });

        fshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fshi();
            }
        });
    }

    ConnectionDB connection = new ConnectionDB();
    Connection lidhje = connection.Conn();

    public void shto(){
        Statement st = null;
        Statement st_resort = null;
        try{

            st = lidhje.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO turizmi(Lloji, Vendi, Pershkrimi, Pika turistike, Veprimtari) VALUES(type, place, shkrimi, pika, activity)");

            st_resort = lidhje.createStatement();
            ResultSet rs_resort = st_resort.executeQuery("INSERT INTO akomodimi(Resorti, Rankimi, Sherbime) VALUES(hotel, rank, service)");
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void ndrysho(){
        Statement st2 = null;
        Statement st3 = null;
        try{

            st2 = lidhje.createStatement();
            ResultSet rs2 = st2.executeQuery("UPDATE turizmi SET (Pika turistike, Veprimtari) VALUES(pika, activity)");

            st3 = lidhje.createStatement();
            ResultSet rs3 = st3.executeQuery("UPDATE akomodimi SET (Sherbime) VALUES(service)");
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public void fshi(){
        Statement st4 = null;
        Statement st5 = null;
        try{
            if(!(vendi.equals(""))) {
                st4 = lidhje.createStatement();
                ResultSet rs4 = st4.executeQuery("DELETE * FROM turizmi WHERE Vendi = 'place'");
            }
            if(!(resorti.equals(""))) {
                st5 = lidhje.createStatement();
                ResultSet rs_resort = st5.executeQuery("DELETE * FROM akomodimi WHERE Resorti = 'hotel'");
            }

            else
                Toast.makeText(Administrator.this, "Ju nuk keni plotesuar emrin e vendit ose resortit per te fshire te dhenat!", Toast.LENGTH_LONG).show();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
