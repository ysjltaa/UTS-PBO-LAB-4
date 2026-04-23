package jawaban1;

import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan() {
        this.daftarKaryawan = new ArrayList<>();
    }

    // Validasi ID Duplikat
    public boolean isIdExists(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public void tambahKaryawan(Karyawan k) {
        daftarKaryawan.add(k);
    }

    public boolean hapusKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) {
                daftarKaryawan.remove(k);
                return true;
            }
        }
        return false;
    }

    public Karyawan cariKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equalsIgnoreCase(id)) return k;
        }
        return null;
    }

    public void tampilkanSemua() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Daftar karyawan masih kosong.");
        } else {
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k);
            }
        }
    }

    // filter
    public void filterBerdasarkanPosisi(String posisi) {
        boolean ketemu = false;
        for (Karyawan k : daftarKaryawan) {
            if (k.getPosisi().equalsIgnoreCase(posisi)) {
                System.out.println(k);
                ketemu = true;
            }
        }
        if (!ketemu) System.out.println("Tidak ada karyawan di posisi: " + posisi);
    }

    public void tampilkanLaporan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data untuk laporan.");
            return;
        }
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.getGaji();
        }
        System.out.println("=== LAPORAN STATISTIK PERUSAHAAN ===");
        System.out.println("Total Karyawan  : " + daftarKaryawan.size());
        System.out.println("Total Beban Gaji: Rp" + total);
        System.out.println("Rata-rata Gaji  : Rp" + (total / daftarKaryawan.size()));
    }
}