package ru.kpfu.shop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by etovladislav on 16.05.16.
 */
public class ImageFilenameValidator {

    private static final String IMAGE_PATTERN
            = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    private final Pattern pattern;
    private Matcher matcher;

    public ImageFilenameValidator() {
        pattern = Pattern.compile(IMAGE_PATTERN);
    }

    public boolean validate(String image) {
        matcher = pattern.matcher(image);
        return matcher.matches();
    }
}