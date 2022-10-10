import java.util.Scanner;
public class Ques3 {
    public static void main(String[] args)
    {
        // Take the strings input s1 and s2 to be compared 
        Scanner s = new Scanner(System.in);
        System.out.print("Input string 1 ");
        String s1 = s.nextLine();
        System.out.print("Input string 2 ");
        String s2 = s.nextLine();
        // Take a variable compared_value which will store the value after comparing the strings 
        // 1) If s1>s2 then it will store a positive value
        // 2) If s1==s2 then it will store 0
        // 3) If s1<s2 then it will store a negative value 
        int compared_value= s1.compareTo(s2);
        s.close();
        System.out.println("COMPARISON OF STRING1 AND STRING2 RETURNS "+compared_value);
    }
}
