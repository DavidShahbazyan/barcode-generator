package am.davsoft.barcodegenerator.helper;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PhoneNumberType {
    MAIN  ("MAIN"),

    /** Preferred if more than one phone is known */
    PREF  ("PREF"),

    /** At the place of residence */
    HOME  ("HOME"),

    /** Supports messaging */
    MSG   ("MSG"),

    /** At work */
    WORK  ("WORK"),

    /** For voice communication */
    VOICE ("VOICE"),

    /** For faxing */
    FAX   ("FAX"),

    /** Cell phone */
    CELL  ("CELL"),

    /** Supports video conferencing */
    VIDEO ("VIDEO"),

    /** Send messages to the pager */
    PAGER ("PAGER"),

    /** Maintains an electronic bulletin board */
    BBS   ("BBS"),

    /** This number serves modem */
    MODEM ("MODEM"),

    /** In the car */
    CAR   ("CAR"),

    /** Provides ISDN services */
    ISDN  ("ISDN"),

    /** Personal Communication Services */
    PCS   ("PCS"),
    ;

    private static final Map<String, PhoneNumberType> valueOfMap = Stream.of(values()).collect(Collectors.toMap(PhoneNumberType::getType, Function.identity()));

    private final String type;

    PhoneNumberType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static PhoneNumberType byType(String type) {
        return valueOfMap.get(type);
    }
}
