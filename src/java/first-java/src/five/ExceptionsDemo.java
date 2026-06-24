package five;

public class ExceptionsDemo {
    public static void main(String[] args) {
        int a = 10;


        try{
            int result = 10/0;
            System.out.println("Done");
        }catch (Exception e){
            System.out.println("in catch block");
        }
    }
}
