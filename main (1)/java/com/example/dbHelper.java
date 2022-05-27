package com.example;

import java.sql.*;

public class dbHelper {
    Connection con = null;

    public Connection getConnection(){
        try{
            // Pilih class database yang hendak digunakan
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataac", "root", "");
            System.out.println("Success!");

            return con;
        }catch(Exception e){
            System.out.println("Connection Failed : " + e);

            return null;
        }
    }

    public void createTable(){
        Connection con = getConnection();
        PreparedStatement state = null;

        String query;

        try{
            query = "CREATE TABLE IF NOT EXIST dataac(\n" +
                    " id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,\n" +
                    " tanggal_registrasi DATE NOT NULL,\n" +
                    " jenis_ac VARCHAR(255) NOT NULL,\n" +
                    " nama_barang VARCHAR(255) NOT NULL,\n" +
                    " stok_barang INT NOT NULL,\n" +
                    " harga_barang INT NOT NULL\n" +
                    ");";

            state = con.prepareStatement(query);
            state.execute();
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
