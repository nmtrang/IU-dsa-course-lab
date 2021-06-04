public class LowArray {
    private long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    // set the value or map the index with the value
    public void setElem(int index, long value) {
        a[index] = value;
    }

    // get the value based on its index
    public long getElem(int index) {
        return a[index];
    }

    public static void main(String[] args) {
        LowArray arr = new LowArray(10);
        int nElems = 0;
        int i;

        arr.setElem(0, 77);
        arr.setElem(1, 45);
        arr.setElem(2, 100);
        arr.setElem(3, 67);
        arr.setElem(4, 23);
        nElems = 5;

        // Display items
        for (i = 0; i < nElems; i++) {
            System.out.print(arr.getElem(i) + " ");
        }

        // Search for item based on its value
        int itemKey = 67;
        for (i = 0; i < nElems; i++) {
            if (arr.getElem(i) == itemKey) {
                break;
            }
        }

        if (i == nElems) {
            System.out.println("Can't find " + itemKey);
        } else {
            System.out.println("Found " + itemKey);
        }

        // Delete an item based on its value
        for (i = 0; i < nElems; i++) {
            if (arr.getElem(i) == 100) {
                break;
            }
            for (int k = i; k < nElems; k++) {
                arr.setElem(k, arr.getElem(k + 1));
            }
            nElems--;
        }

        for (i = 0; i < nElems; i++) {
            System.out.print(arr.getElem(i) + " ");
        }
        System.out.println(" ");
    }
}
