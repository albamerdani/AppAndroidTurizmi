package com.example.personal.albaniantourismapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Resorte_detar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resorte_detar);

        resorte_bregdetare();
    }

    ConnectionDB connection = new ConnectionDB();
    Connection lidhje = connection.Conn();

    public void resorte_bregdetare(){
        Statement st = null;
        Statement st2 = null;

        try{
            st = lidhje.createStatement();
            ResultSet rs = st.executeQuery("SELECT (Vendi) FROM turizmi WHERE Lloji = 'bregdetar'");
            while(rs.next()){
                String vendi = rs.getString("Vendi");
                ResultSet rs_id = st.executeQuery("SELECT (Id_Vendi) FROM turizmi WHERE Vendi = ?", vendi);
                int id = rs_id.getInt("Id_Vendi");

                st2 = lidhje.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT (Resorti,Rankimi,Sherbime) FROM akomodimimi WHERE Id_Vendi = ?", id);
                while(rs2.next()){
                    System.out.println(rs.getString("Vendi"), rs2.getString("Resorti"),rs2.getString("Rankimi"),rs2.getString("Sherbime"));
                }
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
