/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author HP VICTUS
 */
import controller.KelolaData;
import controller.LayananController;
import controller.PelangganController;
import controller.ReservasiController;
import model.DataSalon;
import view.InputView;
import view.MenuView;

public class main {

    public static void main(String[] args) {
        DataSalon dataSalon = new DataSalon();
        MenuView menuView = new MenuView();
        InputView inputView = new InputView();

        KelolaData pelangganController = new PelangganController(dataSalon, menuView, inputView);
        KelolaData layananController = new LayananController(dataSalon, menuView, inputView);
        KelolaData reservasiController = new ReservasiController(dataSalon, menuView, inputView, pelangganController, layananController);

        int pilihan;

        do {
            menuView.tampilkanMenuUtama();
            pilihan = inputView.inputAngka("Pilih menu: ", 1, 4);

            switch (pilihan) {
                case 1:
                    pelangganController.jalankanMenu();
                    break;
                case 2:
                    layananController.jalankanMenu();
                    break;
                case 3:
                    reservasiController.jalankanMenu();
                    break;
                case 4:
                    menuView.tampilkanPesan("Program selesai. Terima kasih!");
                    break;
            }
        } while (pilihan != 4);
    }
}