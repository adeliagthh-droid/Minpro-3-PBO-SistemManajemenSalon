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
import model.Pelanggan;
import model.Reservasi;
import view.InputView;
import view.MenuView;

public class ReservasiController implements KelolaData {

    private DataSalon dataSalon;
    private MenuView menuView;
    private InputView inputView;
    private KelolaData pelangganController;
    private KelolaData layananController;

    public ReservasiController(DataSalon dataSalon, MenuView menuView, InputView inputView, KelolaData pelangganController, KelolaData layananController) {
        this.dataSalon = dataSalon;
        this.menuView = menuView;
        this.inputView = inputView;
        this.pelangganController = pelangganController;
        this.layananController = layananController;
    }

    @Override
    public void jalankanMenu() {
        int pilihan;

        do {
            menuView.tampilkanSubMenu("Reservasi");
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
        menuView.tampilkanJudul("Daftar Reservasi");

        if (dataSalon.getDaftarReservasi().isEmpty()) {
            menuView.tampilkanPesan("Belum ada data reservasi.");
            return;
        }

        for (int i = 0; i < dataSalon.getDaftarReservasi().size(); i++) {
            menuView.tampilkanData(dataSalon.getDaftarReservasi().get(i).getInfo());
        }
    }

    private void tambah() {
        if (dataSalon.getDaftarPelanggan().isEmpty() || dataSalon.getDaftarLayanan().isEmpty()) {
            menuView.tampilkanPesan("Data pelanggan/layanan masih kosong, tambahin dulu!");
            return;
        }

        menuView.tampilkanJudul("Tambah Reservasi");
        pelangganController.tampilkan();
        int indexPelanggan = dataSalon.cariIndexPelanggan(inputView.inputAngka("Masukkan ID Pelanggan: "));

        if (indexPelanggan == -1) {
            menuView.tampilkanPesan("ID Pelanggan tidak ditemukan. Reservasi dibatalkan.");
            return;
        }

        layananController.tampilkan();
        int indexLayanan = dataSalon.cariIndexLayanan(inputView.inputAngka("Masukkan ID Layanan: "));

        if (indexLayanan == -1) {
            menuView.tampilkanPesan("ID Layanan tidak ditemukan. Reservasi dibatalkan.");
            return;
        }

        Pelanggan pelanggan = dataSalon.getDaftarPelanggan().get(indexPelanggan);
        Layanan layanan = dataSalon.getDaftarLayanan().get(indexLayanan);
        String tanggal = inputView.inputTanggal("Tanggal (dd-mm-yyyy): ");

        dataSalon.tambahReservasi(pelanggan, layanan, tanggal);
        menuView.tampilkanPesan("yeayy Data Reservasi sudah ditambahkan!");
    }

    private void ubah() {
        tampilkan();

        if (dataSalon.getDaftarReservasi().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexReservasi(inputView.inputAngka("Masukkan ID Reservasi yang ingin diubah: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Reservasi tidak ditemukan.");
            return;
        }

        Reservasi reservasi = dataSalon.getDaftarReservasi().get(index);
        menuView.tampilkanPesan("Tanggal lama: " + reservasi.getTanggal());
        reservasi.setTanggal(inputView.inputTanggal("Tanggal baru (dd-mm-yyyy): "));
        menuView.tampilkanPesan("yeayy Data Reservasi sudah diubah!");
    }

    private void hapus() {
        tampilkan();

        if (dataSalon.getDaftarReservasi().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexReservasi(inputView.inputAngka("Masukkan ID Reservasi yang ingin dihapus: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Reservasi tidak ditemukan.");
            return;
        }

        if (!inputView.inputKonfirmasi("Yakin ingin menghapus reservasi ini?")) {
            menuView.tampilkanPesan("Penghapusan dibatalkan.");
            return;
        }

        dataSalon.hapusReservasi(index);
        menuView.tampilkanPesan("yeayy Data Reservasi sudah dihapus!");
    }
}
