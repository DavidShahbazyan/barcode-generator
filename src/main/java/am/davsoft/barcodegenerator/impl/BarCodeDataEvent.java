package am.davsoft.barcodegenerator.impl;

import am.davsoft.barcodegenerator.api.BarCodeData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Detailed: https://en.wikipedia.org/wiki/ICalendar

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class BarCodeDataEvent implements BarCodeData {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String description;
    private boolean allDayEvent;

    private BarCodeDataEvent() { }

    public static BarCodeDataEvent newInstance() {
        return new BarCodeDataEvent();
    }

    public BarCodeDataEvent withTitle(String title) {
        this.title = title;
        return this;
    }

    public BarCodeDataEvent withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public BarCodeDataEvent withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public BarCodeDataEvent withLocation(String location) {
        this.location = location;
        return this;
    }

    public BarCodeDataEvent withDescription(String description) {
        this.description = description;
        return this;
    }

    public BarCodeDataEvent withAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAllDayEvent() {
        return allDayEvent;
    }

    @Override
    public String getDataString() {
        StringBuilder builder = new StringBuilder("BEGIN:VEVENT").append(System.lineSeparator());
        builder.append("SUMMARY:").append(title).append(System.lineSeparator());
        if (allDayEvent) {
            builder.append("DTSTART;VALUE=DATE:").append(startDate.format(DateTimeFormatter.BASIC_ISO_DATE)).append(System.lineSeparator());
            builder.append("DTEND;VALUE=DATE:").append(endDate.format(DateTimeFormatter.BASIC_ISO_DATE)).append(System.lineSeparator());
        } else {
            builder.append("DTSTART:").append(startDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("-","").replaceAll(":","")).append(System.lineSeparator());
            builder.append("DTEND:").append(endDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replaceAll("-","").replaceAll(":","")).append(System.lineSeparator());
        }
        builder.append("LOCATION:").append(location).append(System.lineSeparator());
        builder.append("DESCRIPTION:").append(description).append(System.lineSeparator());
        builder.append("END:VEVENT").append(System.lineSeparator());
        return builder.toString();
    }
}
