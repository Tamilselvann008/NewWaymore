package helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    public static String getCurrentDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().format(formatter);
    }

    public static long getDateTime(String date) {
        return LocalDateTime.parse(date).atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static String getModifiedLaterDateByDaysCount(int daysCount, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().plusDays(daysCount).format(formatter);
    }

    public static String getModifiedEarlyDateByDaysCount(int daysCount, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().minusDays(daysCount).format(formatter);
    }

    public static String getReformattedDate(String date, String separator) {
        Pattern pattern = Pattern.compile("(\\d{1,2})" + Pattern.quote(separator) + "(\\d{1,2})" + Pattern.quote(separator) + "(\\d{4})");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            return matcher.group(2) + separator + matcher.group(1) + separator + matcher.group(3);
        }
        return date;
    }

    public static long getStartDateTimestamp(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return LocalDateTime.of(parsedDate, LocalTime.MIN).atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long getEndDateTimestamp(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return LocalDateTime.of(parsedDate, LocalTime.MAX).atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static String getModifiedDateByYearMonthDay(String format, int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.of(year, month, day).format(formatter);
    }

    public static String getModifiedDateByDate(String date, String format) {
        LocalDate parsedDate = LocalDate.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return parsedDate.format(formatter);
    }

    public static String convertSecondsToHMS(int value) {
        LocalTime time = LocalTime.ofSecondOfDay(value);
        return time.format(DateTimeFormatter.ofPattern("H:mm:ss"));
    }

    public static int getMinutesRoundedUpToInteger(int integer) {
        int minutes = LocalDateTime.now().getMinute();
        return (int) Math.ceil((double) minutes / integer) * integer;
    }

    public static LocalDate getDateByValue(Object value) {
        if (value instanceof LocalDate) {
            return (LocalDate) value;
        } else if (value instanceof String) {
            return LocalDate.parse((String) value);
        }
        throw new IllegalArgumentException("Unsupported value type for date conversion");
    }

    public static String convertTimeToNewFormat(String time, String format) {
        LocalTime parsedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return parsedTime.format(formatter);
    }
}

