/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author HP VICTUS
 */
import model.DataSalon;
import model.Layanan;
import model.LayananKecantikan;
import model.LayananRambut;
import view.InputView;
import view.MenuView;

public class LayananController implements KelolaData {

    private DataSalon dataSalon;
    private MenuView menuView;
    private InputView inputView;

    public LayananController(DataSalon dataSalon, MenuView menuView, InputView inputView) {
        this.dataSalon = dataSalon;
        this.menuView = menuView;
        this.inputView = inputView;
    }

    @Override
    public void jalankanMenu() {
        int pilihan;

        do {
            menuView.tampilkanSubMenu("Layanan");
            pilihan = inputView.inputAngka("Pilih: ", 1, 5);

            switch (pilihan) {
                case 1:
                    tambah();
                    break;
                case 2:
                    tampilkan();
                    break;
                case 3:
                    ubah();
                    break;
                case 4:
                    hapus();
                    break;
            }
        } while (pilihan != 5);
    }

    @Override
    public void tampilkan() {
        menuView.tampilkanJudul("Daftar Layanan");

        if (dataSalon.getDaftarLayanan().isEmpty()) {
            menuView.tampilkanPesan("Belum ada data layanan.");
            return;
        }

        for (int i = 0; i < dataSalon.getDaftarLayanan().size(); i++) {
            menuView.tampilkanData(dataSalon.getDaftarLayanan().get(i).getInfo());
        }
    }

    private void tambah() {
        menuView.tampilkanJudul("Tambah Layanan");
        menuView.tampilkanPesan("Kategori: 1. Rambut  2. Kecantikan");
        int kategori = inputView.inputAngka("Pilih kategori : ", 1, 2);
        String nama = inputView.inputNama("Nama Layanan   : ");
        int harga = inputView.inputAngka("Harga (Rp)     : ", 10000, 5000000);
        int id = dataSalon.getIdLayananBerikutnya();

        if (kategori == 1) {
            menuView.tampilkanPesan("Panjang rambut: 1. Pendek  2. Sedang  3. Panjang");
            int pilihanPanjang = inputView.inputAngka("Pilih panjang  : ", 1, 3);
            String panjangRambut = "Pendek";

            if (pilihanPanjang == 2) {
                panjangRambut = "Sedang";
            } else if (pilihanPanjang == 3) {
                panjangRambut = "Panjang";
            }

            dataSalon.tambahLayanan(new LayananRambut(id, nama, harga, panjangRambut));
        } else {
            int durasi = inputView.inputAngka("Durasi (menit) : ", 15, 240);
            dataSalon.tambahLayanan(new LayananKecantikan(id, nama, harga, durasi));
        }

        menuView.tampilkanPesan("yeayy Data Layanan sudah ditambahkan!");
    }

    private void ubah() {
        tampilkan();

        if (dataSalon.getDaftarLayanan().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexLayanan(inputView.inputAngka("Masukkan ID Layanan yang ingin diubah: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Layanan tidak ditemukan.");
            return;
        }

        Layanan layanan = dataSalon.getDaftarLayanan().get(index);
        layanan.setNamaLayanan(inputView.inputNama("Nama Layanan baru : "));
        layanan.setHarga(inputView.inputAngka("Harga baru (Rp)   : ", 10000, 5000000));
        menuView.tampilkanPesan("yeayy Data Layanan sudah diubah!");
    }

    private void hapus() {
        tampilkan();

        if (dataSalon.getDaftarLayanan().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexLayanan(inputView.inputAngka("Masukkan ID Layanan yang ingin dihapus: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Layanan tidak ditemukan.");
            return;
        }

        Layanan layanan = dataSalon.getDaftarLayanan().get(index);

        if (!inputView.inputKonfirmasi("Yakin ingin menghapus " + layanan.getNamaLayanan() + "?")) {
            menuView.tampilkanPesan("Penghapusan dibatalkan.");
            return;
        }

        int jumlahReservasiTerhapus = dataSalon.hapusLayanan(index);
        menuView.tampilkanPesan("yeayy Data Layanan sudah dihapus!");

        if (jumlahReservasiTerhapus > 0) {
            menuView.tampilkanPesan(jumlahReservasiTerhapus + " data reservasi yang memakai layanan ini ikut dihapus.");
        }
    }
}
