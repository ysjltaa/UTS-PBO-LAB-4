package jawaban1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();
        int menu;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Filter Berdasarkan Posisi");
            System.out.println("7. Laporan Statistik Gaji");
            System.out.println("8. Keluar");
            System.out.print("Masukkan pilihan: ");

            menu = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (menu) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = sc.nextLine();
                    if (perusahaan.isIdExists(id)) {
                        System.out.println("Error: ID '" + id + " sudah ada!");
                        break;
                    }
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String pos = sc.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    double gaji = sc.nextDouble();

                    if (gaji < 0) {
                        System.out.println("Error: Gaji tidak boleh negatif!");
                    } else {
                        perusahaan.tambahKaryawan(new Karyawan(id, nama, pos, gaji));
                        System.out.println("Karyawan berhasil ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    if (perusahaan.hapusKaryawan(sc.nextLine())) {
                        System.out.println("Karyawan berhasil dihapus.");
                    } else {
                        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan ID: ");
                    Karyawan kP = perusahaan.cariKaryawan(sc.nextLine());
                    if (kP != null) {
                        System.out.print("Masukkan posisi baru: ");
                        kP.setPosisi(sc.nextLine());
                        System.out.println("Posisi berhasil diubah.");
                    } else {
                        System.out.println("ID tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID: ");
                    Karyawan kG = perusahaan.cariKaryawan(sc.nextLine());
                    if (kG != null) {
                        System.out.print("Masukkan gaji baru: ");
                        double gb = sc.nextDouble();
                        if (gb >= 0) {
                            kG.setGaji(gb);
                            System.out.println("Gaji berhasil diubah.");
                        } else {
                            System.out.println("Gaji tidak boleh negatif.");
                        }
                    } else {
                        System.out.println("ID tidak ditemukan.");
                    }
                    break;

                case 5:
                    perusahaan.tampilkanSemua();
                    break;

                case 6:
                    System.out.print("Filter posisi: ");
                    perusahaan.filterBerdasarkanPosisi(sc.nextLine());
                    break;

                case 7:
                    perusahaan.tampilkanLaporan();
                    break;

                case 8:
                    System.out.println("Program ditutup. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 8);

        sc.close();
    }
}
