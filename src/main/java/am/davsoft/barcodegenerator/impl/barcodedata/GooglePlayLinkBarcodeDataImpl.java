package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.GooglePlayLinkBarcodeData;

import java.util.regex.Matcher;

/**
 * @author David Shahbazyan
 * @since Aug 30, 2018
 */
public class GooglePlayLinkBarcodeDataImpl implements GooglePlayLinkBarcodeData {
    private String packageName;

    @Override
    public String getDataString() {
        Matcher matcher = GOOGLE_PLAY_ID_PATTERN.matcher(packageName);
        if (matcher.find()) {
            return "market://details?id=" + packageName;
        }
        return "market://details?id=";
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
