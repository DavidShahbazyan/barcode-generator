package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.GoogleGeoLocationBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.GoogleGeoLocationBarcodeDataImpl;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class GoogleGeoLocationBarcodeDataBuilder implements SimpleDataBuilder<GoogleGeoLocationBarcodeData> {
    private String latitude = "0";
    private String longitude = "0";
    private String label;
    private String query;
    private Integer zoomLevel;

    @Override
    public GoogleGeoLocationBarcodeData build() {
        return new GoogleGeoLocationBarcodeDataImpl(this.latitude, this.longitude, this.label, this.query, this.zoomLevel);
    }

    public GoogleGeoLocationBarcodeDataBuilder withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public GoogleGeoLocationBarcodeDataBuilder withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public GoogleGeoLocationBarcodeDataBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public GoogleGeoLocationBarcodeDataBuilder withQuery(String query) {
        this.query = query;
        return this;
    }

    public GoogleGeoLocationBarcodeDataBuilder withZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
        return this;
    }
}
