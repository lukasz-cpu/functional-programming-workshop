package ch2;

import java.util.List;
import java.util.Optional;

import static ch2.Folks.friends;

public class PickAnElement {
    public static void uglyPickName(final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void functionalPickName(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();
        System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
        foundName.ifPresent(name -> System.out.println("Hello " + name));
    }

    public static void main(final String[] args) {
        uglyPickName(friends, "N");
        uglyPickName(friends, "Z");

        functionalPickName(friends, "N");
        functionalPickName(friends, "Z");
    }

}