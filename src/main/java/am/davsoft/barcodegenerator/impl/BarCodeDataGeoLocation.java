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

    private BarCodeDataGeoLocation() { }

    public static BarCodeDataGeoLocation newInstance() {
        return new BarCodeDataGeoLocation();
    }

    public BarCodeDataGeoLocation withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public BarCodeDataGeoLocation withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public BarCodeDataGeoLocation withQuery(String query) {
        this.query = query;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String getDataString() {
        if (query != null && !query.isEmpty()) {
            return String.format("geo:%s,%s?q=%s", latitude, longitude, query);
        } else {
            return String.format("geo:%s,%s", latitude, longitude);
        }
    }
}
