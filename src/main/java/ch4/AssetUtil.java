package ch4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AssetUtil {
    public static int totalAssetValues( final List<Asset> assets ) {
        return totalAssetValues( assets, asset -> true );
    }

    public static int totalAssetValues( final List<Asset> assets, final Asset.AssetType type ) {
        return totalAssetValues( assets, asset -> asset.type == type );
    }

    public static int totalAssetValues( final List<Asset> assets, final Predicate<Asset> assetSelector ) {
        int totalAssetValues = assets.stream()
                .filter( assetSelector )
                .mapToInt( asset -> asset.value )
                .sum();
        return totalAssetValues;
    }
}