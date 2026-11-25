import java.util.Locale;
import java.util.Scanner;

public class BankSampah19 {

    // satu Scanner dipakai bersama oleh semua fungsi
    static Scanner input = new Scanner(System.in).useLocale(Locale.US);

    // a. membaca setoran n nasabah, mengembalikan array double[]
    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = input.nextDouble();
        }
        return setoran;
    }

    // b. menampilkan setoran tiap nasabah
    static void tampilSetoran(double[] setoran) {
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + " : " + setoran[i] + " kg");
        }
    }

    // c. total berat seluruh setoran
    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    // d. saldo = berat x harga per kg
    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    // e. indeks nasabah dengan setoran terbesar
    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    // f. main
    public static void main(String[] args) {
        final double HARGA_PER_KG = 3000;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = input.nextInt();

        double[] setoran = inputSetoran(n);

        System.out.println("\n=== DATA SETORAN ===");
        tampilSetoran(setoran);

        System.out.println("\n=== SALDO TIAP NASABAH (Rp" + (int) HARGA_PER_KG + "/kg) ===");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], HARGA_PER_KG);
            System.out.println("Nasabah ke-" + (i + 1) + " : Rp" + saldo);
        }

        System.out.println("\nTotal setoran seluruh nasabah : " + totalSetoran(setoran) + " kg");

        int idx = nasabahTerbanyak(setoran);
        System.out.println("Setoran terbanyak : nasabah ke-" + (idx + 1)
                + " (" + setoran[idx] + " kg)");

        input.close();
    }
}