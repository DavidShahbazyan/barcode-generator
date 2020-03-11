package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.URLBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class URLBarcodeDataImpl implements URLBarcodeData {
    private String url;

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

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }
}
