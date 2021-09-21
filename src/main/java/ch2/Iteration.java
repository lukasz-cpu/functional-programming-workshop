package ch2;

import static ch2.Folks.friends;

public class Iteration {

    public static void main(final String[] args) {
        System.out.print("for i gets 0....");
        for (int i = 0; i < friends.size(); i++) {
            System.out.print(" " + friends.get(i));
        }

        for (String name : friends) {
            System.out.print(" " + name);
        }

        friends.forEach(name -> System.out.print(" " + name));

        friends.forEach((final String name) -> System.out.print(" " + name));

        friends.forEach((name) -> System.out.print(" " + name));

        friends.forEach(name -> System.out.print(" " + name));

        friends.forEach(System.out::print);
    }
}