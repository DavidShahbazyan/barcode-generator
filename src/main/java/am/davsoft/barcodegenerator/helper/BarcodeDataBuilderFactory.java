package am.davsoft.barcodegenerator.helper;

import am.davsoft.barcodegenerator.api.barcodedata.BarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author David Shahbasyan
 * @since Aug 01, 2020
 */
public final class BarcodeDataBuilderFactory {
    private final Map<Class<? extends SimpleDataBuilder>, SimpleDataBuilder<? extends BarcodeData>> builders = new ConcurrentHashMap<>();

    public BarcodeDataBuilderFactory(String... packagesToScan) throws Exception {
//        List<String> packages = new ArrayList<>();
//        packages.add("am.davsoft.barcodegenerator.builder");
//        if (packagesToScan.length>0) {
//            packages.addAll(Arrays.stream(packagesToScan).collect(Collectors.toList()));
//        }
        Reflections reflections = new Reflections(List.of("am.davsoft.barcodegenerator.builder",
                Arrays.stream(packagesToScan).collect(Collectors.toList())).toArray());
        for (Class<? extends SimpleDataBuilder> aClass : reflections.getSubTypesOf(SimpleDataBuilder.class)) {
            if (!aClass.isInterface()) {
                builders.putIfAbsent(aClass, aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public <T extends SimpleDataBuilder> T getBarcodeDataBuilder(Class<T> type) {
        return (T) builders.get(type);
    }
}
