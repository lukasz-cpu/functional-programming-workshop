package ch1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Discounter {

    public static void main(String[] args) {
        /*
         * What was that about API and Copyright? Arrays.asList is a Guava
         * thing!
         */
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"),
                new BigDecimal("30"),
                new BigDecimal("17"),
                new BigDecimal("20"),
                new BigDecimal("15"),
                new BigDecimal("18"),
                new BigDecimal("45"),
                new BigDecimal("12"));

        System.out.println(new BigDecimal(1).compareTo(new BigDecimal(20)));

        Discounter discounter = new Discounter();
        System.out.println("imperativeDiscounter() => " + discounter.imperativeDiscounter(prices));
        System.out.println("functionalDiscounter() => " + discounter.functionalDiscounter(prices));
    }

    public BigDecimal imperativeDiscounter(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        return totalOfDiscountedPrices;
    }

    public BigDecimal functionalDiscounter(List<BigDecimal> prices) {
        return prices
                .stream()
                .filter(x -> x.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(x -> x.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
