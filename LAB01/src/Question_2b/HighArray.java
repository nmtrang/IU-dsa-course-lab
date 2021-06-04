package Question_2b;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return a.length;
    }

    public boolean find(long itemKey) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] == itemKey) {
                break;
            }
        }
        if (i == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (value == a[i]) {
                break;
            }
        }

        if (i == nElems) {
            return false;
        } else {
            for (int k = i; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public long getMax() {
        long maxKey = 0;
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] > maxKey) {
                maxKey = a[i];
            }
        }
        return maxKey;
    }

    public long removeMax() {
        if (nElems == 0) {
            return -1;
        } else {
            long max = getMax();
            while (delete(max));
            return max;
        }
    }

    public void noDups() {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] == a[j]) {
                    delete(a[j]);
                }
            }
        }

    }

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(99);
        arr.insert(33);
        arr.insert(22);
        arr.insert(88);

        System.out.print("Initial arr = ");
        arr.display();


        int itemKey = 44;
        if (arr.find(itemKey)) {
            System.out.println("Found " + itemKey);
        } else {
            System.out.println("Can't find " + itemKey);
        }

        arr.noDups();
        System.out.print("New arr = ");
        arr.display();
        System.out.println("Removed max key");
        arr.removeMax();
        arr.display();

    }
}
