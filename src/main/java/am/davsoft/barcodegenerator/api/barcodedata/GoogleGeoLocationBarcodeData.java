package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface GoogleGeoLocationBarcodeData extends BarcodeData {
    String getLatitude();

    String getLongitude();

    String getLabel();

    String getQuery();

    Integer getZoomLevel();
}
