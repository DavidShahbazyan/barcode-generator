package am.davsoft.barcodegenerator.api.barcodedata;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface TextBarcodeData extends BarcodeData {
    String getText();

    void setText(String text);
}
