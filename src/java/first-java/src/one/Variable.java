package one;

public class Variable {

    /**
     * This is JavaDoc Comment
     */

    public static void main(String[] args) {

        // Declaration
        int a;
        String name;

        // Initialization
        a = 10;
        name = "Java";

        int age = 20;

        System.out.println("Hello, " + name + ". You are " + age + " years old");

        // Your name, your age, your favourite programming language
        name = "Faisal";
        age = 25;
        String language = "Java";

        System.out.println("Hello, " + name + ". You are " + age
                + " years old. You love " + language + ".");

        // CONSTANT
        final int CONSTANT_VALUE = 3;

        System.out.println("Constant Value = " + CONSTANT_VALUE);
    }
}