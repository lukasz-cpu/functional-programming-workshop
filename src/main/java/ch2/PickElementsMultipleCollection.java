package ch2;

import java.util.function.Predicate;

import static ch2.Folks.editors;

public class PickElementsMultipleCollection {
    public static void main( final String[] args ) {
        {
            final long countFriendsStartN = Folks.friends.stream().filter(name -> name.startsWith( "N" ) ).count();
            // Yuk..
            final long countEditorsStartN = Folks.editors.stream().filter( name -> name.startsWith( "N" ) ).count();
            // Yuk.
            final long countComradesStartN = Folks.comrades.stream().filter( name -> name.startsWith( "N" ) ).count();

            System.out.println( countFriendsStartN );
            System.out.println( countComradesStartN );
            System.out.println( countEditorsStartN );
        }

        {
            // Thats better...
            final Predicate<String> startsWithN = name -> name.startsWith( "N" );

            final long countFriendsStartN = Folks.friends.stream().filter( startsWithN ).count();
            final long countEditorsStartN = Folks.editors.stream().filter( startsWithN ).count();
            final long countComradesStartN = Folks.comrades.stream().filter( startsWithN ).count();

            System.out.println( countFriendsStartN );
            System.out.println( countComradesStartN );
            System.out.println( countEditorsStartN );
        }
    }

}