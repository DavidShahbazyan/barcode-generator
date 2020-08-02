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
    public EventBarcodeData buildData() {
        EventBarcodeData data = new EventBarcodeDataImpl();
        data.setTitle(this.title);
        data.setStartDate(this.startDate);
        data.setEndDate(this.endDate);
        data.setLocation(this.location);
        data.setDescription(this.description);
        data.setAllDayEvent(this.allDayEvent);
        return data;
    }

    @Override
    public void reset() {
        this.title = null;
        this.startDate = null;
        this.endDate = null;
        this.location = null;
        this.description = null;
        this.allDayEvent = false;
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
