package am.davsoft.barcodegenerator.helper;

import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import org.reflections.Reflections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Shahbasyan
 * @since Aug 01, 2020
 */
public final class BarcodeDataBuilderFactory {
    private final static Map<Class<? extends SimpleDataBuilder>, Class<? extends SimpleDataBuilder>> builders = new ConcurrentHashMap<>();

    static {
        scanPackages("am.davsoft.barcodegenerator.builder");
    }

    private BarcodeDataBuilderFactory() {
    }

    public static void scanPackages(String... packagesToScan) {
        Reflections reflections = new Reflections(packagesToScan);
        for (Class<? extends SimpleDataBuilder> aClass : reflections.getSubTypesOf(SimpleDataBuilder.class)) {
            if (!aClass.isInterface()) {
                builders.putIfAbsent(aClass, aClass);
            }
        }
    }

    public static <T extends SimpleDataBuilder> T newBarcodeDataBuilder(Class<T> type) {
        try {
            Class<? extends SimpleDataBuilder> implClass = builders.get(type);
            if (implClass == null) {
                throw new IllegalArgumentException(String.format("The specified builder type \"%s\" was not found. Probably you forgot to call BarcodeDataBuilderFactory.scanPackages(\"%s\"); to scan your custom builders package before requesting them.", type.getSimpleName(), type.getPackage().getName()));
            }
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Exception occurred during a new instance creation.", ex);
        }
    }
}
