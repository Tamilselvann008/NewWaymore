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

@SuppressWarnings("unchecked")
public class DataProviders {

	private static final String addContactTestData = "testData/uiTestData/addContactTestData";
	private static final String addRouteeContactsTestData = "testData/uiTestData/addRouteeContactsTestData";
	private static final String addRouteeGroupTestData = "testData/uiTestData/addRouteeGroupTestData";
	private static final String automationRecepientTestData = "testData/uiTestData/automationRecepientTestData";
	private static final String campaignTestData = "testData/uiTestData/campaignTestData";
	private static final String columnRulesTestData = "testData/uiTestData/columnRulesTestData";
	private static final String contactLabelTestData = "testData/uiTestData/contactLabelTestData";
	private static final String customFieldTestData = "testData/uiTestData/customFieldTestData";
	private static final String downloadContactsTestData = "testData/uiTestData/downloadContactsTestData";
	private static final String downloadTempalteTestData = "testData/uiTestData/downloadTempalteTestData";
	private static final String editContactOptionTestData = "testData/uiTestData/editContactOptionTestData";
	private static final String emailSettingsTestData = "testData/uiTestData/emailSettingsTestData";
	private static final String emailTemplateTestData = "testData/uiTestData/emailTemplateTestData";
	private static final String emailTestData = "testData/uiTestData/emailTestData";
	private static final String filterContactsTestData = "testData/uiTestData/filterContactsTestData";
	private static final String FormTestData = "testData/uiTestData/formTestData";
	private static final String GroupTestData = "testData/uiTestData/groupTestData";
	private static final String landingPageTestData = "testData/uiTestData/landingPageTestData";
	private static final String linkTestData = "testData/uiTestData/linkTestData";
	private static final String pluginTestData = "testData/uiTestData/pluginTestData";
	private static final String profileSettingsTestData = "testData/uiTestData/profileSettingsTestData";
	private static final String pushNotificationTestData = "testData/uiTestData/pushNotificationTestData";
	private static final String quickStartGuideOptionTestData = "testData/uiTestData/quickStartGuideOptionTestData";
	private static final String segmentTestData = "testData/uiTestData/segmentTestData";
	private static final String STAGE = "testData/uiTestData/downloadContactsTestData";
	private static final String sideMenuOptionsTestData = "testData/uiTestData/sideMenuTestData";
	private static final String databaseTestData = "testData/databaseTestData/DEV";
	private static final String DEV = "testData/urlTestData/DEV";
	private static final String UserTestData = "testData/userTestData";

	public static String provideTestData(String fileName, String datas) {

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
		try (FileReader reader = new FileReader(fileName + ".json")) {
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
		String provideTestData = provideTestData(DEV, URLName);
		// System.out.println(provideTestData);
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

	public static String getRouteeContactTestData(String geRouteeContactData, int index) {
		Map<String, Object> testData = provideTestData(addRouteeContactsTestData, index);
		return (String) testData.get(geRouteeContactData);
	}

	public static String getContactTestData(String destinationData, int index, int channelId) {
		Map<String, Object> data = provideTestData(addContactTestData, index);
		return getIdentifierByChannelId(data, channelId, destinationData);
	}

	public static String getphoneDetails(String phoneData, int index) {
		Map<String, Object> testData = provideTestData(addContactTestData, index);
		Map<String, Object> phoneObject = (Map<String, Object>) testData.get("phone");
		return (String) phoneObject.get(phoneData);
	}

	public static String getGroupTestData(String dataName, int groupIndex) {
		Map<String, Object> groupTestData = provideTestData(GroupTestData, groupIndex);
		return (String) groupTestData.get(dataName);
	}

	public static List<String> getFilterContactsDropdownTestData(String testData) {
		return provideTestDataArray(filterContactsTestData, testData);
	}

	public static String getFormTestData(String data, int groupIndex) {
		Map<String, Object> formTestdata = provideTestData(FormTestData, groupIndex);
		return (String) formTestdata.get(data);
	}

	public static void main(String[] args) throws Exception, Throwable {
		String contactTestData2 = getphoneDetails("number", 1);
		System.out.println(contactTestData2);
	}

	public static List<String> getQuickStartGuideOptionsTestDataByName(String option) {
		return provideTestDataArray(quickStartGuideOptionTestData, option);
	}

	public static String getPluginTestData(String plugindata, int pluginIndex) {
		Map<String, Object> provideTestData = provideTestData(pluginTestData, pluginIndex);
		return (String) provideTestData.get(plugindata);
	}

	public static List<String> getSideMenuOptionsIndexData() {

		return provideTestDataArray(sideMenuOptionsTestData, "sideMenuOption");
	}

	public static List<String> getSubmenuOptionsByName(String option) {
		return provideTestDataArray(sideMenuOptionsTestData, option);
	}

	public static String getDownloadContactsTestData(String downloadContactData, int fileIndex) {
		Map<String, Object> downloadcontactdata = provideTestData(downloadContactsTestData, fileIndex);
		return (String) downloadcontactdata.get(downloadContactData);
	}

}
