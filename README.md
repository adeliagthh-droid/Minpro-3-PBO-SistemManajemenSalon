# Sistem Manajemen Salon

## Identitas Mahasiswa

**Nama:** ADELIA GITHA NAVEEZHA HERMAWAN

**NIM:** 2509116110

## 1. Deskripsi Singkat Program

Sistem Manajemen Salon merupakan program aplikasi berbasis konsol (Command Line Interface) yang dibuat menggunakan bahasa pemrograman Java dengan menerapkan prinsip Pemrograman Berorientasi Objek. Program ini merupakan pengembangan lanjutan dari Mini Project 2.

Sebuah salon kecantikan setiap harinya melayani banyak pelanggan dengan berbagai jenis perawatan, mulai dari potong rambut, creambath, smoothing, facial, hingga manicure pedicure. Apabila seluruh data tersebut dicatat secara manual, pengelola salon akan kesulitan ketika ingin mencari, mengubah, maupun menghapus data tertentu. Oleh karena itu program ini dibuat agar pencatatan data salon menjadi lebih teratur dan lebih cepat.

Terdapat tiga data utama yang dikelola oleh program ini. Data pertama adalah data pelanggan yang berisi ID pelanggan, nama, dan nomor telepon. Data kedua adalah data layanan yang berisi ID layanan, nama layanan, kategori, dan harga. Data ketiga adalah data reservasi yang berisi ID reservasi, pelanggan yang memesan, layanan yang dipesan, dan tanggal reservasi.

Pada ketiga data tersebut pengguna dapat menambah data baru, menampilkan seluruh data, mengubah data yang sudah ada, dan menghapus data. Seluruh data disimpan menggunakan ArrayList sehingga jumlahnya dapat bertambah maupun berkurang selama program dijalankan.

## 2. Pengembangan dari Mini Project 2

Pada Mini Project 3 ini terdapat empat pengembangan utama dibandingkan versi sebelumnya.

Pengembangan pertama adalah penerapan abstraction. Class Layanan yang sebelumnya merupakan class biasa kini diubah menjadi abstract class yang memiliki abstract method, sehingga class tersebut tidak dapat lagi dibuat objeknya secara langsung.

Pengembangan kedua adalah penerapan struktur proyek MVC. Seluruh kode program yang sebelumnya menumpuk di dalam satu class utama kini dipisahkan ke dalam empat package sesuai perannya masing-masing.

Pengembangan ketiga adalah penerapan interface sebagai nilai tambah. Interface digunakan sebagai kontrak aturan yang wajib dipenuhi oleh seluruh class controller.

Pengembangan keempat adalah perbaikan pada proses hapus data. Pada versi sebelumnya, ketika pelanggan atau layanan dihapus, data reservasi yang terhubung dengan data tersebut masih tertinggal di dalam daftar reservasi. Pada versi ini data reservasi yang terkait ikut terhapus secara otomatis.

Selain itu penamaan package dan class utama juga diperbaiki menjadi package main dengan class Main, serta penulisan kode dirapikan kembali.

## 3. Penjelasan Struktur Package MVC

Program ini terdiri dari tiga belas berkas yang dibagi ke dalam empat package sesuai struktur MVC.

**Package model** berisi enam class, yaitu Layanan, LayananRambut, LayananKecantikan, Pelanggan, Reservasi, dan DataSalon. Package ini bertugas mengatur dan menyimpan data. Lima class pertama berfungsi sebagai cetak biru data yang hanya berisi atribut, constructor, serta getter dan setter. Sedangkan class DataSalon berfungsi sebagai tempat penyimpanan seluruh ArrayList beserta proses tambah, cari, dan hapus datanya. Package model sama sekali tidak mengetahui bagaimana data tersebut nantinya ditampilkan ke layar.

**Package view** berisi dua class, yaitu MenuView dan InputView. Package ini bertugas berhubungan langsung dengan pengguna. MenuView hanya bertugas menampilkan tulisan ke layar, mulai dari menu utama, sub menu, judul, data, sampai pesan. Sedangkan InputView bertugas membaca masukan dari pengguna sekaligus memeriksa kebenarannya. Package view tidak memproses data sama sekali.

**Package controller** berisi empat berkas, yaitu interface KelolaData beserta tiga class PelangganController, LayananController, dan ReservasiController. Package ini berperan sebagai penghubung antara model dan view. Controller menerima pilihan dari pengguna melalui view, memproses pilihan tersebut, meminta data yang dibutuhkan kepada model, lalu mengirimkan hasilnya kembali ke view untuk ditampilkan.

**Package main** berisi satu class bernama Main. Class ini merupakan titik awal program dijalankan. Tugasnya membuat seluruh objek yang dibutuhkan, menjalankan perulangan menu utama, lalu memanggil controller sesuai menu yang dipilih pengguna.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/c27bd232-df0f-457d-ad43-6ad0194ae0c3" />

Alasan struktur MVC diterapkan adalah agar setiap bagian program memiliki tugasnya masing-masing dan tidak tercampur. Pada Mini Project 2, satu class utama berisi tampilan menu, pembacaan input, logika menu, sekaligus penyimpanan data, sehingga berkas tersebut menjadi sangat panjang dan sulit dicari isinya. Dengan MVC, apabila terjadi kesalahan pada tampilan maka yang diperiksa cukup package view, dan apabila terjadi kesalahan pada penyimpanan data maka yang diperiksa cukup package model. Selain itu apabila suatu saat program ingin diubah menjadi berbasis tampilan grafis, bagian yang perlu diganti hanya package view saja, sedangkan model dan controller tetap bisa dipakai.

## 4. Penjelasan Alur Program

Bagian ini menjelaskan jalannya program dari pertama kali dijalankan sampai program berhenti, sekaligus menjadi dokumentasi hasil pengujiannya.

### 4.1 Program Mulai Dijalankan

Ketika tombol Run ditekan, program menjalankan method main yang berada di dalam class Main pada package main.

Langkah pertama, program membuat objek DataSalon. Pada saat objek ini dibuat, constructor-nya langsung memanggil method isiDataAwal yang mengisi ArrayList dengan lima data pelanggan, lima data layanan, dan lima data reservasi. Langkah kedua, program membuat objek MenuView dan InputView. Langkah ketiga, program membuat tiga objek controller, yaitu PelangganController, LayananController, dan ReservasiController. Ketiga objek controller ini menerima DataSalon, MenuView, dan InputView sebagai titipan, sehingga seluruh controller bekerja pada tempat penyimpanan data yang sama.

Setelah seluruh objek siap, program masuk ke perulangan do-while yang menampilkan Menu Utama berisi empat pilihan, yaitu Kelola Pelanggan, Kelola Layanan, Kelola Reservasi, dan Keluar. Perulangan do-while dipilih karena menu harus ditampilkan minimal satu kali sebelum kondisi berhenti diperiksa.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/7e5c74a5-420d-456a-85eb-c34ea4ec591f" />

### 4.2 Pengguna Memilih Menu

Pilihan pengguna dibaca melalui method inputAngka milik InputView, kemudian diproses menggunakan percabangan switch. Apabila pengguna memilih angka 1, program memanggil method jalankanMenu milik PelangganController. Angka 2 memanggil LayananController, dan angka 3 memanggil ReservasiController.

Di dalam setiap controller terdapat perulangan do-while lagi yang menampilkan sub menu berisi Tambah, Tampilkan, Ubah, Hapus, dan Kembali. Sub menu ini terus ditampilkan sampai pengguna memilih angka 5 untuk kembali ke Menu Utama.

### 4.3 Proses Tambah Pelanggan

Ketika pengguna memilih Tambah pada Menu Pelanggan, controller meminta nama dan nomor telepon melalui InputView. Pengguna tidak perlu mengetik ID karena ID dibuat otomatis oleh DataSalon agar tidak terjadi ID ganda.

Setelah data terkumpul, controller memanggil method tambahPelanggan milik DataSalon. Di dalam method itulah objek Pelanggan yang baru dibuat lalu dimasukkan ke dalam ArrayList. Terakhir controller meminta MenuView menampilkan pesan bahwa data berhasil ditambahkan. Di sinilah alur MVC terlihat jelas, yaitu view menerima input, controller memproses, model menyimpan, lalu view menampilkan hasilnya.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/2841d15b-0f60-4a7a-a8c8-49a325cc62a7" />

### 4.4 Proses Tampilkan Pelanggan

Ketika pengguna memilih Tampilkan, controller mengambil seluruh isi ArrayList dari DataSalon, lalu menelusurinya satu per satu menggunakan perulangan for. Setiap data diminta keterangannya melalui method getInfo, kemudian hasilnya dikirim ke MenuView untuk ditampilkan.

Pada tampilan ini terlihat lima data awal beserta data yang baru ditambahkan sebelumnya. Apabila seluruh data sudah dihapus, program menampilkan keterangan bahwa data masih kosong.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/b7a603dc-593d-4a76-b012-9ca9722566d2" />

### 4.5 Proses Ubah Pelanggan

Controller terlebih dahulu menampilkan seluruh data pelanggan agar pengguna dapat melihat ID yang tersedia, kemudian meminta ID yang ingin diubah. ID tersebut dikirim ke DataSalon melalui method cariIndexPelanggan.

Apabila data ditemukan, pengguna diminta memasukkan nama dan nomor telepon yang baru, lalu nilainya diganti melalui method setter. ID tidak ikut diubah karena berfungsi sebagai identitas. Apabila ID tidak terdaftar, method pencarian mengembalikan nilai minus satu dan program menampilkan pesan bahwa ID tidak ditemukan tanpa mengubah data apa pun.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/aa720552-11c8-4670-bcf7-d9b7491e5c78" />

### 4.6 Proses Hapus Pelanggan

Sama seperti proses ubah, program menampilkan daftar pelanggan lalu meminta ID yang ingin dihapus. Sebelum data benar-benar dihapus, program menampilkan konfirmasi terlebih dahulu beserta nama pelanggannya, dan hanya menerima jawaban y atau n.

Apabila pengguna menjawab y, controller memanggil method hapusPelanggan milik DataSalon. Di dalam method tersebut, program lebih dulu mencari seluruh reservasi milik pelanggan itu dan menghapusnya, baru kemudian data pelanggannya sendiri dihapus. Jumlah reservasi yang ikut terhapus dikembalikan ke controller untuk ditampilkan kepada pengguna.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/4b83c6aa-a355-45c6-869d-ec4f90fc8c1a" />

### 4.7 Proses pada Menu Layanan

Menu Layanan memiliki alur yang mirip, namun pada proses tambah terdapat satu langkah tambahan. Sebelum menanyakan data lainnya, program meminta pengguna memilih kategori layanan terlebih dahulu.

Apabila pengguna memilih kategori rambut, program menanyakan panjang rambut lalu membuat objek LayananRambut. Apabila memilih kategori kecantikan, program menanyakan durasi pengerjaan lalu membuat objek LayananKecantikan. Walaupun objek yang dibuat berbeda jenis, keduanya tetap disimpan ke dalam satu ArrayList yang sama bertipe Layanan karena keduanya merupakan turunan dari class tersebut.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/ca2da490-c5d1-41c3-865a-c000aa3366df" />

Pada proses tampilkan layanan, terlihat setiap data menampilkan keterangan sesuai jenisnya masing-masing. Layanan rambut menampilkan baris panjang rambut, sedangkan layanan kecantikan menampilkan baris durasi.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/81ea845a-c255-4e98-a325-f4bd23db254c" />

Pada proses hapus layanan, seperti halnya pelanggan, seluruh reservasi yang memakai layanan tersebut ikut terhapus.

### 4.8 Proses pada Menu Reservasi

Menu Reservasi merupakan penghubung antara data pelanggan dan data layanan. Sebelum meminta masukan apa pun, program memeriksa terlebih dahulu apakah daftar pelanggan atau daftar layanan masih kosong, karena reservasi tidak mungkin dibuat tanpa keduanya.

Apabila kedua daftar sudah terisi, ReservasiController memanggil method tampilkan milik PelangganController agar daftar pelanggan muncul, lalu meminta pengguna memilih ID pelanggan. Setelah itu ReservasiController memanggil method tampilkan milik LayananController dengan cara yang sama. Terakhir pengguna memasukkan tanggal reservasi, lalu data disimpan ke dalam ArrayList melalui DataSalon.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/23e589eb-b142-4c40-a941-e81264377725" />

Pada proses tampilkan reservasi, program menampilkan ID reservasi, nama pelanggan, nama layanan beserta kategorinya, harga, dan tanggal. Nama dan kategori tersebut tidak disimpan ulang di dalam class Reservasi, melainkan diambil langsung dari objek pelanggan dan objek layanan yang tersimpan di dalamnya.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/d42a9180-0104-4d63-b0f2-29b4006f3193" />

Pada proses ubah reservasi, data yang dapat diubah hanya tanggalnya saja, karena mengganti pelanggan atau layanan pada dasarnya berarti membuat pemesanan yang berbeda.

### 4.9 Program Berhenti

Apabila pengguna memilih angka 4 pada Menu Utama, program menampilkan pesan penutup. Kondisi pada perulangan do-while menjadi tidak terpenuhi sehingga perulangan berhenti, method main selesai dijalankan, dan program berakhir.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/f3a1605e-df3a-45db-9bab-c3e47f481444" />

## 5. Penerapan Abstraction

### 5.1 Letak Penerapan

Abstraction diterapkan pada class Layanan yang berada di package model. Pada baris deklarasi class terdapat kata kunci abstract, dan di dalamnya terdapat satu abstract method bernama getKategori yang hanya berisi judul method tanpa isi sama sekali.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/237491b9-b345-4011-a4df-3f474c7bda6e" />
<img width="400" alt="image" src="https://github.com/user-attachments/assets/1381ba77-10e8-4485-b439-accac0df02a3" />

Abstract method tersebut kemudian wajib diisi oleh kedua class turunannya. Pada class LayananRambut, method getKategori diisi dengan mengembalikan teks Rambut. Pada class LayananKecantikan, method yang sama diisi dengan mengembalikan teks Kecantikan.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/4b5fb893-6f4b-4302-938a-8cebcae499b4" />

<img width="400" alt="image" src="https://github.com/user-attachments/assets/edb426b9-0fea-4dc1-a888-2973eb316c9c" />

### 5.2 Alasan Abstraction Diterapkan

Alasan pertama adalah karena kategori layanan tidak mungkin ditentukan di class induk. Layanan secara umum tidak punya kategori yang pasti, yang punya kategori jelas hanyalah turunannya. Oleh karena itu method getKategori sengaja dibiarkan kosong di class induk, lalu diisi sendiri oleh masing-masing turunan.

Alasan kedua adalah agar class Layanan tidak bisa dibuat objeknya secara langsung. Di dunia nyata, salon tidak pernah menjual sesuatu bernama layanan saja tanpa jenis yang jelas. Dengan menjadikannya abstract, Java akan menolak apabila ada kode yang mencoba membuat objek Layanan, sehingga kesalahan tersebut ketahuan sejak awal.

Alasan ketiga adalah agar seluruh turunan dipaksa memiliki method getKategori. Apabila suatu saat ditambahkan class baru seperti LayananPerawatanKuku, Java tidak akan mengizinkan class tersebut dibuat sebelum method getKategori diisi.

## 6. Penerapan Polymorphism

### 6.1 Method Overriding

Method overriding adalah keadaan ketika class turunan menuliskan ulang method yang sudah ada di class induk dengan isi yang berbeda. Pada program ini method getInfo yang berada di class Layanan ditulis ulang oleh kedua turunannya, dan ditandai dengan anotasi @Override.

Letak penerapannya dapat dilihat pada screenshot class LayananRambut dan LayananKecantikan di bagian sebelumnya. Pada kedua class tersebut, method getInfo memanggil super.getInfo terlebih dahulu untuk mengambil keterangan umum dari class induk, kemudian menambahkan keterangan khususnya sendiri.

Alasan overriding diterapkan adalah karena setiap jenis layanan memiliki keterangan tambahan yang berbeda. Tanpa overriding, baris panjang rambut dan baris durasi tidak akan pernah muncul karena class induk tidak mengetahui adanya atribut tambahan pada turunannya. Selain itu dengan memanggil super.getInfo, keterangan umum seperti ID, nama, dan harga cukup ditulis satu kali saja di class induk.

Hasil penerapannya terlihat pada menu Tampilkan Layanan. Seluruh data ditampilkan menggunakan satu perulangan dan satu pemanggilan method getInfo yang sama, namun hasilnya berbeda sesuai jenis datanya.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/92904564-b4a1-40bb-a810-ad348d4e601d" />

### 6.2 Method Overloading

Method overloading adalah keadaan ketika terdapat dua method dengan nama sama namun jumlah parameternya berbeda. Pada program ini method inputAngka di dalam class InputView ditulis sebanyak dua kali.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/3663f55c-aa29-4b2e-b540-e99d5bd1fb4f" />

Bentuk pertama hanya menerima satu parameter berupa teks pertanyaan, dan dipakai ketika program hanya butuh memastikan masukan berupa angka yang lebih dari nol, misalnya saat meminta ID data yang ingin diubah atau dihapus. Bentuk kedua menerima tiga parameter, yaitu teks pertanyaan, nilai minimal, dan nilai maksimal, dan dipakai ketika masukan harus berada pada rentang tertentu, misalnya saat memilih menu yang hanya boleh diisi 1 sampai 4.

Alasan overloading diterapkan adalah agar satu nama method dapat dipakai untuk dua kebutuhan yang mirip, sehingga nama method tidak perlu dibedakan menjadi dua nama yang membingungkan. Selain itu bentuk kedua cukup memanggil bentuk pertama untuk urusan memeriksa apakah masukan benar-benar angka, sehingga pemeriksaan tersebut tidak ditulis dua kali.

## 7. Penerapan Interface (Nilai Tambah)

### 7.1 Letak Penerapan

Interface diterapkan pada berkas KelolaData yang berada di package controller. Isinya hanya berupa dua judul method tanpa isi, yaitu jalankanMenu dan tampilkan.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/75d198be-c356-468b-b15f-745643607089" />

Ketiga class controller menggunakan kata kunci implements KelolaData pada baris deklarasinya, sehingga ketiganya wajib mengisi kedua method tersebut. Hal ini dapat dilihat pada baris paling atas setiap controller.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/97acdf64-c6dd-436e-bc64-34c5c0a5701e" />

Interface ini juga dipakai pada class Main. Ketiga objek controller di sana dideklarasikan dengan tipe KelolaData, bukan dengan nama class aslinya.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/5086ecfb-e02a-43d9-bf43-c209f0e24d54" />

Selain itu, ReservasiController menyimpan PelangganController dan LayananController dengan tipe KelolaData, lalu memanggil method tampilkan milik keduanya ketika membuat reservasi baru.

### 7.2 Alasan Interface Diterapkan

Alasan pertama adalah agar ketiga controller memiliki aturan yang seragam. Dengan adanya interface, setiap controller dipastikan memiliki method jalankanMenu dan tampilkan dengan nama yang sama persis, sehingga tidak ada variasi penamaan yang membingungkan.

Alasan kedua adalah agar class Main tidak perlu tahu jenis controller yang dipakainya. Main cukup tahu bahwa objek tersebut adalah KelolaData yang pasti bisa dipanggil method jalankanMenu-nya, tanpa peduli isi di dalamnya seperti apa.

Alasan ketiga adalah agar ReservasiController bisa menampilkan daftar pelanggan dan daftar layanan tanpa menulis ulang kode penampil data. ReservasiController cukup memanggil method tampilkan milik controller lain melalui interface tersebut.

## 8. Penerapan Encapsulation dan Inheritance

Kedua konsep ini merupakan lanjutan dari Mini Project 2 dan tetap dipertahankan.

Encapsulation diterapkan dengan menjadikan seluruh atribut pada class model bersifat private, sehingga tidak dapat diakses langsung dari luar class. Pembacaan dan pengubahan nilainya hanya dapat dilakukan melalui method getter dan setter yang bersifat public. Hal yang sama juga berlaku pada class DataSalon, yang seluruh ArrayList-nya bersifat private. Alasannya adalah agar data tidak dapat diubah sembarangan dari luar, dan setiap perubahan selalu melewati jalur yang sudah ditentukan.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/e9910202-5a00-4b79-8f42-5130338bf9ea" />

Inheritance diterapkan melalui class Layanan sebagai class induk yang diturunkan menjadi LayananRambut dan LayananKecantikan menggunakan kata kunci extends. Pada constructor kedua turunan terdapat pemanggilan super untuk mengisi atribut milik class induk yang bersifat private. Alasannya adalah agar atribut yang sama seperti ID, nama layanan, dan harga tidak perlu ditulis ulang di kedua turunan, serta agar keduanya dapat disimpan dalam satu ArrayList yang sama.

## 9. Validasi Input dan Dummy Data

Validasi input seluruhnya berada di dalam class InputView pada package view. Setiap method bekerja dengan cara menampilkan pertanyaan, membaca masukan, lalu memeriksanya. Apabila masukan tidak sesuai, program menampilkan pesan kesalahan dan mengulang pertanyaan tersebut sampai masukan yang diberikan benar.

Masukan berupa angka diperiksa agar tidak berisi huruf, nama diperiksa agar hanya berisi huruf dan spasi sekaligus dirapikan huruf besar kecilnya, nomor telepon diperiksa agar diawali angka nol delapan dengan panjang sepuluh sampai tiga belas digit, dan tanggal diperiksa agar sesuai format dua digit hari, dua digit bulan, dan empat digit tahun.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/82c2f204-4788-452c-ad82-75b6e4fb3768" />

<img width="400" alt="image" src="https://github.com/user-attachments/assets/25c3404a-6e28-4789-87d8-2c72cffcb57e" />

Alasan validasi diterapkan adalah agar program tidak berhenti secara paksa ketika pengguna salah memasukkan data, dan agar data yang tersimpan menjadi seragam.

Dummy data diisi melalui method isiDataAwal di dalam class DataSalon, berisi lima data pelanggan, lima data layanan, dan lima data reservasi. Data layanan awal sengaja dibuat mencakup kedua turunan, yaitu tiga layanan rambut dan dua layanan kecantikan, agar hasil penerapan abstraction dan overriding langsung terlihat ketika fitur tampilkan dijalankan.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/8268e314-6c18-485c-907d-6c664ee8f36e" />

## 10. Perbaikan dari Mini Project 2

Pada Mini Project 2 terdapat kekurangan, yaitu ketika pelanggan atau layanan dihapus melalui menu hapus, objek reservasi yang terhubung dengan data tersebut masih tetap tersimpan di dalam daftar reservasi. Akibatnya terdapat data reservasi yang menunjuk ke pelanggan atau layanan yang sebenarnya sudah tidak ada lagi.

Perbaikannya dilakukan di dalam class DataSalon melalui dua method tambahan, yaitu hapusReservasiMilikPelanggan dan hapusReservasiMemakaiLayanan. Kedua method tersebut dipanggil lebih dahulu sebelum data pelanggan atau layanan benar-benar dihapus.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/ae4cf8cc-1b08-4a37-8989-c2b721054ffc" />

Penelusuran pada kedua method tersebut dilakukan dari data paling belakang menuju data paling depan. Hal ini dilakukan karena apabila penelusuran dimulai dari depan, posisi data akan bergeser setiap kali ada data yang dihapus, sehingga ada data yang terlewat dan tidak ikut terperiksa.

Setelah proses selesai, jumlah reservasi yang ikut terhapus dikembalikan ke controller lalu ditampilkan kepada pengguna sebagai pemberitahuan.

<img width="400" alt="image" src="https://github.com/user-attachments/assets/da817874-d81d-4c14-b73a-a4f56b0cf82f" />

## 11. Kesimpulan

Program Sistem Manajemen Salon pada Mini Project 3 ini telah menerapkan seluruh ketentuan yang diminta.

Abstraction diterapkan melalui class Layanan yang dijadikan abstract class beserta abstract method getKategori, yang pengisiannya diserahkan kepada kedua class turunannya.

Polymorphism diterapkan dalam dua bentuk sekaligus. Method overriding diterapkan pada method getInfo agar setiap jenis layanan dapat menampilkan keterangan khususnya sendiri walaupun dipanggil dengan cara yang sama. Method overloading diterapkan pada method inputAngka agar satu nama method dapat dipakai untuk dua kebutuhan berbeda.

Struktur proyek MVC diterapkan dengan membagi program ke dalam package model, view, controller, dan main, sehingga setiap bagian program memiliki tugasnya masing-masing.

Sebagai nilai tambah, interface diterapkan melalui KelolaData yang menjadi kontrak aturan bagi ketiga class controller.

Selain itu program tetap mempertahankan encapsulation, inheritance, validasi input, dan dummy data dari Mini Project 2, serta memperbaiki kekurangan pada proses hapus data yang sebelumnya meninggalkan reservasi yang tidak lagi memiliki pasangan data.

Berdasarkan hasil pengujian yang telah didokumentasikan, seluruh fitur tambah, tampilkan, ubah, dan hapus pada menu Pelanggan, Layanan, dan Reservasi telah berjalan sesuai dengan yang diharapkan.
