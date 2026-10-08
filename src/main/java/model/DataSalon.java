/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP VICTUS
 */
import java.util.ArrayList;

public class DataSalon {

    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Layanan> daftarLayanan;
    private ArrayList<Reservasi> daftarReservasi;
    private int idPelangganBerikutnya;
    private int idLayananBerikutnya;
    private int idReservasiBerikutnya;

    public DataSalon() {
        daftarPelanggan = new ArrayList<>();
        daftarLayanan = new ArrayList<>();
        daftarReservasi = new ArrayList<>();
        isiDataAwal();
    }

    private void isiDataAwal() {
        daftarPelanggan.add(new Pelanggan(1, "Ciaaw", "081234567890"));
        daftarPelanggan.add(new Pelanggan(2, "Mrow", "081298765432"));
        daftarPelanggan.add(new Pelanggan(3, "Chantip", "081345678901"));
        daftarPelanggan.add(new Pelanggan(4, "Casey", "081387654321"));
        daftarPelanggan.add(new Pelanggan(5, "Keity", "081456789013"));
        idPelangganBerikutnya = 6;

        daftarLayanan.add(new LayananRambut(1, "Potong Rambut", 50000, "Pendek"));
        daftarLayanan.add(new LayananRambut(2, "Creambath", 100000, "Sedang"));
        daftarLayanan.add(new LayananRambut(3, "Smoothing Rambut", 350000, "Panjang"));
        daftarLayanan.add(new LayananKecantikan(4, "Facial", 150000, 60));
        daftarLayanan.add(new LayananKecantikan(5, "Manicure Pedicure", 120000, 90));
        idLayananBerikutnya = 6;

        daftarReservasi.add(new Reservasi(1, daftarPelanggan.get(0), daftarLayanan.get(0), "01-10-2026"));
        daftarReservasi.add(new Reservasi(2, daftarPelanggan.get(1), daftarLayanan.get(1), "02-10-2026"));
        daftarReservasi.add(new Reservasi(3, daftarPelanggan.get(2), daftarLayanan.get(2), "03-10-2026"));
        daftarReservasi.add(new Reservasi(4, daftarPelanggan.get(3), daftarLayanan.get(3), "04-10-2026"));
        daftarReservasi.add(new Reservasi(5, daftarPelanggan.get(4), daftarLayanan.get(4), "05-10-2026"));
        idReservasiBerikutnya = 6;
    }

    // DATA PELANGGAN 

    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public void tambahPelanggan(String nama, String noTelepon) {
        daftarPelanggan.add(new Pelanggan(idPelangganBerikutnya, nama, noTelepon));
        idPelangganBerikutnya++;
    }

    public int cariIndexPelanggan(int idPelanggan) {
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdPelanggan() == idPelanggan) {
                return i;
            }
        }

        return -1;
    }

    public int hapusPelanggan(int index) {
        Pelanggan pelanggan = daftarPelanggan.get(index);
        int jumlahReservasiTerhapus = hapusReservasiMilikPelanggan(pelanggan);
        daftarPelanggan.remove(index);

        return jumlahReservasiTerhapus;
    }

    //DATA LAYANAN

    public ArrayList<Layanan> getDaftarLayanan() {
        return daftarLayanan;
    }

    public void tambahLayanan(Layanan layanan) {
        daftarLayanan.add(layanan);
        idLayananBerikutnya++;
    }

    public int getIdLayananBerikutnya() {
        return idLayananBerikutnya;
    }

    public int cariIndexLayanan(int idLayanan) {
        for (int i = 0; i < daftarLayanan.size(); i++) {
            if (daftarLayanan.get(i).getIdLayanan() == idLayanan) {
                return i;
            }
        }

        return -1;
    }

    public int hapusLayanan(int index) {
        Layanan layanan = daftarLayanan.get(index);
        int jumlahReservasiTerhapus = hapusReservasiMemakaiLayanan(layanan);
        daftarLayanan.remove(index);

        return jumlahReservasiTerhapus;
    }

    //DATA RESERVASI

    public ArrayList<Reservasi> getDaftarReservasi() {
        return daftarReservasi;
    }

    public void tambahReservasi(Pelanggan pelanggan, Layanan layanan, String tanggal) {
        daftarReservasi.add(new Reservasi(idReservasiBerikutnya, pelanggan, layanan, tanggal));
        idReservasiBerikutnya++;
    }

    public int cariIndexReservasi(int idReservasi) {
        for (int i = 0; i < daftarReservasi.size(); i++) {
            if (daftarReservasi.get(i).getIdReservasi() == idReservasi) {
                return i;
            }
        }

        return -1;
    }

    public void hapusReservasi(int index) {
        daftarReservasi.remove(index);
    }

    private int hapusReservasiMilikPelanggan(Pelanggan pelanggan) {
        int jumlah = 0;

        for (int i = daftarReservasi.size() - 1; i >= 0; i--) {
            if (daftarReservasi.get(i).getPelanggan() == pelanggan) {
                daftarReservasi.remove(i);
                jumlah++;
            }
        }

        return jumlah;
    }

    private int hapusReservasiMemakaiLayanan(Layanan layanan) {
        int jumlah = 0;

        for (int i = daftarReservasi.size() - 1; i >= 0; i--) {
            if (daftarReservasi.get(i).getLayanan() == layanan) {
                daftarReservasi.remove(i);
                jumlah++;
            }
        }

        return jumlah;
    }
}