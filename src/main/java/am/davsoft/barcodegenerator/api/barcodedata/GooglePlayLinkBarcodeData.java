package am.davsoft.barcodegenerator.api.barcodedata;

import java.util.regex.Pattern;

/**
 * @author David Shahbazyan
 * @since Aug 30, 2018
 */
public interface GooglePlayLinkBarcodeData extends BarcodeData {
    Pattern GOOGLE_PLAY_ID_PATTERN = Pattern.compile("^(?:[a-zA-Z]+(?:\\d*[a-zA-Z_]*)*)(?:\\.[a-zA-Z]+(?:\\d*[a-zA-Z_]*)*)+$");

    String getPackageName();

    void setPackageName(String packageName);
}
