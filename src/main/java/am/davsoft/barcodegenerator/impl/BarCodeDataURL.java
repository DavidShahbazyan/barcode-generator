package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataURL implements BarCodeData {
    private String url;

    private BarCodeDataURL() { }

    public static BarCodeDataURL newInstance() {
        return new BarCodeDataURL();
    }

    public BarCodeDataURL withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getDataString() {
        if (url != null && !url.isEmpty()) {
            if (!(url.startsWith("http://") || url.startsWith("https://")
                    || url.startsWith("ftp://") || url.startsWith("ftps://"))) {
                url = "http://" + url;
            }
        }
        return url;
    }
}
