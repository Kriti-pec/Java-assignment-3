import java.util.Scanner;

public class Ques2 {
    public static void main(String[] arg) {
        // Take the size of array as input 
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size = s.nextInt();
        // Declare an array arr of size taken as input 
        int arr[] = new int[size];
        // Take a count array ( size 21 as the array numbers are in range 0-20) to store the count of each number in array arr
        int count[] = new int[21];
        // Take the numbers in array as input from user and parallely keep a count of each number in count array
        System.out.println("Enter the numbers in array ");
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
            count[arr[i]]++;
        }
        // Modify the count array such that each element at each index stores the sum of previous counts.
        for (int i = 1; i < 21; i++) {
            count[i] += count[i - 1];
        }
        int k = size - 1;
        int sortedarray[] = new int[size]; // For storing the sorted array
        // Iterate array arr and copy the element i at its correct position count[arr[k]]-1 according to count array in sortedarray 
        // After placing each element at its correct position, decrease its count by one.
        while (k >= 0) {
            sortedarray[count[arr[k]] - 1] = arr[k];
            count[arr[k]] -= 1;
            k -= 1;
        }
        // Print the sorted array 
        System.out.println("SORTED ARRAY IS ");
        for (int i = 0; i < size; i++) {
            System.out.println(sortedarray[i]);
        }
        s.close();

    }
}
