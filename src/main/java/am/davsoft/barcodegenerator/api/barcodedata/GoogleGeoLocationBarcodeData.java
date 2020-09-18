package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface GoogleGeoLocationBarcodeData extends BarcodeData {
    String getLatitude();

    void setLatitude(String latitude);

    String getLongitude();

    void setLongitude(String longitude);

    String getLabel();

    void setLabel(String label);

    String getQuery();

    void setQuery(String query);

    Integer getZoomLevel();

    void setZoomLevel(Integer zoomLevel);
}
