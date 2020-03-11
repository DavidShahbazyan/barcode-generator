package am.davsoft.barcodegenerator.helper;

import am.davsoft.barcodegenerator.api.barcodedata.BarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Shahbasyan
 * @since Aug 01, 2020
 */
public final class BarcodeDataBuilderFactory {
    private final Map<Class<? extends SimpleDataBuilder>, SimpleDataBuilder<? extends BarcodeData>> builders = new ConcurrentHashMap<>();

    public BarcodeDataBuilderFactory() throws Exception {
        Reflections reflections = new Reflections("am.davsoft.barcodegenerator.builder");
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
