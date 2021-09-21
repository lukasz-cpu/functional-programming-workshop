package ch4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AssetUtil {


    public static void main(String[] args) {
        final List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );


    }


    public static Map<String, Integer> assetsByType(List<Asset> assets) {
        return assets.stream().collect(
                Collectors.groupingBy(
                        asset -> asset.getType().name(),
                        Collectors.summingInt(Asset::getValue)));

    }

    public static int totalAssetValues(List<Asset> assets) {
        return assets.stream().mapToInt(Asset::getValue).sum();
    }
}
