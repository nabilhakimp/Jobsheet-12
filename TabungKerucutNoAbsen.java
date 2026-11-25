import java.util.Locale;
import java.util.Scanner;

public class TabungKerucutNoAbsen {

    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;              // luas alas x tinggi
    }

    static double luasPermukaanTabung(double r, double t) {
        return 2 * Math.PI * r * (r + t);         // 2 x pi x r x (r + t)
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;            // 1/3 volume tabung
    }

    public static void main(String[] args) {
        // Locale.US: angka desimal ditulis dengan titik (7.5), aman di komputer berlokal Indonesia
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int pilihan;

        do {
            System.out.println("\n===== MENU BANGUN RUANG =====");
            System.out.println("1. Luas lingkaran");
            System.out.println("2. Volume tabung");
            System.out.println("3. Luas permukaan tabung");
            System.out.println("4. Volume kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan jari-jari (r): ");
                double r = input.nextDouble();
                double t = 0;
                if (pilihan != 1) {
                    System.out.print("Masukkan tinggi (t): ");
                    t = input.nextDouble();
                }

                switch (pilihan) {
                    case 1:
                        System.out.printf("Luas lingkaran = %.2f%n", luasLingkaran(r));
                        break;
                    case 2:
                        System.out.printf("Volume tabung = %.2f%n", volumeTabung(r, t));
                        break;
                    case 3:
                        System.out.printf("Luas permukaan tabung = %.2f%n", luasPermukaanTabung(r, t));
                        break;
                    case 4:
                        System.out.printf("Volume kerucut = %.2f%n", volumeKerucut(r, t));
                        break;
                }
            } else if (pilihan == 0) {
                System.out.println("Program selesai.");
            } else {
                System.out.println("Menu tidak tersedia");
            }
        } while (pilihan != 0);

        input.close();
    }
}