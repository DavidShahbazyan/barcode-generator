package am.davsoft.barcodegenerator.builder;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface SimpleDataBuilder<T> {
    default T build() {
        T data = buildData();
        reset();
        return data;
    }

    T buildData();

    void reset();
}
