/**
 * @author David Shahbazyan
 * @since Aug 22, 2020
 */
module am.davsoft.barcodegenerator {
    requires com.google.zxing;
    requires transitive org.jfree.jfreesvg;
    requires transitive java.desktop;
    requires static org.reflections.common;

    exports am.davsoft.barcodegenerator;
    exports am.davsoft.barcodegenerator.api;
    exports am.davsoft.barcodegenerator.api.barcodedata;
    exports am.davsoft.barcodegenerator.builder;
    exports am.davsoft.barcodegenerator.builder.barcodedata;
    exports am.davsoft.barcodegenerator.impl;
    exports am.davsoft.barcodegenerator.impl.barcodedata;
    exports am.davsoft.barcodegenerator.helper;

//    opens am.davsoft.barcodegenerator;
}