package ch2;

import java.util.function.Function;
import java.util.function.Predicate;

import static ch2.Folks.friends;

public class PickDifferentNames {
    public static void main(final String[] args) {
        {
            final Predicate<String> startsWithN = name -> name.startsWith("N");
            final Predicate<String> startsWithB = name -> name.startsWith("B");

            final long countFriendsStartN = friends.stream()
                    .filter(startsWithN)
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter(startsWithB)
                    .count();

            System.out.println("countFriendsStartN: " + countFriendsStartN);
            System.out.println("countFriendsStartB: " + countFriendsStartB);
        }
        {
            final Predicate<String> startsWithNorB = name -> (name.startsWith("N") || name.startsWith("B"));

            final long countFriendsStartNorB = friends.stream()
                    .filter(startsWithNorB)
                    .count();

            System.out.println("countFriendsStartNorB: " + countFriendsStartNorB);
        }
        {
            final Predicate<String> startsWithN = name -> name.startsWith("N");
            final Predicate<String> startsWithB = name -> name.startsWith("B");

            final long countFriendsStartNorB = friends.stream()
                    .filter(startsWithN.or(startsWithB))
                    .count();

            System.out.println("countFriendsStartNorB: " + countFriendsStartNorB);
        }
        {
            final long countFriendsStartN = friends.stream()
                    .filter(checkIfStartsWith("N"))
                    .count();
            final long countFriendsStartB = friends.stream()
                    .filter(checkIfStartsWith("B"))
                    .count();

            System.out.println("countFriendsStartN: " + countFriendsStartN);
            System.out.println("countFriendsStartB: " + countFriendsStartB);
        }

        final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith( letter );

        final long countFriendsStartN = friends.stream()
                .filter( startsWithLetter.apply( "N" ) )
                .count();
        final long countFriendsStartB = friends.stream()
                .filter( startsWithLetter.apply( "B" ) )
                .count();

        System.out.println( "countFriendsStartN: " + countFriendsStartN );
        System.out.println( "countFriendsStartB: " + countFriendsStartB );
    }

    public static Predicate<String> checkIfStartsWith( final String letter ) {
        return name -> name.startsWith( letter );
    }


}