import java.util.Scanner;
public class Ques1{
    public static void main(String[] args)
    {
        // Take the strings input s1 and s2 to be compared 
        Scanner s = new Scanner(System.in);
        System.out.print("Input string 1 ");
        String s1 = s.nextLine();
        System.out.print("Input string 2 ");
        String s2 = s.nextLine();
        // Take a variable compared_value which will store the value after comparing the strings 
        int compared_value=0; 
        s.close();
        // Start iterating through characters in string s1 and compare characters in s1 at the same position as s2 
        // If unicode value of both the characters is same then continue otherwise make compared_value = (str1[i]-str2[i]) and break
        for(int i=0;i<s1.length() && i<s2.length();i++)
        {
            int val1 = s1.charAt(i);
            int val2 = s2.charAt(i);
            if(val1!=val2)
            {
                compared_value = val1-val2;
                break;
            }
            else{
                continue;
            }
        }
        // If s2 is a substring of s1 or s1 is a substring of s2 then take comapred_value = s1.length()-s2.length();
        if(compared_value==0 && (s1.length()>s2.length() || s2.length()>s1.length()))
        {
            compared_value = s1.length() - s2.length();
        }
        // Print the comapared_value 
        System.out.println("Strings comapared lexicographically return " + compared_value);
    }
}