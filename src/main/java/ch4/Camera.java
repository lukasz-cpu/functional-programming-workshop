package ch4;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {
    // BobK: This
    // "earlier argument is the input value the later is the return value" is
    // going to take some getting used to
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    @SafeVarargs
    public final void setFilters( final Function<Color, Color>... filters ) {
        filter = Stream.of( filters )
                .reduce( ( filter, next ) -> filter.compose( next ) )
                .orElse( color -> color );
    }

    public Color capture( final Color inputColor ) {
        // More processing of color...
        final Color processedColor = filter.apply( inputColor );
        return processedColor;
    }

    public static void main( final String[] args ) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo ) -> System.out.println( String.format(
                "with %s: %s",
                filterInfo,
                camera.capture( new Color(170, 76, 170) ) ) );

        printCaptured.accept( "no filter" );

        camera.setFilters( Color::darker, Color::brighter);
        printCaptured.accept( "brighter filter" );

        camera.setFilters( Color::darker );
        printCaptured.accept( "darker filter" );

        camera.setFilters( Color::brighter, Color::darker );
        printCaptured.accept( "brighter & darker filter" );
    }

}