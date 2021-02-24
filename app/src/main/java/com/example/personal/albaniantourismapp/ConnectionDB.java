package com.example.personal.albaniantourismapp;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Personal on 14-Sep-17.
 */

public class ConnectionDB {

    String klase = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/android_app_turizmi";
    String username = "root";
    String password = "";

    public Connection Conn(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String conn_url = null;
        try{
            Class.forName(klase);
            conn = DriverManager.getConnection(url, username, password);
            conn = DriverManager.getConnection(conn_url);

            if(conn == null){
               System.out.println("Nuk u vendos lidhja");
            }

        }//catch (ConnectException ce){
          //  Log.e("ERROR", ce.getMessage());
        //}

        //catch (SocketException se){
          //  Log.e("ERROR", se.getMessage());
        //}
        catch (SQLException se){
            Log.e("ERROR", se.getMessage());
        }catch (ClassNotFoundException e){
            Log.e("ERROR", e.getMessage());
        }catch (Exception e){
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }

}
