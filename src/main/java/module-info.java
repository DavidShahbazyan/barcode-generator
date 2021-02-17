/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Jan 03, 2021
 * Time: 9:39 PM
 */
module barcodegenerator {
    requires com.google.zxing;
    requires org.jfree.jfreesvg;
    requires java.desktop;
    requires org.reflections;

    exports am.davsoft.barcodegenerator;
    exports am.davsoft.barcodegenerator.api;
    exports am.davsoft.barcodegenerator.api.barcodedata;
    exports am.davsoft.barcodegenerator.builder;
    exports am.davsoft.barcodegenerator.builder.barcodedata;
    exports am.davsoft.barcodegenerator.impl;
    exports am.davsoft.barcodegenerator.impl.barcodedata;
    exports am.davsoft.barcodegenerator.helper;
}