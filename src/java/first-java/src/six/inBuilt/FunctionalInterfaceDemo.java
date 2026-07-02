package six.inBuilt;

import java.util.function.Function;

public class FunctionalInterfaceDemo {

    public static Function<Integer, Integer> addFunction = (a) -> a + 3;
    public static Function<Integer, Integer> subtractFunction = (a) -> a - 7;

    public static Function<Integer, Integer> combination =
            addFunction.andThen(subtractFunction);

    public static void main(String[] args) {
        System.out.println(addFunction.apply(10));
        System.out.println(subtractFunction.apply(10));
        System.out.println(combination.apply(10));
    }
}
