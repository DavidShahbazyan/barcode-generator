package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.GeoLocationLayerType;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GeoLocationLayerTypeEnum implements GeoLocationLayerType {
    TRAFFIC("t"),
    STREET_VIEW("c");

    private static final Map<String, GeoLocationLayerTypeEnum> _valuesMap = Stream.of(values()).collect(Collectors.toMap(GeoLocationLayerTypeEnum::getValue, Function.identity()));

    private final String value;

    GeoLocationLayerTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static GeoLocationLayerTypeEnum instanceOf(String value) {
        return _valuesMap.get(value);
    }
}
