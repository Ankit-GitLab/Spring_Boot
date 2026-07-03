package six.inBuilt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        // ::

        // 1 using for  loop
        List<String> names = Arrays.asList("Ankit","Moto","Daksha");
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }

        // 2 using enhanced for loop
        for(String name : names){
            System.out.println(name);
        }

      /*  names.forEach(new Consumer<String>(){
            public void accept(String s){
                System.out.println(s);
            }
        }); */

        names.forEach((name) -> System.out.println(name));
    }
}
