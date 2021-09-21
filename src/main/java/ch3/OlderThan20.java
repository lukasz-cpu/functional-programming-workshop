package ch3;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OlderThan20 {
    public static void main( String[] args ) {
        final List<Person> people = Arrays.asList(
                new Person( "Robert", 49 ),
                new Person( "John", 20 ),
                new Person( "Sara", 21 ),
                new Person( "Chloe", 18 ),
                new Person( "Jane", 21 ),
                new Person( "Greg", 35 ) );

        List<Person> olderThan20_a = new ArrayList<>();
        people.stream()
                .filter( person -> person.age > 20 )
                .forEach( person -> olderThan20_a.add( person ) );
        printPeople( "", olderThan20_a );

        List<Person> olderThan20_b = people.stream()
                .filter( person -> person.age > 20 )
                .collect( ArrayList::new, ArrayList::add, ArrayList::addAll );
        printPeople( "", olderThan20_b );

        List<Person> olderThan20_c = people.stream()
                .filter( person -> person.age > 20 )
                .collect( Collectors.toList() );
        printPeople( "", olderThan20_c );

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect( Collectors.groupingBy( person -> person.age ) );

        Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
                .collect(
                        Collectors.groupingBy(
                                person -> person.age,
                                Collectors.mapping( person -> person.name, Collectors.toList() ) ) );


        Comparator<Person> byAge = Comparator.comparing( person -> person.age );
        Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream()
                .collect(
                        Collectors.groupingBy(
                                person -> person.name.charAt( 0 ),
                                Collectors.reducing( BinaryOperator.maxBy( byAge ) ) ) );
        System.out.println( "Oldest person of each letter:" );
        System.out.println( oldestPersonOfEachLetter );
    }

    public static void printPeople( final String message, final List<Person> people ) {
        System.out.println( message );
        people.forEach( System.out::println );
    }

}