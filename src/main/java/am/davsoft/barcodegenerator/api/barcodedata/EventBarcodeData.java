package am.davsoft.barcodegenerator.api.barcodedata;

import java.time.LocalDateTime;

// Detailed: https://en.wikipedia.org/wiki/ICalendar

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public interface EventBarcodeData extends BarcodeData {
    String getTitle();

    void setTitle(String title);

    LocalDateTime getStartDate();

    void setStartDate(LocalDateTime startDate);

    LocalDateTime getEndDate();

    void setEndDate(LocalDateTime endDate);

    String getLocation();

    void setLocation(String location);

    String getDescription();

    void setDescription(String description);

    boolean isAllDayEvent();

    void setAllDayEvent(boolean allDayEvent);
}
