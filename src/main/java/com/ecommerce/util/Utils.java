package com.ecommerce.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import static io.vavr.API.Option;
import org.apache.commons.lang3.StringUtils;


import java.util.Date;


public final class Utils {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);


    public static String convertToString(Date date) {
        return Option(date).map(d -> new DateTime(d)).map(dateTime -> dateTime.toString(formatter)).getOrElse(StringUtils.EMPTY);
    }

    public static Date stringToDateOrNull(String date ) {
        return Option(date).map(d -> {
            try {
                return formatter.parseDateTime(date).toDate();
            } catch (Exception e) {
                return null;
            }
        }).getOrNull();
    }
}