package am.davsoft.barcodegenerator;

import am.davsoft.barcodegenerator.api.BarCodeData;
import am.davsoft.barcodegenerator.impl.BarCodeDataText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David.Shahbazyan
 * @since Feb 02, 2018
 */
public class QRGeneratorTest extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Map<BarcodeFormat, String> data_kb = new HashMap<>();

        data_kb.put(BarcodeFormat.AZTEC,"Some text goes here...");
        data_kb.put(BarcodeFormat.CODABAR,"0123456789");
        data_kb.put(BarcodeFormat.CODE_39,"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        data_kb.put(BarcodeFormat.CODE_93,"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*0123456789ABCDEFGHIJKLMNOPQRSTUV");
        data_kb.put(BarcodeFormat.CODE_128,"Some text goes here...");
        data_kb.put(BarcodeFormat.DATA_MATRIX,"Some text goes here...");
        data_kb.put(BarcodeFormat.EAN_8,"01234567");
        data_kb.put(BarcodeFormat.EAN_13,"0123456789012");
        data_kb.put(BarcodeFormat.ITF,"0123456789");
//        data_kb.put(BarcodeFormat.MAXICODE,"Some text goes here...");
        data_kb.put(BarcodeFormat.PDF_417,"Some text goes here...");
        data_kb.put(BarcodeFormat.QR_CODE,"Some text goes here...");
//        data_kb.put(BarcodeFormat.RSS_14,"Some text goes here...");
//        data_kb.put(BarcodeFormat.RSS_EXPANDED,"Some text goes here...");
        data_kb.put(BarcodeFormat.UPC_A,"012345678905");
        data_kb.put(BarcodeFormat.UPC_E,"01234567");
//        data_kb.put(BarcodeFormat.UPC_EAN_EXTENSION,"Some text goes here...");


        String text = "0123aY$nT9";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 200; i++) {
            sb.append(text);
        }

//        QRGenerator qrGenerator = new QRGenerator();
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        BarCodeGenerator qrGenerator = new BarCodeGenerator(barcodeFormat);
        qrGenerator.setErrorCorrectionLevel(ErrorCorrectionLevel.L);
        qrGenerator.setSize(500, 500);
        qrGenerator.setMargin(0);

        BarCodeData data;
        data = new BarCodeDataText().setText(data_kb.get(barcodeFormat));
//        data = new QRDataText().setText(sb.toString());
//        data = new QRDataWiFiNetwork().setSsid("My-WiFi").setType(WiFiEncryptionType.WPA_WPA2).setPass("123456");
//        data = new QRDataSMS().setPhone("+37455600337").setMessage("I've decoded your message!");
//        data = new QRDataVCard()
//                .setContactName(new ContactName()
//                        .setFirstName("Erik")
//                        .setMiddleName("Armeni")
//                        .setLastName("Abrahamyan")
//                )
//                .setCompany("AWCA [Armenian Wing Chun Association]")
//                .setTitle("Co-Founder, Vice-President, Chief-Instructor")
//                .addPhoneNumber(new PhoneNumber()
//                        .setType(PhoneNumberType.CELL)
//                        .setNumber("+37498258085"))
//                .addPhoneNumber(new PhoneNumber()
//                        .setType(PhoneNumberType.HOME)
//                        .setNumber("+37491454873"))
//                .setWebsite("https://web.facebook.com/awca.am")
//                .setEmail("awca.am@gmail.com");

        BufferedImage image = qrGenerator.generateImage(data);

        primaryStage.setScene(new Scene(new VBox(new ImageView(SwingFXUtils.toFXImage(image, null)))));
//        ImageIO.write(image, "gif", new File("output.gif"));
        primaryStage.show();
    }
}