package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        String[] parts = value.split(separator);
        // Check if the index is within the bounds of the array
        if (index >= 0 && index < parts.length) {
            return parts[index];
        } else {
            // Return an empty string or throw an exception if the index is out of bounds
            return "";
        }
    }

    // Overloaded method for when the separator is provided but index is not
    public static String getStringBySplit(String value, String separator) {
        return getStringBySplit(value, separator, 0); // Default index to 0
    }

    /**
     * Splits a string by a specified separator.
     *
     * @param value The string to be split.
     * @param separator The separator to use for splitting the string.
     * @return An array of strings resulting from the split.
     */
    public static List<String> getStringListBySplit(String value, String separator) {
        // Using Arrays.asList() for a direct but less flexible conversion
        // return Arrays.asList(value.split(separator));

        // Using Stream API for more flexibility, especially if modifications are needed
        return Arrays.stream(value.split(separator)).collect(Collectors.toList());
    }

    public static String getStringByTrim(String value) {
        return value.trim();
    }

  
    public static int getIntFromString(String stringForParseInt, int radix) {
        return Integer.parseInt(stringForParseInt, radix);
    }

    // Overloaded method with default radix of 10
    public static int getIntFromString(String stringForParseInt) {
        return Integer.parseInt(stringForParseInt);
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

    public static String getStringByJoin(String[] values, String separator) {
        return String.join(separator, values);
    }
    
    public static String getStringFromStream(InputStream inputStream, Charset encoding) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encoding))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    // Overloaded method with default encoding (UTF-8)
    public static String getStringFromStream(InputStream inputStream) throws IOException {
        return getStringFromStream(inputStream, StandardCharsets.UTF_8);
    }
    
    public static String parseObjectToJSON(Object value, Integer space) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (space != null) {
                // Use the writerWithDefaultPrettyPrinter for pretty printing
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
            } else {
                return objectMapper.writeValueAsString(value);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // or a specific error message
        }
    }

    // Overloaded method without space parameter for direct JSON conversion
    public static String parseObjectToJSON(Object value) {
        return parseObjectToJSON(value, null);
    }
    
    
    public static Object parseJSONToObject(String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert JSON string to Object
            return objectMapper.readValue(value, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // or handle the error as appropriate
        }
    }
    
    public static <T> List<T> parseJSONToList(String value) {
    	 ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(value, new TypeReference<List<T>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
//    public static void main(String[] args) {
//    	int roundedNumber = getRoundedNumber(01);
//    	System.out.println(roundedNumber);
//	}

}

