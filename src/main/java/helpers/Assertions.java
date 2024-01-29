package helpers;

import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

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
    
    public static void expectToIncludeMembers(Collection<?> result, Collection<?> expectedResult, String errorMessage) {
        Assert.assertTrue(result.containsAll(expectedResult), errorMessage);
    }

    public static void expectToNotIncludeMembers(Collection<?> result, Collection<?> expectedResult, String errorMessage) {
        for (Object item : expectedResult) {
            Assert.assertFalse(result.contains(item), errorMessage);
        }
    }

    public static void expectToHaveMembers( List<String> result, String expectedResult, String errorMessage) {
        Assert.assertEquals(result.toArray(), expectedResult, errorMessage);
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

    public static void expectToEveryStringInArrayStartWith(List<String> resultList, String expectedResult, String errorMessage) {
        for (String item : resultList) {
            Assert.assertTrue(item.startsWith(expectedResult), errorMessage);
        }
    }

    public static void expectToEveryStringEqualInArray(List<String> resultList, String expectedResult, String errorMessage) {
        for (String item : resultList) {
            Assert.assertEquals(item, expectedResult, errorMessage);
        }
    }

    public static void expectToEveryStringIncludeInArray(List<String> resultList, String expectedResult, String errorMessage) {
        for (String item : resultList) {
            Assert.assertTrue(item.contains(expectedResult), errorMessage);
        }
    }
    
   
    public static void expectToStringIncludesEachArrayMember(List<String> resultList, String expectedResult, String errorMessage) {
        for (String substring : resultList) {
            Assert.assertTrue(expectedResult.contains(substring), errorMessage);
        }
    }

    public static void expectToSomeArrayMemberIncludeString(List<String> resultList, String expectedResult, String errorMessage) {
        boolean found = false;
        for (String substring : resultList) {
            if (substring.contains(expectedResult)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found, errorMessage);
    }

    public static void expectToEveryStringNotIncludeInArray(List<String> resultList, String expectedResult, String errorMessage) {
        for (String item : resultList) {
            Assert.assertFalse(item.contains(expectedResult), errorMessage);
        }
    }

    public static void expectToBeGreaterThanOrEqual(int result, int expectedResult, String errorMessage) {
        Assert.assertTrue(result >= expectedResult, errorMessage);
    }

    public static void expectToBeGreaterThan(int result, int expectedResult, String errorMessage) {
        Assert.assertTrue(result > expectedResult, errorMessage);
    }

    public static void expectToArrayIsSortedInAscendingOrder(List<String> resultList, String errorMessage) {
        boolean isSorted = true;
        for (int i = 1; i < resultList.size(); i++) {
            if (resultList.get(i - 1).compareTo(resultList.get(i)) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, errorMessage);
    }

    public static void expectToArrayIsSortedInDescendingOrder(List<String> resultList, String errorMessage) {
        boolean isSorted = true;
        for (int i = 1; i < resultList.size(); i++) {
            if (resultList.get(i - 1).compareTo(resultList.get(i)) < 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, errorMessage);
    }

	public static void expectToEveryStringIncludeSomeValueFromArray(List<String> columnValueList,
			List<String> filterResult, String errorMessage) {
		 boolean allMatch = columnValueList.stream()
		            .allMatch(resultValue -> filterResult.stream().anyMatch(resultValue::contains));

		        Assert.assertTrue(allMatch, errorMessage + "\nexpected: " + filterResult + "\nresult: " + columnValueList);		
	}
	 


}

