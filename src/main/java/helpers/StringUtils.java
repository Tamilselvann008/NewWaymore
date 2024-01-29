package helpers;

import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

    public static String replaceAllStringForValue(String value, String strToReplace, String symbol) {
        return value.replaceAll(strToReplace, symbol);
    }

    public static String getMatchStringByRegExp(String stringForMatch, String matcher) {
        return Stream.of(stringForMatch.split(matcher)).collect(Collectors.joining());
    }

    public static int getMatchStringIndexByRegExp(String stringForMatch, String matcher) {
        return stringForMatch.indexOf(matcher);
    }

    public static String getStringToUpperCase(String value) {
        return value.toUpperCase();
    }

    public static String getStringToLowerCase(String value) {
        return value.toLowerCase();
    }

    public static String getStringBySlice(String value, int from, int to) {
        return value.substring(from, to);
    }

    public static int getIndexOf(String value, String searchString, int position) {
        return value.indexOf(searchString, position);
    }

    public static String encodeStringToBase64(String stringToEncode) {
        return Base64.getEncoder().encodeToString(stringToEncode.getBytes());
    }


    public static String getRandomString(int length, String type) {
        return RandomStringUtils.random(length, type.equals("alphabetic"),true);
    }

    public static String getStringByToFixed(double value, int fractionDigits) {
        return String.format("%." + fractionDigits + "f", value);
    }

    public static String getLowercaseFirstLetter(String value) {
        return Character.toLowerCase(value.charAt(0)) + value.substring(1);
    }

    public static String getStringBySplit(String value, String separator, int index) {
        String[] parts = value.split(Pattern.quote(separator));
        return index < parts.length ? parts[index] : "";
    }

    public static String[] getStringListBySplit(String value, String separator) {
        return value.split(Pattern.quote(separator));
    }

    public static String getStringByTrim(String value) {
        return value.trim();
    }

  
    public static int getIntFromString(String stringForParseInt, int radix) {
        try {
            return Integer.parseInt(stringForParseInt, radix);
        } catch (NumberFormatException e) {
            return 0; // or handle the error as needed
        }
    }

    public static String getStringFromInt(int integerForParseString, int radix) {
        return Integer.toString(integerForParseString, radix);
    }

    public static float getFloatFromString(String stringForParseFloat) {
        try {
            return Float.parseFloat(stringForParseFloat);
        } catch (NumberFormatException e) {
            return 0.0f; // or handle the error as needed
        }
    }
    public static int getRoundedNumber(double value) {
        return (int) Math.round(value);
    }

    public static String getRandomStringWithLineBreak(int length, String type, int matchNumber, String lineBreak) {
        String characters = org.apache.commons.lang3.RandomStringUtils.random(length, type.equals("alphabetic"), true);
        return IntStream.range(0, characters.length())
                .mapToObj(i -> (i % matchNumber == 0) ? lineBreak + characters.charAt(i) : String.valueOf(characters.charAt(i)))
                .collect(Collectors.joining());
    }

    public static int getUTF16CodeOfCharacter(String character, int index) {
        return character.codePointAt(index);
    }

    public static String getStringByJoin( List<String> array) {
        return String.join(" ",array);
    }

}

