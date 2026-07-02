package six;


@FunctionalInterface
interface BookAction {
    void perform();
}
// Functional Interface with parameter
@FunctionalInterface
interface Operation{
    int add(int a,int b);
}

// parameter --> expression
// () -> {}
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        BookAction action =() -> System.out.println("Action performed");

        // Functional Interface with parameter
        Operation op1 =(int a, int b) -> {
            return a + b;
        };
        System.out.println(op1.add(10,20));

        new Thread(() -> System.out.println("New Thread Created")) .start();
    }
}