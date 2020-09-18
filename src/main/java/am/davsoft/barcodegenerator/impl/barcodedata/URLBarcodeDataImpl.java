package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.URLBarcodeData;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class URLBarcodeDataImpl implements URLBarcodeData {
    private String url;

    public URLBarcodeDataImpl() {
    }

    public URLBarcodeDataImpl(String url) {
        this.url = url;
    }

    @Override
    public String getDataString() {
        if (url != null && !url.isEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")
                    && !url.startsWith("ftp://") && !url.startsWith("ftps://")) {
                return "http://" + url;
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
