package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.GeoLocationMapType;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GeoLocationMapTypeEnum implements GeoLocationMapType {
    MAP_TYPE_MAP("m"),
    MAP_TYPE_SATELLITE("k"),
    MAP_TYPE_HYBRID("h"),
    MAP_TYPE_TERRAIN("p"),
    MAP_TYPE_GOOGL_EARTH("e"),
    MAP_TYPE_8_BIT("8");

    private static final Map<String, GeoLocationMapTypeEnum> _valuesMap = Stream.of(values()).collect(Collectors.toMap(GeoLocationMapTypeEnum::getValue, Function.identity()));

    private final String value;

    GeoLocationMapTypeEnum(String value) {
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

    public static GeoLocationMapTypeEnum instanceOf(String value) {
        return _valuesMap.get(value);
    }
}
