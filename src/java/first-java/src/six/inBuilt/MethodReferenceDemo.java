package six.inBuilt;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {

        // ::
        List<String> names = Arrays.asList("Ankit","Moto","Daksha");
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }
    }
}
