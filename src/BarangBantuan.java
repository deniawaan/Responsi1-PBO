/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi1pbo;

/**
 *
 * @author hp
 */
public class BarangBantuan {
    private final String kodeBarang;
    private final String namaBarang;
    private final String kategori;
    private final double beratKg;

    public BarangBantuan(String kodeBarang, String namaBarang, String kategori, double beratKg)
            throws BeratInvalidException {
        if (kodeBarang == null || !kodeBarang.startsWith("EDX-")) {
            throw new IllegalArgumentException("Kode barang harus diawali EDX-");
        }
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        if (kategori == null || kategori.trim().isEmpty()) {
            throw new IllegalArgumentException("Kategori barang tidak boleh kosong.");
        }
        if (!Double.isFinite(beratKg) || beratKg <= 0) {
            throw new BeratInvalidException("Berat barang harus lebih dari 0 kg dan berupa angka yang valid.");
        }

        this.kodeBarang = kodeBarang.trim();
        this.namaBarang = namaBarang.trim();
        this.kategori = kategori.trim();
        this.beratKg = beratKg;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public double getBeratKg() {
        return beratKg;
    }
}
