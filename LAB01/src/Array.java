public class Array {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[10];
        int nItems;
        int i;
        int itemKey; // or item value

        arr[0] = 1;
        arr[1] = 34;
        arr[2] = 21;
        arr[3] = 100;
        arr[4] = 5;
        nItems = 5;

        // Display items
        for (i = 0; i < nItems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        // Find item based on its index/key
        itemKey = 100;
        for (i = 0; i < nItems; i++) {
            if (arr[i] == itemKey) { // found item?
                break; // if yes, then exit the loop and continue the if statement below
            }
        }

        if (i == nItems) {
            System.out.println("Found " + itemKey);
        } else {
            System.out.println("Can't found " + itemKey);
        }


    }
}
