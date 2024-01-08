package helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
public class DataProviders {
	

	public static  String provideTestData(String fileName,String datas) {

		JSONParser parser = new JSONParser();
		String output = "";
		try (FileReader reader = new FileReader("testData/uiTestData/"+ fileName+".json")) {
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
            File file = new File("testData/uiTestData/" + fileName + ".json");
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
public static String getUrlTestData() {
	return provideTestData("DEV", "waymorePageUrl");
	
}
    public static String getContactTestData(String contactData) {
        Map<String, Object> testData = provideTestData("addContactTestData", 1);
        return (String) testData.get(contactData);
    }

    public static String getContactTestData(String contactData ,String destinationData) {
        Map<String, Object> data = provideTestData("addContactTestData", 1);
        return getIdentifierByChannelId(data, 7,destinationData);
    }
    
    public static String getphoneDetails(String phoneData) {
    	 Map<String, Object> testData = provideTestData("addContactTestData", 1);
		Map<String, Object> phoneObject = (Map<String, Object>) testData.get("phone");
    	 return (String) phoneObject.get(phoneData);
    }

    private static String getIdentifierByChannelId(Map<String, Object> data, int channelId,String destinationData) {
        JsonNode jsonData = new ObjectMapper().valueToTree(data.get("destination"));

        for (JsonNode channel : jsonData) {
            int currentChannelId = channel.path("channelId").asInt();

            if (currentChannelId == channelId) {
                return channel.path(destinationData).asText();
            }
        }

        return null;
    }

    public static String getUserTestData(String contactData) {
        Map<String, Object> testData = provideTestData("userTestData", 1);
        return (String) testData.get(contactData);
    }
    


}
	

	
