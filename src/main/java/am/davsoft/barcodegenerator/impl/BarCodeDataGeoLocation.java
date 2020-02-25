package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataGeoLocation implements BarCodeData {
    private String latitude;
    private String longitude;
    private String query;

    public BarCodeDataGeoLocation setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public BarCodeDataGeoLocation setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public BarCodeDataGeoLocation setQuery(String query) {
        this.query = query;
        return this;
    }

    @Override
    public String getData() {
        if (query != null && !query.isEmpty()) {
            return String.format("geo:%s,%s?q=%s", latitude, longitude, query);
        } else {
            return String.format("geo:%s,%s", latitude, longitude);
        }
    }
}
