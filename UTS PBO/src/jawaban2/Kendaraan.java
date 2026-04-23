package jawaban2;

public class Kendaraan {
    private String jenisKendaraan;
    private double durasiParkir;

    // Constructor: Menerima parameter jenis kendaraan
    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    // Overloading Method 1: Berdasarkan durasi manual
    public void hitungBiaya(double durasi) {
        this.durasiParkir = durasi;
    }

    // Overloading Method 2: Berdasarkan jam masuk dan jam keluar
    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        this.durasiParkir = jamKeluar - jamMasuk;
    }

    // mendapatkan biaya per jam sesuai jenis kendaraan menggunakan method
    public double getBiayaPerJam() {
        if (jenisKendaraan.equalsIgnoreCase("Motor")) {
            return 2000;
        } else if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
            return 5000;
        } else if (jenisKendaraan.equalsIgnoreCase("Truk")) {
            return 10000;
        } else {
            return 0;
        }
    }

    // Method untuk menghitung total biaya dengan diskon 10% jika > 5 jam
    public double hitungTotalBiaya() {
        double total = durasiParkir * getBiayaPerJam();
        if (durasiParkir > 5) {
            total = total * 0.9;
        }
        return total;
    }

    // Method untuk menampilkan ringkasan kendaraan
    public void tampilkanRingkasan() {
        System.out.println("Vehicle Type   : " + jenisKendaraan);
        System.out.println("Parking Time   : " + (int)durasiParkir + " hour(s)");
        System.out.println("Total Fee      : Rp" + hitungTotalBiaya());
    }

    public double getDurasiParkir() {
        return durasiParkir;
    }
}