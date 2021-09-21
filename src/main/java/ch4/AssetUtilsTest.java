package ch4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ch4.Asset.AssetType.BOND;
import static ch4.Asset.AssetType.STOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AssetUtilsTest {

    @Test
    public void totalAssetValues() {
        final List<Asset> assets = Arrays.asList(
                new Asset( BOND, 10 ),
                new Asset( BOND, 20 ),
                new Asset( STOCK, 30 ),
                new Asset( STOCK, 40 ) );
        int sum = AssetUtil.totalAssetValues( assets );
        assertEquals( 100, sum );

        int sumBonds = AssetUtil.totalAssetValues( assets, BOND );
        assertEquals( 30, sumBonds );

        int sumStocks = AssetUtil.totalAssetValues( assets, STOCK );
        assertEquals( 70, sumStocks );
    }

    @Test
    public void lambdasBaby() {
        final List<Asset> assets = new ArrayList<Asset>();
        for ( int i = 0; i < 10; i++ ) {
            Asset asset = new Asset( ( i % 2 == 0 ) ? STOCK : BOND, i + 1 );
            assets.add( asset );
        }
        int sumOfStockAssetsLessThanFive = AssetUtil.totalAssetValues( assets, asset -> asset.type == STOCK && asset.value < 5 );
        assertEquals( 4, sumOfStockAssetsLessThanFive );

        int sumOfEvenAssets = AssetUtil.totalAssetValues( assets, asset -> asset.value % 2 == 0 );
        assertEquals( 30, sumOfEvenAssets );
    }
}