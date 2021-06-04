public class Recursion {


    public static void main(String[] args) {
        // question 03
        System.out.println(puzzle(14,10)); // -1
        System.out.println(puzzle(4, 7)); // 120
        System.out.println(puzzle(0,0)); // 1

        // question 04 test
        System.out.println("Sum = " + sum4(5));

        // question 05 test
        System.out.println("Sum = " + sum5(10));

        // question 06 test
        int a[] = {1, 2, 3, 4, 8, 7, 9};
        System.out.println("Minimum = " + findMin(a, a.length));

        // question 07 test
        System.out.println("Sum of the array = " + findSum(a, a.length));

        // question 08 test
        System.out.println("Largest common divisor = " + gcd(10, 5));
    }

    // question 01, 02
    static int puzzle(int base, int limit) {
        if (base > limit) // <-- base case
            return -1;
        else if (base == limit) // <-- another base case
            return 1;
        else
            return base * puzzle(base + 1, limit); // <-- recursive case
    }

    // question 04
    static double sum4(int n) {
        if (n == 1)
            return 1;
        else
            return 1d / n + sum4(n - 1);
    }

    // question 05
    static int sum5(int n) {
        if (n == 1)
            return 1;
        else
            return n + sum5(n - 1);
    }

    // question 06
    static int findMin(int a[], int n) {
        if (n == 0)
            return a[0];
        else {
            int min = Math.min(a[n - 1], findMin(a, n - 1));
            return min;
        }
    }

    // question 07
    static int findSum(int a[], int n) {
        if (n == 1)
            return a[0];
        else
            return a[n - 1] + findSum(a, n - 1);
    }

    // question 08
    static int gcd(int p, int q) {
        if (q == 0)
            return p;
        else
            return gcd(q, p % q);
    }


}
