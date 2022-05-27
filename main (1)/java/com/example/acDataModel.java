package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class acDataModel {
    public final Connection con;

    public acDataModel() {
        dbHelper db = new dbHelper();

        con = db.getConnection();
    }

    public void addRecord(ac data){
        PreparedStatement state = null;
        String query;

        query = "INSERT INTO\n" +
                "`dataac`(`id`, `tanggal_registrasi`, `jenis_ac`, `nama_barang`, `stok_barang`, `harga_barang`)\n" +
                "VALUES\n" +
                "(NULL,?,?,?,?,?);";

        try {
            state = con.prepareStatement(query);

            state.setString(1, data.getTanggal_transaksi());
            state.setString(2, data.getJenis_barang());
            state.setString(3, data.getNama_barang());
            state.setInt(4, data.getJumlah_stok());
            state.setInt(5, data.getHarga());

            state.execute();
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());;
        }
    }

    public ObservableList<ac> loadRecord(){
        ObservableList<ac> data = FXCollections.observableArrayList();
        ResultSet rs = null;
        String query;

        query = "SELECT * FROM dataac;";

        try {
            rs = con.createStatement().executeQuery(query);

            while (rs.next()){
                data.add(new ac(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
