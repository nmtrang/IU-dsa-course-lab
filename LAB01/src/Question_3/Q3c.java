package Question_3;

/*
Write a method named minGap() that accepts an integer array
and a number of elements as parameters and
returns the minimum 'gap' between adjacent values in the array.

The gap between two adjacent values in an array is
defined as the second value minus the first value.
For example, suppose a variable called array is
an array of integers that stores the following sequence of values:

int[] array = {1, 3, 6, 7, 12};
The first gap is 2 (3 - 1), the second gap is 3 (6 - 3),
the third gap is 1 (7 - 6) and the fourth gap is 5 (12 - 7).
Thus, the call of minGap(array, n) should return 1
because that is the smallest gap in the array.
If you are passed an array with fewer than 2 elements,
you should return 0.

TODO: 1. create minGap(int[] a, int nElems):int
      2. inside, insert all the gap to a new array called int[] gapValues
      3. print out the minimum value of gapValues[]

 */


public class Q3c {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 7, 12};
        System.out.println(minGap(array, array.length));
    }

    public static int minGap(int[] inputArray, int nElems) {
        int[] gapValues = new int[nElems - 1];
        int gap;

        if (inputArray.length < 2) {
            return 0;
        } else {
            for (int i = 0; i < nElems - 1; i++) {
                if (inputArray[i] == nElems - 1 && gapValues[i] == gapValues.length - 1)
                    break;
                else {
                    gap = Math.abs(inputArray[i + 1] - inputArray[i]); // calculate the gap by taking next value - previous value
                    gapValues[i] = gap; // add that gap to i-th position of gapValues.
                }

            }
        }

        int minGap = gapValues[0];
        for (int i = 1; i < gapValues.length; i++) {
            if (gapValues[i] < minGap) {
                minGap = gapValues[i];
            }
        }

        return minGap;
    }


}
