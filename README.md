RESPONSI 1 PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK
SISTEM LOGISTIK PENDIDIKAN DAERAH 3T

Nama: Deni Septiawan
NIM : L0325020

GAMBARAN PROGRAM
Program Sistem Logistik Pendidikan Daerah 3T digunakan untuk mencatat barang bantuan
pendidikan yang akan dikirim ke sekolah-sekolah di daerah 3T. Pengguna dapat memasukkan
kode, nama, kategori, dan berat setiap barang melalui menu di konsol.

Setiap barang harus memiliki kode yang diawali "EDX-" dan berat lebih dari 0 kg. Jika data
tidak sesuai atau berat bukan angka, program menampilkan pesan kesalahan dan meminta
pengguna mengisi data kembali. Barang yang valid disimpan dalam daftar selama program
berjalan.

Setelah pendataan selesai, program menghitung jumlah barang dan total berat seluruh muatan.
Jika total berat kurang dari 50 kg, armada yang dipilih adalah Mobil Pickup. Jika total berat
mencapai atau melebihi 50 kg, armada yang dipilih adalah Truk Ekspedisi.

Data barang dan ringkasan pengiriman kemudian ditulis ke file manifest_pengiriman.txt.
File manifes berisi daftar barang, jumlah barang, total berat, dan jenis armada.

BERKAS PROGRAM
- src/BarangBantuan.java
  Menyimpan informasi setiap barang bantuan dan memeriksa validitas datanya.

- src/BeratInvalidException.java
  Menangani kondisi ketika berat barang tidak valid.

- src/MainLogistik.java
  Menjalankan menu, menerima input, menyimpan daftar barang, menghitung muatan,
  menentukan armada, dan membuat file manifes.

- manifest_pengiriman.txt
  Contoh dokumen manifes yang dihasilkan oleh program.

Program ini menerapkan konsep class dan object, constructor, tipe data, percabangan,
perulangan, ArrayList, exception handling, serta File I/O dalam satu aplikasi konsol sederhana.
