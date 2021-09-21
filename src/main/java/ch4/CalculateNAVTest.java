package ch4;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateNAVTest {


    @Test
    public void computeStockWorth() {
        // Note how easy it is, with lambdas, to "stub" out the priceFinder
        final CalculateNAV calculateNAV = new CalculateNAV( ticker -> new BigDecimal( "6.01" ) );
        BigDecimal expected = new BigDecimal( "6010.00" );
        // I was unaware of the delta thing.
        assertEquals( 0, calculateNAV.computeStockWorth( "GOOG", 1000 )
                .compareTo( expected ), 0.001 );
    }

}
