package model.converter;

import org.primefaces.component.calendar.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Objects;

/**
 * Class for PrimeFaces component @{@link Calendar}
 * Convert @{@link LocalDateTime} to @{@link String} representation and vice versa
 * @throw @{@link NullPointerException} if value is null
 */
@FacesConverter(value = "dateConverter")
public class LocalDateTimeConverter extends DateTimeConverter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Objects.requireNonNull(value);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendPattern("dd/MM/uuuu")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate ld = LocalDate.parse(value, formatter);

        return ld.atStartOfDay();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Objects.requireNonNull(value);

        LocalDateTime dateValue = (LocalDateTime) value;
        return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
