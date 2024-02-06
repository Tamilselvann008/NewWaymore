package helpers;

import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

public class Assertions {

    public static void expectToEqual(Object result, Object expectedResult, String errorMessage) {
        Assert.assertEquals(result, expectedResult, errorMessage);
    }

    public static void expectToNotEqual(Object result, Object expectedResult, String errorMessage) {
        Assert.assertNotEquals(result, expectedResult, errorMessage);
    }

    public static void expectToDisplay(WebElement elm, String errorMessage) throws Exception {
        Assert.assertTrue(elm.isDisplayed(), errorMessage);
    }

    public static void expectToNotDisplay(WebElement elm, String errorMessage) throws Exception {
        Assert.assertFalse(elm.isDisplayed(), errorMessage);
    }

    public static void expectToNotExist(WebElement elm, String errorMessage) throws Exception {
        Assert.assertFalse(elm.isDisplayed(), errorMessage);
    }

    public static void expectToBeEnabled(WebElement elm, String errorMessage) throws Exception {
        Assert.assertTrue(elm.isEnabled(), errorMessage);
    }

    public static void expectToBeDisabled(WebElement elm, String errorMessage) throws Exception {
        Assert.assertFalse(elm.isEnabled(), errorMessage);
    }

    public static void expectToInclude(String result, String expectedResult, String errorMessage) {
        Assert.assertTrue(result.contains(expectedResult), errorMessage);
    }
    
    public static void expectToInclude(Object result, String expectedResult, String errorMessage) {
        Assert.assertTrue(((String) result).contains(expectedResult), errorMessage);
    }
    
    public static void expectToInclude(List<String>  result, String expectedResult, String errorMessage) {
        Assert.assertTrue(result.contains(expectedResult), errorMessage);
    }
    public static void expectToNotInclude(String result, String expectedResult, String errorMessage) {
        Assert.assertFalse(result.contains(expectedResult), errorMessage);
    }
    public static void expectToNotInclude(List<String> result, String expectedResult, String errorMessage) {
        Assert.assertFalse(result.contains(expectedResult), errorMessage);
    }
    public static void expectToBeTrue(boolean result, String errorMessage) {
        Assert.assertTrue(result, errorMessage);
    }

    public static void expectToBeFalse(boolean result, String errorMessage) {
        Assert.assertFalse(result, errorMessage);
    }
    
    public static void expectToIncludeMembers(List<String> actual, List<String> expected, String errorMessage) {
        Set<String> actualSet = new HashSet<>(actual);
        Set<String> expectedSet = new HashSet<>(expected);
        Assert.assertTrue(actualSet.containsAll(expectedSet), errorMessage);
    }
    public static void expectToNotIncludeMembers(List<String> actual, List<String> expected, String errorMessage) {
        for (String item : expected) {
            Assert.assertFalse(actual.contains(item), errorMessage);
        }
    }

    public static void expectToHaveMembers( List<String> result, List<String> expectedResult, String errorMessage) {
        Assert.assertEquals(result, expectedResult, errorMessage);
    }

    public static void expectToNotHaveMembers(Collection<?> result, Collection<?> expectedResult, String errorMessage) {
        Assert.assertNotEquals(result, expectedResult, errorMessage);
    }

    public static void expectToHaveProperty(Object result, String property, String errorMessage) {
        boolean hasProperty = false;
        Field[] fields = result.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(property)) {
                hasProperty = true;
                break;
            }
        }
        Assert.assertTrue(hasProperty, errorMessage);
    }

    public static void expectToNotHaveProperty(Object result, String property, String errorMessage) {
        boolean hasProperty = false;
        Field[] fields = result.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(property)) {
                hasProperty = true;
                break;
            }
        }
        Assert.assertFalse(hasProperty, errorMessage);
    }

    public static void expectToEveryStringInArrayStartWith(List<String> actual, String expected, String errorMessage) {
        boolean allMatch = actual.stream().allMatch(str -> str.startsWith(expected));
        Assert.assertTrue(allMatch, errorMessage);
    }
    public static void expectToEveryStringEqualInArray(List<String> actual, String expected, String errorMessage) {
        boolean allMatch = actual.stream().allMatch(str -> str.equals(expected));
        Assert.assertTrue(allMatch, errorMessage);
    }


    public static void expectToEveryStringIncludeInArray(List<String> actual, String expected, String errorMessage) {
        boolean allMatch = actual.stream().allMatch(str -> str.contains(expected));
        Assert.assertTrue(allMatch, errorMessage);
    }

    
    public static void expectToStringIncludesEachArrayMember(String actual, List<String> expected, String errorMessage) {
        boolean allIncluded = expected.stream().allMatch(actual::contains);
        Assert.assertTrue(allIncluded, errorMessage);
    }
 
    public static void expectToSomeArrayMemberIncludeString(List<String> actual, String expected, String errorMessage) {
        boolean anyMatch = actual.stream().anyMatch(str -> str.contains(expected));
        Assert.assertTrue(anyMatch, errorMessage);
    }

    public static void expectToEveryStringNotIncludeInArray(List<String> actual, String expected, String errorMessage) {
        boolean allMatch = actual.stream().noneMatch(str -> str.contains(expected));
        Assert.assertTrue(allMatch, errorMessage);
    }

    public static void expectToBeGreaterThanOrEqual(int actual, int expected, String errorMessage) {
        Assert.assertTrue(actual >= expected, errorMessage);
    }

    public static void expectToBeGreaterThan(int actual, int expected, String errorMessage) {
        Assert.assertTrue(actual > expected, errorMessage);
    }
    public static void expectToArrayIsSortedInAscendingOrder(List<String> actual, String errorMessage) {
        List<String> sorted = actual.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(actual, sorted, errorMessage);
    }

    public static void expectToArrayIsSortedInDescendingOrder(List<String> actual, String errorMessage) {
        List<String> sorted = actual.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        Assert.assertEquals(actual, sorted, errorMessage);
    }

//	public static void expectToEveryStringIncludeSomeValueFromArray(List<String> columnValueList,
//			List<String> filterResult, String errorMessage) {
//		 boolean allMatch = columnValueList.stream()
//		            .allMatch(resultValue -> filterResult.stream().anyMatch(resultValue::contains));
//
//		        Assert.assertTrue(allMatch, errorMessage + "\nexpected: " + filterResult + "\nresult: " + columnValueList);		
//	}
//    public static void expectToEveryStringIncludeSomeValueFromArray(String[] resultList, String[] valueList, String errorMessage) throws AssertionError {
//        for (String resultValue : resultList) {
//            boolean matchFound = false;
//            for (String value : valueList) {
//                if (resultValue.contains(value)) {
//                    matchFound = true;
//                    break;
//                }
//            }
//            if (!matchFound) {
//                throw new AssertionError(errorMessage + "\nexpected: [" + arrayToString(valueList) + "]\nresult: [" + arrayToString(resultList) + "]\n");
//            }
//        }
//    }
    
    public static void expectToEveryStringIncludeSomeValueFromArray(List<String> resultList, List<String> valueList, String errorMessage) {
        boolean allMatch = resultList.stream()
                .allMatch(resultValue -> valueList.stream()
                        .anyMatch(resultValue::contains));

        // Constructing the error message similar to the provided TypeScript function.
        String constructedErrorMessage = errorMessage + "\nexpected: [" + Arrays.toString(valueList.toArray()) +
                "]\nresult: [" + Arrays.toString(resultList.toArray()) + "]\n";

        Assert.assertTrue(allMatch, constructedErrorMessage);
    }

//    private static String arrayToString(String[] array) {
//        return String.join(", ", array);
//    }
//	 


}

