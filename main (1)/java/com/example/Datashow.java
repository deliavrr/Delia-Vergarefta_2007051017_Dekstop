package com.example;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Datashow {
    @javafx.fxml.FXML
    private TableColumn<ac, String> nama;
    @javafx.fxml.FXML
    private TableColumn<ac, Integer> harga;
    @javafx.fxml.FXML
    private TableView<ac> tbl_barang;
    @javafx.fxml.FXML
    private TableColumn<ac, String> jenis;
    @javafx.fxml.FXML
    private Button btn_back;
    @javafx.fxml.FXML
    private TableColumn<ac, String> tanggal;
    @javafx.fxml.FXML
    private TableColumn<ac, Integer> stok;

    @Deprecated
    public void initialize() {
        acDataModel datamodel = new acDataModel();

        try{
            ObservableList<ac> data = datamodel.loadRecord();
            tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal_transaksi"));
            jenis.setCellValueFactory(new PropertyValueFactory<>("jenis_barang"));
            nama.setCellValueFactory(new PropertyValueFactory<>("nama_barang"));
            stok.setCellValueFactory(new PropertyValueFactory<>("jumlah_stok"));
            harga.setCellValueFactory(new PropertyValueFactory<>("harga"));

            tbl_barang.setItems(null);
            tbl_barang.setItems(data);
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

    @FXML
    private void changeScene(){
        try {
            App.setRoot("primary");
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }
    }
}
