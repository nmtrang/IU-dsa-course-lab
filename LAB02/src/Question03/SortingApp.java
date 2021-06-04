package Question03;

public class SortingApp {
    public static void test(Array a) {
        long startTime, endTime;
        long average = 0;
        long sumOfTime = 0;

        Array arr1 = a.clone();
        Array arr2 = a.clone();
        Array arr3 = a.clone();

        System.out.println("Test case: " + a.getnElems());


        // --- bubble sort ---
        startTime = TimeUtils.now();
        arr1.bubbleSort();
        endTime = TimeUtils.now();
        System.out.printf("Bubble Sort: %d ms\n", endTime - startTime);
        System.out.println();

        // --- selection sort ---
        startTime = TimeUtils.now();
        arr2.selectionSort();
        endTime = TimeUtils.now();
        System.out.printf("Selection Sort: %d ms\n", endTime - startTime);
        System.out.println();

        // --- Insertion sort ---
        startTime = TimeUtils.now();
        arr3.insertionSort();
        endTime = TimeUtils.now();
        System.out.printf("Insertion Sort: %d ms\n", endTime - startTime);
        System.out.println();
    }



    public static void main(String[] args) {
        Integer maxSize = (Integer) 50000;
        Array a = new Array(maxSize);
        a.randomInit(maxSize);

//        a.inverse(); // uncomment this if you want to test ordinary sorting method without considering about order
        test(a);
    }
}
