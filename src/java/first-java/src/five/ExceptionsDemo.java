package five;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try{
            //Exception generating statements
            int result = 10/0;
            System.out.println("Done");
        }catch (Exception e){
            //Exception handling statements
            System.out.println("in catch block");
        }
        System.out.println("DONE");

        int[] a = {1,2,3};

        try{
            System.out.println(a[6]);
            System.out.println("DONE");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("in catch block array give an error");
        }catch (ArithmeticException e) {

        }finally {
            // ALWAYS EXECUTES
            System.out.println("FINALLY");
        }
        System.out.println("OUTSIDE TRY CATCH");

//        System.out.println(a[6]);

        try {
            FileReader fileReader = new FileReader("abc.txt");
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
        }
    }
}
