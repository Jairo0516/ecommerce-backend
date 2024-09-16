package com.ecommerce.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import static io.vavr.API.Option;
import org.apache.commons.lang3.StringUtils;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.regex.Pattern;


public final class Utils {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
    private static final Pattern BASE64_PATTERN = Pattern.compile("^[a-zA-Z0-9+/=]+$");


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


    public static boolean isBase64(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Verifica si la cadena coincide con el patrón Base64
        if (!BASE64_PATTERN.matcher(str).matches()) {
            return false;
        }

        try {
            // Intenta decodificar la cadena en Base64
            Base64.getDecoder().decode(str);
            return true;
        } catch (IllegalArgumentException e) {
            // La decodificación falló, lo que significa que no es Base64 válido
            return false;
        }
    }


}