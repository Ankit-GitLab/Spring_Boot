package six.inBuilt;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {

    public static BiFunction<Integer, Integer, Integer> addFunction = (a,b) -> a + b;

    public static BiFunction<Integer, Integer, Integer> subtractFunction = (a,b) -> a - b;
    public static void main(String[] args) {
        System.out.println(addFunction.apply(2,56));

        System.out.println(subtractFunction.apply(12,6));

        Function<Integer, Integer> multipleBy2 = x -> x* 2;
        BiFunction<Integer, Integer, Integer> combinedFunction =
                addFunction.andThen(multipleBy2);

        System.out.println(combinedFunction.apply(2,3));
    }


}
