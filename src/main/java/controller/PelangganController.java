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
import model.Pelanggan;
import view.InputView;
import view.MenuView;

public class PelangganController implements KelolaData {

    private DataSalon dataSalon;
    private MenuView menuView;
    private InputView inputView;

    public PelangganController(DataSalon dataSalon, MenuView menuView, InputView inputView) {
        this.dataSalon = dataSalon;
        this.menuView = menuView;
        this.inputView = inputView;
    }

    @Override
    public void jalankanMenu() {
        int pilihan;

        do {
            menuView.tampilkanSubMenu("Pelanggan");
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
        menuView.tampilkanJudul("Daftar Pelanggan");

        if (dataSalon.getDaftarPelanggan().isEmpty()) {
            menuView.tampilkanPesan("Belum ada data pelanggan.");
            return;
        }

        for (int i = 0; i < dataSalon.getDaftarPelanggan().size(); i++) {
            menuView.tampilkanData(dataSalon.getDaftarPelanggan().get(i).getInfo());
        }
    }

    private void tambah() {
        menuView.tampilkanJudul("Tambah Pelanggan");
        String nama = inputView.inputNama("Nama Pelanggan : ");
        String noTelepon = inputView.inputNoTelepon("No Telepon     : ");

        dataSalon.tambahPelanggan(nama, noTelepon);
        menuView.tampilkanPesan("yeayy Data Pelanggan sudah ditambahkan!");
    }

    private void ubah() {
        tampilkan();

        if (dataSalon.getDaftarPelanggan().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexPelanggan(inputView.inputAngka("Masukkan ID Pelanggan yang ingin diubah: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Pelanggan tidak ditemukan.");
            return;
        }

        Pelanggan pelanggan = dataSalon.getDaftarPelanggan().get(index);
        pelanggan.setNama(inputView.inputNama("Nama baru       : "));
        pelanggan.setNoTelepon(inputView.inputNoTelepon("No Telepon baru : "));
        menuView.tampilkanPesan("yeayy Data Pelanggan sudah diubah!");
    }

    private void hapus() {
        tampilkan();

        if (dataSalon.getDaftarPelanggan().isEmpty()) {
            return;
        }

        int index = dataSalon.cariIndexPelanggan(inputView.inputAngka("Masukkan ID Pelanggan yang ingin dihapus: "));

        if (index == -1) {
            menuView.tampilkanPesan("ID Pelanggan tidak ditemukan.");
            return;
        }

        Pelanggan pelanggan = dataSalon.getDaftarPelanggan().get(index);

        if (!inputView.inputKonfirmasi("Yakin ingin menghapus " + pelanggan.getNama() + "?")) {
            menuView.tampilkanPesan("Penghapusan dibatalkan.");
            return;
        }

        int jumlahReservasiTerhapus = dataSalon.hapusPelanggan(index);
        menuView.tampilkanPesan("yeayy Data Pelanggan sudah dihapus!");

        if (jumlahReservasiTerhapus > 0) {
            menuView.tampilkanPesan(jumlahReservasiTerhapus + " data reservasi milik pelanggan ini ikut dihapus.");
        }
    }
}