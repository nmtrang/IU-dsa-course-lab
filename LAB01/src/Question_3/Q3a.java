package Question_3;

class Array {
    private int[] a;
    private int nElems;

    public Array(int max) {
        a = new int[max];
        nElems = 0;
    }

    public void insert(int value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public int convertToNumber() {
        int num = 0;
        for (int i = 0; i < nElems; i++) {
            num += a[i] * Math.pow(10, nElems - 1 - i);
        }
        return num;
    }

}

public class Q3a {
    public static void main(String[] args) {
        Array arr = new Array(100);
        arr.insert(2);
        arr.insert(5);
        arr.insert(4);
        arr.insert(1);
        arr.insert(1);
        arr.insert(9);
        arr.insert(9);
        arr.insert(8);

        System.out.println("Array converted to number -> " + arr.convertToNumber());
    }
}
