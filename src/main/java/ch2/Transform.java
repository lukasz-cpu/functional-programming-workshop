package ch2;

import java.util.ArrayList;
import java.util.List;

import static ch2.Folks.friends;

public class Transform {
    public static void main( final String[] args ) {
        {
            // self-inflicted wound pattern...
            final List<String> uppercaseNames = new ArrayList<>();
            for ( String name : friends ) {
                uppercaseNames.add( name.toUpperCase() );
            }
            System.out.println( "for x in y...." + uppercaseNames );
        }
        {
            final List<String> uppercaseNames = new ArrayList<>();
            friends.forEach( name -> uppercaseNames.add( name.toUpperCase() ) );
        }


        List<String> strings = friends.stream()
                .map(name -> name.toUpperCase()).toList();


        friends.stream().map( name -> name.toUpperCase() ).forEach( name -> System.out.print( name + " " ) );

        friends.stream().map( name -> name.length() )
                .forEach( count -> System.out.print( count.getClass().getSimpleName() + "( " + count + " ) " ) );

        friends.stream().map( String::toUpperCase ).forEach( name -> System.out.print( name + " " ) );
    }

}
