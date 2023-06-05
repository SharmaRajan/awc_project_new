import java.util.stream.IntStream;

public class NThLargestElemFromArray {

    public static void main(String[] args) {
        NThLargestElemFromArray nth = new NThLargestElemFromArray();

        Integer[] arr = new Integer[]{1,5,1,54,90,32,21,100};

//        int result = nth.nThLargestElement(new int[]{1,5,1,54,90,32,21,100},4);
//        System.out.println("nTHLargestElement: " + result);
        System.out.println(nth.findKthElementByQuickSelect(arr,2,3,2));

//        System.out.println(nth.randomPartition(arr,0,4));

    }


    public int randomPartition(Integer arr[], int left, int right) {
        int n = right - left + 1;
        int pivot = (int) (Math.random()) * n;
        swap(arr, left + pivot, right);
        return partition(arr, left, right);
    }

    public int findKthElementByQuickSelect(Integer[] arr, int left, int right, int k) {
        if (k >= 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right);
            if (pos - left == k) {
                return arr[pos];
            }
            if (pos - left > k) {
                return findKthElementByQuickSelect(arr, left, pos - 1, k);
            }
            return findKthElementByQuickSelect(arr, pos + 1,
                    right, k - pos + left - 1);
        }
        return 0;
    }

    private int partition(Integer[] arr, int left, int right) {
        int pivot = arr[right];
        Integer[] leftArr;
        Integer[] rightArr;

        leftArr = IntStream.range(left, right)
                .filter(i -> arr[i] < pivot)
                .map(i -> arr[i])
                .boxed()
                .toArray(Integer[]::new);

        rightArr = IntStream.range(left, right)
                .filter(i -> arr[i] > pivot)
                .map(i -> arr[i])
                .boxed()
                .toArray(Integer[]::new);

        int leftArraySize = leftArr.length;
        System.arraycopy(leftArr, 0, arr, left, leftArraySize);
        arr[leftArraySize+left] = pivot;
        System.arraycopy(rightArr, 0, arr, left + leftArraySize + 1,
                rightArr.length);

        return left + leftArraySize;
    }

    public int partitionIterative(Integer[] arr, int left, int right) {
        int pivot = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(Integer[] arr, int n1, int n2) {
        int temp = arr[n2];
        arr[n2] = arr[n1];
        arr[n1] = temp;
    }


    public int nThLargestElement(int[] arr,int nElement){

        if(nElement < 0 || nElement > arr.length)
            return -1;

        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int temp1 : arr)
            System.out.print(temp1 + " ");
        System.out.println();
        return arr[nElement];
    }


}
