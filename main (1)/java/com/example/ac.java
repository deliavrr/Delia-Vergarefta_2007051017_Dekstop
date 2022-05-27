package com.example;

public class ac {
    private String tanggal_transaksi;
    private String jenis_barang;
    private String nama_barang;
    private int harga;
    private int jumlah_stok;

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah_stok() {
        return jumlah_stok;
    }

    public void setJumlah_stok(int jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    public ac(String tanggal_transaksi, String jenis_barang, String nama_barang, int harga, int jumlah_stok) {
        this.setTanggal_transaksi(tanggal_transaksi);
        this.setJenis_barang(jenis_barang);
        this.setNama_barang(nama_barang);
        this.setHarga(harga);
        this.setJumlah_stok(jumlah_stok);
    }
}
