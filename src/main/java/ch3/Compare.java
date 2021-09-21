package ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Compare {

    public static void main( String[] args ) {
        final List<Person> people = Arrays.asList(
                new Person( "Robert", 49 ),
                new Person( "John", 20 ),
                new Person( "Sara", 21 ),
                new Person( "Chloe", 18 ),
                new Person( "Jane", 21 ),
                new Person( "Greg", 35 ) );

        printPeople( "ascendingByAge", sortORama( people, Comparator.comparingInt(p -> p.age)) );
        printPeople( "ascendingByAgeAlt", sortORama( people, Compare::compareByAge ) );

        Comparator<Person> compareAscending = Comparator.comparingInt(p -> p.age);
        Comparator<Person> compareDescending = compareAscending.reversed();
        Comparator<Person> bobsDescending = ( p1, p2 ) -> -compareAscending.compare( p1, p2 );

        printPeople( "compareAscending", sortORama( people, compareAscending ) );
        printPeople( "compareDescending", sortORama( people, compareDescending ) );
        printPeople( "bobsDescending", sortORama( people, bobsDescending ) );

        printPeople( "ascendingByName", sortORama( people, Comparator.comparing(p -> p.name)) );


        people.stream()
                .min( compareAscending )
                .ifPresent( p -> System.out.printf( "youngest %s\n", p ) );
        people.stream()
                .max( compareAscending )
                .ifPresent( p -> System.out.printf( "oldest %s\n", p ) );

        final Function<Person, String> byName = person -> person.name;
        final Function<Person, Integer> byAge = person -> person.age;
        printPeople( "ascendingByAgeThenName", sortORama( people, Comparator.comparing( byAge )
                .thenComparing( byName ) ) );
    }


    static List<Person> sortORama( List<Person> list, Comparator<Person> c ) {
        return list.stream()
                .sorted( c )
                .collect( toList() );
    }

    static int compareByAge( Person p1, Person p2 ) {
        return p1.age - p2.age;
    }

    public static void printPeople( final String message, final List<Person> people ) {
        System.out.println( message );
        people.forEach( System.out::println );
    }

}
