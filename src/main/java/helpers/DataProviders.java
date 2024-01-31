package helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;

@SuppressWarnings("unchecked")
public class DataProviders {

	private static final String sideMenuOptionsTestData = "testData/uiTestData/sideMenuTestData";
	private static final String UrlTestData = "testData/urlTestData/DEV";
	private static final String UserTestData = "testData/userTestData";
	private static final String addContactTestData = "testData/uiTestData/addContactTestData";
	private static final String GroupTestData = "testData/uiTestData/groupTestData";
	private static final String FormTestData ="testData/uiTestData/formTestData";
	private static final String filterContactsTestData = "testData/uiTestData/filterContactsTestData";

	public static String provideTestData(String fileName,String datas) {

		JSONParser parser = new JSONParser();
		String output = "";
		try (FileReader reader = new FileReader(fileName + ".json")) {
			Object obj = parser.parse(reader);
			JSONObject data = (JSONObject) obj;
			output = (String) data.get(datas);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}

	public static Map<String, Object> provideTestData(String fileName, int contactIndex) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File(fileName + ".json");
			Map<String, Object>[] testDataArray = objectMapper.readValue(file, Map[].class);
			

			for (Map<String, Object> data : testDataArray) {
				if (String.valueOf(data.get("index")).equals(String.valueOf(contactIndex))) {
					return data;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static List<String> provideTestDataArray(String fileName, String fieldName) {
		JSONParser parser = new JSONParser();
		List<String> outputTemp = new ArrayList<>();
		try (FileReader reader = new FileReader( fileName + ".json")) {
			Object obj = parser.parse(reader);
			JSONObject data = (JSONObject) obj;
			JSONArray temp = (JSONArray) data.get(fieldName);
			temp.forEach(f -> outputTemp.add((String) f));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return outputTemp;
	}

	private static String getIdentifierByChannelId(Map<String, Object> data, int channelId, String destinationData) {
		JsonNode jsonData = new ObjectMapper().valueToTree(data.get("destination"));

		for (JsonNode channel : jsonData) {
			int currentChannelId = channel.path("channelId").asInt();

			if (currentChannelId == channelId) {
				return channel.path(destinationData).asText();
			}
		}

		return null;
	}

	public static String getUrlTestData(String URLName) {
		String provideTestData = provideTestData(UrlTestData,URLName);
		//System.out.println(provideTestData);
		return provideTestData;
	}

	public static String getUserTestData(String contactData, int index) {
		Map<String, Object> testData = provideTestData(UserTestData, index);
		return (String) testData.get(contactData);
	}

	public static String getContactTestData(String contactData, int index) {
		Map<String, Object> testData = provideTestData(addContactTestData, index);
		return (String) testData.get(contactData);
	}

	public static String getContactTestData(String destinationData, int index, int channelId) {
		Map<String, Object> data = provideTestData(addContactTestData, index);
		return getIdentifierByChannelId(data, channelId , destinationData);
	}

	public static String getphoneDetails(String phoneData , int index) {
		Map<String, Object> testData = provideTestData(addContactTestData, index);
		Map<String, Object> phoneObject = (Map<String, Object>) testData.get("phone");
		return (String) phoneObject.get(phoneData);
	}

	public static String getGroupTestData(String dataName, int groupIndex) {
		Map<String, Object> groupTestData = provideTestData(GroupTestData, groupIndex);
		return (String)groupTestData.get(dataName);
	}
	public static List<String> getFilterContactsDropdownTestData(String testData) {
		List<String> provideTestData = provideTestDataArray(filterContactsTestData,testData);
		return provideTestData;
	}
	public static String getFormTestData(String data, int groupIndex) {
		Map<String, Object> formTestdata = provideTestData(FormTestData, groupIndex);
		return (String) formTestdata.get(data);
	}
	
	
//	public static Object getSubmenuOptionsByName(String option) {
//		
//		return null;
//	}
	
//	 public static List<String> getSideMenuOptionsIndexData() throws Throwable, Exception {
//		 String data = provideTestData(sideMenuOptionsTestData, "sideMenuOption");
//		 System.out.println(data);
//		 JsonNode jsonData = new ObjectMapper().valueToTree(data.getBytes("Dashboard"));
//		 System.out.println(jsonData);
//		return null;
//	        
//	    }
	
	

public static void main(String[] args) throws Exception, Throwable {
	String contactTestData2 = getphoneDetails("number", 1);
	System.out.println(contactTestData2);
}

}
