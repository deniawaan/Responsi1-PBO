RESPONSI 1 PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK
Sistem Logistik Pendidikan Daerah 3T

IDENTITAS
Nama : Deni Septiawan
NIM  : L0325020

ISI PROYEK
src/BarangBantuan.java          : class entitas data barang bantuan
src/BeratInvalidException.java : custom exception untuk berat tidak valid
src/MainLogistik.java          : menu, validasi input, perhitungan, dan ekspor manifes
manifest_pengiriman.txt        : contoh manifes hasil pengujian

CARA MENJALANKAN DENGAN JDK
1. Buka terminal pada folder Responsi1_Logistik.
2. Kompilasi semua file Java:
   javac -d out src/*.java
3. Jalankan program:
   java -cp out MainLogistik
4. Pilih menu 1 untuk menambahkan barang. Ulangi jika ingin menambah barang lain.
5. Pilih menu 2 untuk menyelesaikan pendataan dan membuat manifest_pengiriman.txt.

File manifest_pengiriman.txt disimpan pada folder kerja tempat program dijalankan.
Jika program dijalankan dari folder proyek, file manifes dibuat di folder proyek tersebut.
