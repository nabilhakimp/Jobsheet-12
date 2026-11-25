import java.util.Scanner;

public class RekapLaundry19 {

    static Scanner input = new Scanner(System.in);

    // 1. input berat cucian tiap layanan untuk tiap hari
    static void inputData(int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian " + hari[j] + " (kg): ");
                data[i][j] = input.nextInt();
            }
        }
    }

    // 2. tampilkan seluruh data dalam bentuk tabel
    static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.printf("%-14s %-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%10s", h);
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s Rp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%10d", data[i][j]);
            }
            System.out.println();
        }
    }

    // 3. total berat satu layanan selama seluruh hari (jumlah baris ke-idxLayanan)
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    // fungsi bantu: total berat semua layanan pada satu hari (jumlah kolom ke-idxHari)
    static int totalPerHari(int[][] data, int idxHari) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i][idxHari];
        }
        return total;
    }

    // 4. tampilkan layanan dengan total berat tertinggi
    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan total cucian tertinggi: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    // 5. indeks hari dengan total berat terbesar
    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        for (int j = 1; j < data[0].length; j++) {
            if (totalPerHari(data, j) > totalPerHari(data, idxMax)) {
                idxMax = j;
            }
        }
        return idxMax;
    }

    // 6. pendapatan tiap layanan dan total pendapatan
    static void hitungPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            System.out.println(layanan[i] + " : Rp" + pendapatan);
            totalPendapatan += pendapatan;
        }
        System.out.println("Total pendapatan : Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        System.out.print("Jumlah layanan: ");
        int jumlahLayanan = input.nextInt();
        System.out.print("Jumlah hari: ");
        int jumlahHari = input.nextInt();
        input.nextLine();   // membuang sisa Enter agar nextLine() berikutnya tidak kosong

        // ukuran array mengikuti input pengguna
        String[] layanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];
        String[] hari = new String[jumlahHari];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = input.nextLine();
            System.out.print("Harga per kg layanan ke-" + (i + 1) + ": ");
            harga[i] = input.nextInt();
            input.nextLine();
        }

        for (int j = 0; j < jumlahHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }

        inputData(data, layanan, hari);

        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        tampilTabel(data, layanan, harga, hari);

        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + " : " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxHari]
                + " (" + totalPerHari(data, idxHari) + " kg)");

        System.out.println("\n=== PENDAPATAN ===");
        hitungPendapatan(data, layanan, harga);

        input.close();
    }
}