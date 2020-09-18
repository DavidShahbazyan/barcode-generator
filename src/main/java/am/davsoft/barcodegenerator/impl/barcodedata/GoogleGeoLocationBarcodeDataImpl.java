package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.GoogleGeoLocationBarcodeData;

import java.util.Objects;

/**
 * <b>Documentation:</b> - https://developers.google.com/maps/documentation/urls/android-intents
 * <br><br>
 * <pre>
 * <b>Patterns:</b>
 *            - geo:latitude,longitude?q=query
 *            - geo:0,0?q=my+street+address
 *            - geo:0,0?q=latitude,longitude(label)
 *            - geo:37.7749,-122.4194?z=10&q=restaurants
 *
 * <b>location</b>   - Syntax: geo-location = latitude "," longitude [ "," altitude ]
 *              where
 *              <b>latitude</b>  - (deg N in range[-90, 90])
 *              <b>longitude</b> - (deg W in range[-180, 180])
 *              and
 *              <b>altitude</b>  - (optional, elevation above mean sea level in meters, can be negative)
 *
 * <b>query</b>      - Syntax: query = search_words concatenated with "+" (see section 3.4 of <a href="http://tools.ietf.org/html/rfc3986">RFC 3986</a>)
 *
 * <b>zoom-level</b> - Zoom level = [1..20]
 *              1 shows the whole Earth, centered at the given geo-location
 *              2 shows a quarter of the Earth, and so on
 *              Values above 20 will be clamped
 *
 * <b>label</b>      - Lets you set a custom label at a place identified on the map
 * </pre>
 *
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class GoogleGeoLocationBarcodeDataImpl implements GoogleGeoLocationBarcodeData {
    private String latitude;
    private String longitude;
    private String label;
    private String query;
    private Integer zoomLevel;

    public GoogleGeoLocationBarcodeDataImpl() {
    }

    public GoogleGeoLocationBarcodeDataImpl(String latitude, String longitude, String label, String query, Integer zoomLevel) {
        this.latitude = Objects.requireNonNull(latitude, "Latitude cannot be empty");
        this.longitude = Objects.requireNonNull(longitude, "Longitude cannot be empty");
        this.label = label;
        this.query = query;
        this.zoomLevel = zoomLevel;
    }

    @Override
    public String getDataString() {
        boolean isOptionalParamExists = false;

        StringBuilder dataString = new StringBuilder("geo:" + String.join(",", latitude, longitude));
        if (label != null && !label.isEmpty()) {
            dataString.append("?q=").append(String.join(",", latitude, longitude)).append("(").append(label).append(")");
            isOptionalParamExists = true;
        } else {
            if (query != null && !query.isEmpty()) {
                dataString.append(isOptionalParamExists ? "&" : "?").append("q=").append(query);
                isOptionalParamExists = true;
            }
        }
        if (zoomLevel != null) {
            dataString.append(isOptionalParamExists ? "&" : "?").append("z=").append(zoomLevel);
            isOptionalParamExists = true;
        }

        return dataString.toString();
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public Integer getZoomLevel() {
        return zoomLevel;
    }

    @Override
    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
}
