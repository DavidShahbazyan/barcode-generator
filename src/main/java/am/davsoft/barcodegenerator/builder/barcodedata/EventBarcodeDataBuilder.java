package am.davsoft.barcodegenerator.builder.barcodedata;

import am.davsoft.barcodegenerator.api.barcodedata.EventBarcodeData;
import am.davsoft.barcodegenerator.builder.SimpleDataBuilder;
import am.davsoft.barcodegenerator.impl.barcodedata.EventBarcodeDataImpl;

import java.time.LocalDateTime;

// Detailed: https://en.wikipedia.org/wiki/ICalendar

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class EventBarcodeDataBuilder implements SimpleDataBuilder<EventBarcodeData> {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String description;
    private boolean allDayEvent;

    @Override
    public EventBarcodeData build() {
        return new EventBarcodeDataImpl(this.title, this.startDate, this.endDate, this.location, this.description, this.allDayEvent);
    }

    public EventBarcodeDataBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventBarcodeDataBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventBarcodeDataBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public EventBarcodeDataBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public EventBarcodeDataBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBarcodeDataBuilder withAllDayEvent(boolean allDayEvent) {
        this.allDayEvent = allDayEvent;
        return this;
    }
}
