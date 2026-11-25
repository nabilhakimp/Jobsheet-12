public class HitungBalok19 {
    static int hitungLuas(int a, int b) {
        return a * b;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    static int hitungVolume(int p, int l, int t) {
        return p * l * t;
    }

    public static void main(String[] args) {
        int[][] balok = {{4, 3, 5}, {2, 2, 2}, {6, 4, 3}};

        for (int i = 0; i < balok.length; i++) {
            int p = balok[i][0];
            int l = balok[i][1];
            int t = balok[i][2];

            System.out.println("Balok " + (i + 1) + " (" + p + " x " + l + " x " + t + ")");
            System.out.println("  Luas permukaan : " + hitungLuasPermukaanBalok(p, l, t));
            System.out.println("  Volume         : " + hitungVolume(p, l, t));
        }
    }
}