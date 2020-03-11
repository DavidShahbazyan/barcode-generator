package am.davsoft.barcodegenerator.helper;

import am.davsoft.barcodegenerator.api.barcodedata.*;
import am.davsoft.barcodegenerator.builder.ContactNameBuilder;
import am.davsoft.barcodegenerator.builder.PhoneNumberBuilder;
import am.davsoft.barcodegenerator.builder.barcodedata.*;
import am.davsoft.barcodegenerator.impl.PhoneNumberTypeEnum;
import am.davsoft.barcodegenerator.impl.WiFiEncryptionTypeEnum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.testng.Assert.*;

/**
 * @author David Shahbasyan
 * @since Aug 02, 2020
 */
public class BarcodeDataBuilderFactoryTest {
    BarcodeDataBuilderFactory factory;

    @BeforeMethod
    public void setUp() throws Exception {
        factory = new BarcodeDataBuilderFactory();
    }

    @Test
    public void testEmailBarcodeDataBuilder() {
        EmailBarcodeData emailBarcodeData = factory.getBarcodeDataBuilder(EmailBarcodeDataBuilder.class)
                .withEmail("test@localnet.loc")
                .build();
        assertEquals(emailBarcodeData.getDataString(), "mailto:test@localnet.loc");
    }


    @Test
    public void testEventBarcodeDataBuilder_allDay() {
        EventBarcodeData eventBarcodeData = factory.getBarcodeDataBuilder(EventBarcodeDataBuilder.class)
                .withTitle("TestTitle")
                .withDescription("TestDescription")
                .withLocation("TestLocation")
                .withStartDate(LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0, 0))
                .withEndDate(LocalDateTime.of(2020, Month.JANUARY, 1, 23, 59, 59))
                .withAllDayEvent(true)
                .build();

        assertEquals(eventBarcodeData.getDataString(),
                "BEGIN:VEVENT" +
                        "\nSUMMARY:TestTitle" +
                        "\nDTSTART;VALUE=DATE:20200101" +
                        "\nDTEND;VALUE=DATE:20200101" +
                        "\nLOCATION:TestLocation" +
                        "\nDESCRIPTION:TestDescription" +
                        "\nEND:VEVENT");
    }

    @Test
    public void testEventBarcodeDataBuilder_partDay() {
        EventBarcodeData eventBarcodeData = factory.getBarcodeDataBuilder(EventBarcodeDataBuilder.class)
                .withTitle("TestTitle")
                .withDescription("TestDescription")
                .withLocation("TestLocation")
                .withStartDate(LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0, 0))
                .withEndDate(LocalDateTime.of(2020, Month.JANUARY, 1, 23, 59, 59))
                .withAllDayEvent(false)
                .build();

        assertEquals(eventBarcodeData.getDataString(),
                "BEGIN:VEVENT" +
                        "\nSUMMARY:TestTitle" +
                        "\nDTSTART:20200101T000000" +
                        "\nDTEND:20200101T235959" +
                        "\nLOCATION:TestLocation" +
                        "\nDESCRIPTION:TestDescription" +
                        "\nEND:VEVENT");
    }

    @Test
    public void testGoogleLocationBarcodeDataBuilder_LatLong() {
        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("25.0000188")
                .withLongitude("-71.0087548")
                .build();
        assertEquals(googleGeoLocationBarcodeData.getDataString(), "geo:25.0000188,-71.0087548");
    }

    @Test
    public void testGoogleLocationBarcodeDataBuilder_LatLongQuery() {
        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("25.0000188")
                .withLongitude("-71.0087548")
                .withQuery("Bermuda+Triangle")
                .build();
        assertEquals(googleGeoLocationBarcodeData.getDataString(), "geo:25.0000188,-71.0087548?q=Bermuda+Triangle");
    }

    @Test
    public void testGoogleLocationBarcodeDataBuilder_LatLongLabel() {
        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("25.0000188")
                .withLongitude("-71.0087548")
                .withLabel("Bermuda+Triangle")
                .build();
        assertEquals(googleGeoLocationBarcodeData.getDataString(), "geo:25.0000188,-71.0087548?q=25.0000188,-71.0087548(Bermuda+Triangle)");
    }

    @Test
    public void testGoogleLocationBarcodeDataBuilder_LatLongLabelZoom() {
        GoogleGeoLocationBarcodeData googleGeoLocationBarcodeData = factory.getBarcodeDataBuilder(GoogleGeoLocationBarcodeDataBuilder.class)
                .withLatitude("25.0000188")
                .withLongitude("-71.0087548")
                .withLabel("Bermuda+Triangle")
                .withZoomLevel(15)
                .build();
        assertEquals(googleGeoLocationBarcodeData.getDataString(), "geo:25.0000188,-71.0087548?q=25.0000188,-71.0087548(Bermuda+Triangle)&z=15");
    }

    @Test
    public void testGooglePlayLinkBarcodeDataBuilder() {
        GooglePlayLinkBarcodeData googlePlayLinkBarcodeData = factory.getBarcodeDataBuilder(GooglePlayLinkBarcodeDataBuilder.class)
                .withPackageName("am.davsoft.barcodegenerator")
                .build();
        assertEquals(googlePlayLinkBarcodeData.getDataString(), "market://details?id=am.davsoft.barcodegenerator");
    }

    @Test
    public void testGooglePlayLinkBarcodeDataBuilder_invalidPackageName() {
        GooglePlayLinkBarcodeData googlePlayLinkBarcodeData = factory.getBarcodeDataBuilder(GooglePlayLinkBarcodeDataBuilder.class)
                .withPackageName("InvalidPackageName")
                .build();
        assertEquals(googlePlayLinkBarcodeData.getDataString(), "market://details?id=");
    }

    @Test
    public void testMeCardBarcodeDataBuilder() {
        MeCardBarcodeData meCardBarcodeData = factory.getBarcodeDataBuilder(MeCardBarcodeDataBuilder.class)
                .withName("TestName")
                .withCompany("TestCompany")
                .withPhone("+555555555")
                .withWebsite("https://localnet.loc")
                .withEmail("test@localnet.loc")
                .withAddress("Bermuda+Triangle")
                .withNote("TestMeCard")
                .build();

        assertEquals(meCardBarcodeData.getDataString(),
                "MECARD:" +
                        "N:TestName;" +
                        "ORG:TestCompany;" +
                        "TEL:+555555555;" +
                        "URL:https://localnet.loc;" +
                        "EMAIL:test@localnet.loc;" +
                        "ADR:Bermuda+Triangle;" +
                        "NOTE:TestMeCard;;");
    }

    @Test
    public void testPhoneNumberBarcodeDataBuilder() {
        PhoneNumberBarcodeData phoneNumberBarcodeData = factory.getBarcodeDataBuilder(PhoneNumberBarcodeDataBuilder.class)
                .withPhone("+555555555")
                .build();
        assertEquals(phoneNumberBarcodeData.getDataString(), "tel:+555555555");
    }

    @Test
    public void testSMSBarcodeDataBuilder() {
        SMSBarcodeData sMSBarcodeData = factory.getBarcodeDataBuilder(SMSBarcodeDataBuilder.class)
                .withPhone("+555555555")
                .withMessage("TestMessage")
                .build();
        assertEquals(sMSBarcodeData.getDataString(), "smsto:+555555555:TestMessage");
    }

    @Test
    public void testTextBarcodeDataBuilder() {
        TextBarcodeData textBarcodeData = factory.getBarcodeDataBuilder(TextBarcodeDataBuilder.class)
                .withText("TestText")
                .build();
        assertEquals(textBarcodeData.getDataString(), "TestText");
    }

    @Test
    public void testURLBarcodeDataBuilder_withoutProtocol() {
        URLBarcodeData uRLBarcodeData = factory.getBarcodeDataBuilder(URLBarcodeDataBuilder.class)
                .withUrl("localnet.loc")
                .build();
        assertEquals(uRLBarcodeData.getDataString(), "http://localnet.loc");
    }

    @Test
    public void testURLBarcodeDataBuilder_withProtocol() {
        URLBarcodeData uRLBarcodeData = factory.getBarcodeDataBuilder(URLBarcodeDataBuilder.class)
                .withUrl("ftp://localnet.loc")
                .build();
        assertEquals(uRLBarcodeData.getDataString(), "ftp://localnet.loc");
    }

    @Test
    public void testVCardBarcodeDataBuilder() {
        ContactNameBuilder contactNameBuilder = factory.getBarcodeDataBuilder(ContactNameBuilder.class);
        PhoneNumberBuilder phoneNumberBuilder = factory.getBarcodeDataBuilder(PhoneNumberBuilder.class);

        VCardBarcodeData vCardBarcodeData = factory.getBarcodeDataBuilder(VCardBarcodeDataBuilder.class)
                .withContactName(contactNameBuilder.withFirstName("TestFirstName").withMiddleName("TestMiddleName").withLastName("TestLastName").build())
                .withCompany("TestCompany")
                .withTitle("TestTitle")
                .withPhoneNumber(phoneNumberBuilder.withType(PhoneNumberTypeEnum.CELL).withNumber("+555555555").build())
                .withWebsite("https://localnet.loc")
                .withEmail("test@localnet.loc")
                .withAddress("Bermuda+Triangle")
                .withNote("TestVCard")
                .build();
        assertEquals(vCardBarcodeData.getDataString(),
                "BEGIN:VCARD" +
                        "\nVERSION:3.0" +
                        "\nN:TestLastName;TestFirstName;TestMiddleName" +
                        "\nORG:TestCompany" +
                        "\nTITLE:TestTitle" +
                        "\nTEL;TYPE=CELL:+555555555" +
                        "\nURL:https://localnet.loc" +
                        "\nEMAIL:test@localnet.loc" +
                        "\nADR:Bermuda+Triangle" +
                        "\nNOTE:TestVCard" +
                        "\nEND:VCARD");
    }

    @Test
    public void testWiFiNetworkBarcodeDataBuilder() {
        WiFiNetworkBarcodeData wiFiNetworkBarcodeData = factory.getBarcodeDataBuilder(WiFiNetworkBarcodeDataBuilder.class)
                .withSsid("TestSSID")
                .withEncryptionType(WiFiEncryptionTypeEnum.WPA_WPA2)
                .withPass("TestPass")
                .withHidden(true)
                .build();

        assertEquals(wiFiNetworkBarcodeData.getDataString(), "WIFI:S:TestSSID;T:WPA;P:TestPass;H:true;;");
    }
}