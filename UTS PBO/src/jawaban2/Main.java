package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalKendaraan = 0;
        double totalPendapatan = 0;
        String pilihan;

        System.out.println("========= Welcome to ParkingChan =========");

        do {
            System.out.print("\nMasukkan jenis kendaraan (Motor/Mobil/Truk) : ");
            String jenis = input.next();

            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Pilih durasi (Manual/Time): ");
            String mode = input.next();

            if (mode.equalsIgnoreCase("Manual")) {
                System.out.print("Masukkan Durasi (jam): ");
                double durasi = input.nextDouble();
                kendaraan.hitungBiaya(durasi);
            } else {
                System.out.print("Waktu masuk     : ");
                int masuk = input.nextInt();
                System.out.print("Waktu keluar    : ");
                int keluar = input.nextInt();
                kendaraan.hitungBiaya(masuk, keluar);
            }

            System.out.println("\n---- PARKING ----");
            kendaraan.tampilkanRingkasan();

            // simpan data untuk laporan akhir
            totalKendaraan++;
            totalPendapatan += kendaraan.hitungTotalBiaya();

            System.out.print("\nApakah mau menambah kendaraan? (y/n): ");
            pilihan = input.next();

        } while (pilihan.equalsIgnoreCase("y"));

        System.out.println("\n========= HASIL AKHIR =========");
        System.out.println("Total Kendaraan Akhir      : " + totalKendaraan);
        System.out.println("Total Biaya Parkir         : " + totalPendapatan);
        System.out.println("Thank You.....");

        input.close();
    }
}