/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi1pbo;

/**
 *
 * @author hp
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MainLogistik {
    private static final String NAMA_FILE = "manifest_pengiriman.txt";

    public static void main(String[] args) {
        ArrayList<BarangBantuan> daftarBarang = new ArrayList<>();
        boolean selesai = false;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("\n===============================================");
                System.out.println(" SISTEM LOGISTIK PENDIDIKAN DAERAH 3T");
                System.out.println("===============================================");
                System.out.println("1. Tambah barang bantuan");
                System.out.println("2. Selesai dan cetak manifes");
                System.out.print("Pilih menu (1-2): ");

                int pilihan = bacaPilihan(scanner);
                switch (pilihan) {
                    case 1:
                        tambahBarang(scanner, daftarBarang);
                        break;
                    case 2:
                        selesai = cetakManifes(daftarBarang);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia. Masukkan angka 1 atau 2.");
                        break;
                }
            } while (!selesai);
        }
    }

    private static int bacaPilihan(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Pilihan harus berupa angka. Masukkan 1 atau 2: ");
            }
        }
    }

    private static void tambahBarang(Scanner scanner, ArrayList<BarangBantuan> daftarBarang) {
        boolean berhasil = false;

        while (!berhasil) {
            try {
                System.out.println("\n--- Input Barang Bantuan ---");
                System.out.print("Kode barang (diawali EDX-): ");
                String kode = scanner.nextLine();
                System.out.print("Nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Kategori barang: ");
                String kategori = scanner.nextLine();
                System.out.print("Berat barang (kg): ");
                double berat = Double.parseDouble(scanner.nextLine().trim());

                BarangBantuan barang = new BarangBantuan(kode, nama, kategori, berat);
                daftarBarang.add(barang);
                berhasil = true;
                System.out.println("Barang berhasil ditambahkan ke daftar muatan.");
            } catch (NumberFormatException e) {
                System.out.println("Input berat harus berupa angka. Silakan ulangi input barang.");
            } catch (BeratInvalidException e) {
                System.out.println("Validasi berat gagal: " + e.getMessage());
                System.out.println("Silakan ulangi input barang.");
            } catch (IllegalArgumentException e) {
                System.out.println("Validasi data gagal: " + e.getMessage());
                System.out.println("Silakan ulangi input barang.");
            } finally {
                System.out.println("Pemeriksaan input selesai.");
            }
        }
    }

    private static boolean cetakManifes(ArrayList<BarangBantuan> daftarBarang) {
        double totalBerat = 0.0;
        for (BarangBantuan barang : daftarBarang) {
            totalBerat += barang.getBeratKg();
        }

        String armada;
        if (totalBerat < 50.0) {
            armada = "Mobil Pickup";
        } else {
            armada = "Truk Ekspedisi";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
            writer.write("MANIFES PENGIRIMAN BANTUAN PENDIDIKAN DAERAH 3T");
            writer.newLine();
            writer.write("Tanggal cetak : " + LocalDateTime.now().format(formatter));
            writer.newLine();
            writer.write("============================================================");
            writer.newLine();
            writer.write("DAFTAR BARANG");
            writer.newLine();
            writer.write("No | Kode Barang | Nama Barang | Kategori | Berat (kg)");
            writer.newLine();
            writer.write("------------------------------------------------------------");
            writer.newLine();

            int nomor = 1;
            for (BarangBantuan barang : daftarBarang) {
                writer.write(String.format(Locale.US, "%d | %s | %s | %s | %.2f",
                        nomor,
                        barang.getKodeBarang(),
                        barang.getNamaBarang(),
                        barang.getKategori(),
                        barang.getBeratKg()));
                writer.newLine();
                nomor++;
            }

            writer.write("============================================================");
            writer.newLine();
            writer.write("Total barang : " + daftarBarang.size());
            writer.newLine();
            writer.write(String.format(Locale.US, "Total berat  : %.2f kg", totalBerat));
            writer.newLine();
            writer.write("Jenis armada : " + armada);
            writer.newLine();
            writer.write("Status       : Siap untuk proses pengiriman");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menulis manifes: " + e.getMessage());
            System.out.println("Program tetap berjalan. Periksa izin folder proyek.");
            return false;
        }

        System.out.println("\n--- Ringkasan Pengiriman ---");
        System.out.println("Total barang : " + daftarBarang.size());
        System.out.printf(Locale.US, "Total berat  : %.2f kg%n", totalBerat);
        System.out.println("Jenis armada : " + armada);
        System.out.println("Data manifes berhasil diekspor ke manifest_pengiriman.txt");
        return true;
    }
}