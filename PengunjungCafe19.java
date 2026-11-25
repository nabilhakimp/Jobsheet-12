/**
 * PengunjungCafe19
 */
public class PengunjungCafe19 {
    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        int a = hitungTotalBelanja(15000);
        int b = hitungTotalBelanja(15000, 20000, 22000);
        int c = hitungTotalBelanja(15000, 20000, 22000, 12000, 10000);

        System.out.println("Total 1 barang : Rp" + a);
        System.out.println("Total 3 barang : Rp" + b);
        System.out.println("Total 5 barang : Rp" + c);
    }
}

