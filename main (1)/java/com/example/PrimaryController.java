package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {
    @FXML
    DatePicker tgl_registrasi;

    @FXML
    ComboBox<String> jenis_ac;

    @FXML
    TextField nama_barang;

    @FXML
    TextField harga_barang;

    @FXML
    TextField stok_barang;

    @FXML
    Button btn_simpan;
    @FXML
    private Button btn_lihat;

    @Deprecated
    public void initialize() {
        this.jenis_ac.getItems().addAll(
            "Split Wall",
            "Sentral",
            "Standing Floor",
            "Inverter",
            "Cassette",
            "Window"
        );
    }

    @FXML
    private void addData() {
        acDataModel dataModel = new acDataModel();
        ac data = new ac(tgl_registrasi.getValue().toString(), jenis_ac.getValue(), nama_barang.getText(), Integer.parseInt(harga_barang.getText()), Integer.parseInt(stok_barang.getText()));

        // Empty Form
        tgl_registrasi.getEditor().clear();
        nama_barang.setText("");
        harga_barang.setText("");
        stok_barang.setText("");

        dataModel.addRecord(data);
    }

    @FXML
    private void changeScene(){
        try {
            App.setRoot("datashow");
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }
    }
}
