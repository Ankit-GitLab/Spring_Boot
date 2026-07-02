package six;

@FunctionalInterface
interface BookAction {
    void perform();
}

// parameter --> expression
// () -> {}
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        BookAction action =() ->  {
                System.out.println("Action performed");
        };
        action.perform();
    }
}