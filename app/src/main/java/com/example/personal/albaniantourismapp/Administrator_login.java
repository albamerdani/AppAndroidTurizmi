package com.example.personal.albaniantourismapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Administrator_login extends AppCompatActivity {
    private Button login;
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_login);

        login = (Button)findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logAdmin();
            }
        });
    }

    public void logAdmin(){

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        ConnectionDB connection = new ConnectionDB();
        Connection lidhje = connection.Conn();
        String user = "", pass = "";
            Statement st = null;
            try {
                st = lidhje.createStatement();
                ResultSet rs = st.executeQuery("select username, password from administratori");
                while(rs.next()){
                    user = rs.getString("username");
                    pass = rs.getString("password");
                }

                if((username.getText().toString()).equals(user) && (password.getText().toString()).equals(pass)) {
                    Intent log = new Intent(this, Administrator.class);
                    startActivity(log);
                }

                else if(username.getText().toString().equals("") || password.getText().toString().equals(""))
                    Toast.makeText(Administrator_login.this, "Vendos username dhe password!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Administrator_login.this, "Username dhe password nuk jane te sakte!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
