package Question_3;

class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long itemKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == itemKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (a[curIn] < itemKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (a[i] > value)
                break;
        }

        for (int k = nElems; k > i; k--) {
            a[k] = a[k - 1];
        }
        a[i] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public long calculateMedian() {
        long median;
        if (nElems % 2 != 0)    // if there is odd number of elements, then the median will be the middle value
            median = a[nElems / 2];
        else // even number of elements, median will be the average of 2 middle values
            median = (a[(nElems - 1) / 2] + a[(nElems + 1) / 2]) / 2;

        return median;
    }
}


public class Q3b {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(10);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(66);
        arr.insert(33);

        arr.display();
        System.out.println("Median = " + arr.calculateMedian());
    }
}
