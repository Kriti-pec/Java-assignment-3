
// Java program to print one possible
// way of converting a string to another
import java.util.Scanner;
import java.util.ArrayList;

public class Ques5 {
    static ArrayList<ArrayList<String>> arrs = new ArrayList<ArrayList<String>>();

    // Function to print the steps
    static void printAllChanges(String s1, String s2, ArrayList<String> changes,int[][] cost) {

        int i = s1.length();
        int j = s2.length();

        // Iterate till end
        while (true) {

            if (i == 0 || j == 0) {
              // Add this list to our List of lists.
                arrs.add(changes);
                break;
            }

            // If same
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            }

            else {
                boolean if1 = false, if2 = false;

                // Replace
                if (cost[i][j] == cost[i - 1][j - 1] + 1) {

                    // Add this step
                    changes.add("Change " + s1.charAt(i - 1)
                            + " to " + s2.charAt(j - 1));
                    i--;
                    j--;

                    // note whether this 'if' was true.
                    if1 = true;
                }

                // Delete
                if (cost[i][j] == cost[i - 1][j] + 1) {
                    if (if1 == false) {
                        changes.add("Delete " + s1.charAt(i - 1));
                        i--;
                    } else {
                        // If the previous method was true,
                        // create a new list as a copy of previous.
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);

                        // Remove last operation
                        changes2.remove(changes.size() - 1);

                        // Add this new operation
                        changes2.add("Delete " + s1.charAt(i));

                        // initiate new new instance of this
                        // function with remaining substrings
                        printAllChanges(s1.substring(0, i),
                                s2.substring(0, j + 1), changes2,cost);
                    }

                    if2 = true;
                }

                // Add character step
                if (cost[i][j] == cost[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + s2.charAt(j - 1));
                        j--;
                    } else {

                        // Add steps
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);
                        changes2.remove(changes.size() - 1);
                        changes2.add("Add " + s2.charAt(j));

                        // Recursively call for the next steps
                        printAllChanges(s1.substring(0, i + 1), s2.substring(0, j), changes2,cost);
                    }
                }
            }
        }
    }

    static void printWays(String s1, String s2, ArrayList<String> changes,int[][] cost) {

        // Function to print all the ways
        printAllChanges(s1, s2, new ArrayList<String>(),cost);

        int i = 1;

        // print all the possible ways
        for (ArrayList<String> ar : arrs) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }

    // Function to compute the cost matrix
    static int[][] costArray(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        // initialize by the maximum edits possible
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // if the characters are same
                // no changes required
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];
                else {
                    int a = cost[i - 1][j - 1]; // Delete operation
                    int b = cost[i][j - 1];// Insert operation
                    int c = cost[i - 1][j]; // Replace operation
                    // minimum of three operations possible
                    cost[i][j] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i][j]++;
                }
            }
        }
        return cost;

    }

    // Driver Code
    public static void main(String[] args) throws Exception {
        // Take the strings input s1 and s2 to be compared
        Scanner s = new Scanner(System.in);
        System.out.print("Input string 1 ");
        String s1 = s.nextLine();
        System.out.print("Input string 2 ");
        String s2 = s.nextLine();

        // calculate the cost matrix
        int[][] cost = costArray(s1, s2);

        // print the steps
        printWays(s1, s2, new ArrayList<String>(),cost);

    }
}