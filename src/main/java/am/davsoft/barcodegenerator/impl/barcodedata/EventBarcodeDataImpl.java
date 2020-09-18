package am.davsoft.barcodegenerator.impl.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.BarcodeData;
import am.davsoft.barcodegenerator.api.barcodedata.EventBarcodeData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Detailed: https://en.wikipedia.org/wiki/ICalendar

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class EventBarcodeDataImpl implements EventBarcodeData {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String description;
    private boolean allDayEvent;

    public EventBarcodeDataImpl() {
    }

    public EventBarcodeDataImpl(String title, LocalDateTime startDate, LocalDateTime endDate, String location, String description, boolean allDayEvent) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.allDayEvent = allDayEvent;
    }

    @Override
    public String getDataString() {
        StringBuilder builder = new StringBuilder("BEGIN:VEVENT");
        builder.append('\n').append("SUMMARY:").append(title);
        if (allDayEvent) {
            builder.append('\n').append("DTSTART;VALUE=DATE:").append(startDate.format(DateTimeFormatter.BASIC_ISO_DATE));
            builder.append('\n').append("DTEND;VALUE=DATE:").append(endDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        } else {
            builder.append('\n').append("DTSTART:").append(startDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("-","").replaceAll(":",""));
            builder.append('\n').append("DTEND:").append(endDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("-","").replaceAll(":",""));
        }
        builder.append('\n').append("LOCATION:").append(location);
        builder.append('\n').append("DESCRIPTION:").append(description);
        builder.append('\n').append("END:VEVENT");
        return builder.toString();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isAllDayEvent() {
        return allDayEvent;
    }

    @Override
    public void setAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
    }
}
