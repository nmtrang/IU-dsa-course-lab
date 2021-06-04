package Question_2b;

public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems)
            return false;
        else
        {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    // -----------------------------------------------------------
    public OrdArray merge(OrdArray inputArr, int maxSize) {
        OrdArray newArr = new OrdArray(maxSize);

        int idxA = 0;
        int idxB = 0;

        while (idxA < this.nElems || idxB < inputArr.nElems) {
            if (idxA == this.nElems || this.a[idxA] > inputArr.a[idxB]) {
                newArr.a[newArr.nElems++] = inputArr.a[idxB];
                idxB++;
            } else if (idxB == inputArr.nElems || this.a[idxA] <= inputArr.a[idxB]) {
                newArr.a[newArr.nElems++] = this.a[idxA];
                idxA++;
            }
        }

        return newArr;
    }


    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr1 = new OrdArray(maxSize);
        OrdArray arr2 = new OrdArray(maxSize);

        arr1.insert(1);
        arr1.insert(3);
        arr1.insert(2);

        arr2.insert(2);
        arr2.insert(77);
        arr2.insert(99);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(22);
        arr2.insert(88);
        arr2.insert(11);
        arr2.insert(00);
        arr2.insert(66);
        arr2.insert(33);

        OrdArray mergedArray = arr1.merge(arr2, 2*maxSize);
        System.out.println("Merged Array: ");
        mergedArray.display();
    }

}