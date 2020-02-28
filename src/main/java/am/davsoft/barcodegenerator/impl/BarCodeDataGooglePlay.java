package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Shahbazyan
 * @since Aug 30, 2018
 */
public class BarCodeDataGooglePlay implements BarCodeData {
    private static final Pattern GOOGLE_PLAY_ID_PATTERN = Pattern.compile(".+\\bdetails\\?id=([^&]+)");
    private String packageName;

    private BarCodeDataGooglePlay() { }

    public static BarCodeDataGooglePlay newInstance() {
        return new BarCodeDataGooglePlay();
    }

    public BarCodeDataGooglePlay withPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public String getPackageName() {
        return packageName;
    }

    @Override
    public String getDataString() {
        Matcher matcher = GOOGLE_PLAY_ID_PATTERN.matcher(packageName);
        if (matcher.find()) {
            return "market://details?id=" + packageName;
        }
        return "market://details?id=";
    }
}
