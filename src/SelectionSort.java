import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comp) {

        // get the total number of items in the list
        int n = list.size();

        // outer loop handles controlling the position where the next smallest element should go
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // for the first iteration, we set the minimum index to the current position for tracking

            // inner loop handles finding the smallest element in the unsorted portion of the list
            for (int j = i + 1; j < n; j++) {
                // this handles comparing the current element with the smallest element found so far
                // if the current element is smaller, it updates the minimum index
                if (comp.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // this handles swapping the current element with the smallest element found
            Student temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}