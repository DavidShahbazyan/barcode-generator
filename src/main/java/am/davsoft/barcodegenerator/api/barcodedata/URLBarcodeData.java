package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface URLBarcodeData extends BarcodeData {
    String getUrl();

    void setUrl(String url);
}
