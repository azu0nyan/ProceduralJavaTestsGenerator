package JavaTests;

public class CyclesTest {
    // ex x=3 y= 15 k = 4
    //x < y      (y - x) / k
    public static int stepsCount(int x, int y, int k) {
        int sum = 0;
        for (int i = x; i < y; i = i + k) sum++;
        return sum;
    }

    // ex x=3 y= 15 k = 4
    //x < y      (x - y) * k
    public static int xmymullk(int x, int y, int k) {
        int sum = 0;
        for (int i = x; i < y; i++) sum += k;
        return sum;
    }

    //0 < x  2^31 - 1
    public static int digitsSum(int x) {
        int y = 0;
        while (x > 0) {
            y = y + x % 10;
            x = x / 10;
        }
        return y;
    }

    //digs count
    //0 < x  2^31 - 1
    public static int digitsCount(int x) {
        int y = 0;
        while (x > 0) {
            y++;
            x = x / 10;
        }
        return y;
    }

    //n 0 - 100
    public static int failedSwapTest(int n) {
        int x[] = {n, n + 1, n + 2, n + 3, n + 4, n + 5, n + 6, n + 7, n + 8, n + 9};
        for (int i = 0; i < x.length; i++) {
            int tmp = x[i];
            x[i] = x[x.length - 1 - i];
            x[x.length - 1 - i] = tmp;
        }
        return x[3];
    }

    public static int swapTest(int n) {
        int x[] = {n, n + 1, n + 2, n + 3, n + 4, n + 5, n + 6, n + 7, n + 8, n + 9, n + 10};
        for (int l = 0, r = x.length - 1; l < r; l++, r--) {
            int t = x[l];
            x[l] = x[r];
            x[r] = t;
        }
        return x[4];
    }

    //n - 100 - 1000
    public static int closestToFromBotNotGreaterThan(int n) {
        int a[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > c && a[i] < n) {
                c = a[i];
            }
        }
        return c;
    }

    //n 100 - 1000
    public static int arrayIndexes(int n) {
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i - 1;
        }
        return a[n / 3];
    }




}
