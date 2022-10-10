import java.util.Scanner;
public class Ques4 {
    public static void main(String[] args)
    {
        // Take the input number for which Hailstone sequence is to be printed 
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER ");
        int n = s.nextInt();
        s.close();
        System.out.println("Hailstone Sequence for "+n+" is");
        System.out.println(n);
        // While n is not equal to 1 check if n is even, if yes then reduce it by half otherwise increment by multiplying it by three and adding one
        // At each iteration print n 
        while(n!=1)
        {
            if(n%2==0)
            {
                n = n/2;
            }
            else{
                n = (3*n)+1;
            }
            System.out.println(n);
        }
    }
}
