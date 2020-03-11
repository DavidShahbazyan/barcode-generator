package am.davsoft.barcodegenerator;

import am.davsoft.barcodegenerator.api.barcodedata.GoogleGeoLocationBarcodeData;
import am.davsoft.barcodegenerator.api.barcodedata.TextBarcodeData;
import am.davsoft.barcodegenerator.builder.barcodedata.GoogleGeoLocationBarcodeDataBuilder;
import am.davsoft.barcodegenerator.builder.barcodedata.TextBarcodeDataBuilder;
import am.davsoft.barcodegenerator.helper.BarcodeDataBuilderFactory;
import com.google.zxing.BarcodeFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        BarcodeDataBuilderFactory factory = new BarcodeDataBuilderFactory();
        BarcodeGenerator generator = new BarcodeGenerator(BarcodeFormat.QR_CODE);

        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData_LongLat = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("40.177603")
                .withLongitude("44.512608")
                .build();

        System.out.println(googleGeoLocationBarcodeData_LongLat.getDataString());
        System.out.println(generator.generateImageAsBase64(googleGeoLocationBarcodeData_LongLat));
        System.out.println();


        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData_LongLatLabel = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("40.177603")
                .withLongitude("44.512608")
                .withLabel("Blah_blah_blah")
                .build();

        System.out.println(googleGeoLocationBarcodeData_LongLatLabel.getDataString());
        System.out.println(generator.generateImageAsBase64(googleGeoLocationBarcodeData_LongLatLabel));
        System.out.println();


        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData_LongLatLabelZoom = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("40.177603")
                .withLongitude("44.512608")
                .withLabel("Blah_blah_blah")
                .withZoomLevel(12)
                .build();

        System.out.println(googleGeoLocationBarcodeData_LongLatLabelZoom.getDataString());
        System.out.println(generator.generateImageAsBase64(googleGeoLocationBarcodeData_LongLatLabelZoom));
        System.out.println();


        TextBarcodeData textBarcodeData = factory.getBarcodeDataBuilder(TextBarcodeDataBuilder.class)
                .withText("geo:40.177603,44.512608?q=(Blah_blah_blah)&z=12")
                .build();

        System.out.println(textBarcodeData.getDataString());
        System.out.println(generator.generateImageAsBase64(textBarcodeData));
        System.out.println();

    }
}
