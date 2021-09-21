package ch2;

import ch2.Folks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ch2.Folks.friends;

public class PickElements {
    public static void main(final String[] args) {
        {
            final List<String> startsWithN = new ArrayList<>();
            for (String name : friends) {
                if (name.startsWith("N")) {
                    startsWithN.add(name);
                }
            }
            System.out.println(String.format("for x in y...Found %d names", startsWithN.size()));
        }


        List<String> n = friends.stream().filter(name -> name.startsWith("N")).collect(Collectors.toList());
        System.out.println( String.format( "Stream.filter.collect...Found %d names", n.size() ) );


    }


}
