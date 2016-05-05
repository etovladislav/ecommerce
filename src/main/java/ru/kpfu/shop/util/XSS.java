package ru.kpfu.shop.util;

/**
 * Created by etovladislav on 05.05.16.
 */
public class XSS {


    public static String cleanXsS(String value) {
        // You'll need to remove the spaces from the html entities below
        //value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        //value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        //value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

        value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
        value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
        value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
        value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
        //value = value.replaceAll("<script>", "");
        //value = value.replaceAll("</script>", "");

        return value;
    }
}
