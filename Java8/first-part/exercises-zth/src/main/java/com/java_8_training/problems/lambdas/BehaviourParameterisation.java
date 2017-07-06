package com.java_8_training.problems.lambdas;

import com.java_8_training.problems.lambdas.model.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class BehaviourParameterisation {


    //TODO: 1. Implement the method prettyPrintOnlyWeightApple which prints to the console something like 'An apple of 60 grams'



    //TODO: 2. Declare a new method prettyPrintApple which takes different formatters as parameter.
    // The formatter should be an interface that has a method which accepts an apple and returns a string from it.
    // Use the COllections.sort() method as an example

    //TODO: can you refactor prettyPrintOnlyWeightApple to use it?
    //TODO: can you refactor prettyPrintHeavyLightApple to use it?
    //TODO: can you make prettyPrintApple generic (i.e. can work with any type not just Apple)?

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        System.out.println("bad way");

        prettyPrintHeavyLightApple(inventory);
        System.out.println("good way");
        //prettyPrintOnlyWeightApple(inventory);
        prettyPrintApple(inventory, new AppleColorPrinter());
        prettyPrintApple(inventory, new AppleWheightPrinter());
    }

    public static void prettyPrintHeavyLightApple(List<Apple> inventory) {
        Objects.requireNonNull(inventory, "Inventory must not be null");
        for (Apple apple : inventory) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            String output = "A " + characteristic + " " + apple.getColor() + " apple";
            System.out.println(output);
        }
    }

    /**
     * Prints all the weights from the inventory one by one
     *
     * @param inventory
     */
    public static void prettyPrintOnlyWeightApple(List<Apple> inventory, Printer<Apple> applePrinter) {
        Objects.requireNonNull(inventory, "Inventory must not be null");
        // varianta java7
        // 1
        for (Apple apple :inventory)
            applePrinter.print(apple);
            //System.out.println("An apple of " + apple.getWeight() + "grams");
    }

    public  static void prettyPrintApple (List<Apple> inventory, Printer<Apple> printer) {
        for (Apple apple : inventory) {
            printer.print((Apple)apple);
        }
    }
}

@FunctionalInterface // trebuie sa aiba o singurs metoda abstracta
    //
interface Printer<T> {
    public void print(Apple apple);

    default void test() {

    }
}

class AppleColorPrinter  implements Printer <Apple> {

    @Override
    public void print(Apple apple) {
        System.out.println("A " + apple.getColor() +  " apple");
    }
}

class AppleWheightPrinter implements Printer <Apple> {
    public void print(Apple apple) {
        System.out.println("An apple of " + apple.getWeight() + " grams");
    }
}

class CustomPrinter implements Printer {

    @Override
    public void print(Apple object) {
        if (object instanceof Apple) {
            Apple apple = (Apple) object;
        }
    }
}