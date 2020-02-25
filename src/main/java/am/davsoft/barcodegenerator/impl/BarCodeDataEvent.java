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

    public BarCodeDataEvent setTitle(String title) {
        this.title = title;
        return this;
    }

    public BarCodeDataEvent setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public BarCodeDataEvent setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public BarCodeDataEvent setLocation(String location) {
        this.location = location;
        return this;
    }

    public BarCodeDataEvent setDescription(String description) {
        this.description = description;
        return this;
    }

    public BarCodeDataEvent setAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
        return this;
    }

    @Override
    public String getData() {
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
