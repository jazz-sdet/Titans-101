package Utils;

public class PayloadUtils {

    public static String getSlackMessagePayload(String message) {
        String messagePayload = "{\n" +
                "\t\"channel\": \"C01GEQL1GNQ\",\n" +
                "\t\"text\": \"" + message + "\"\n" +
                "}";
        return messagePayload;
    }

    public static String getPetStore(int id, String name, String status) {
        String petStorePayload = "{\n" +
                "  \"id\":" + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 700,\n" +
                "    \"name\": \"German Shepard\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        return petStorePayload;
    }

    public static String getJiraStoryPayload(String summary, String description, String issueType) {
        return "{\n" +
                "\t\"fields\": {\n" +
                "        \"project\":{\n" +
                "            \"key\": \"TEC\"\n" +
                "        },\n" +
                "        \"summary\": \"" + summary + "\",\n" +
                "        \"description\": \"" + description + "\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"" + issueType + "\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }


    public static String JiraAuthPayload() {
        return "{\n" +
                "    \"username\":\"Jaz\",\n" +
                "    \"password\":\"928786Kg\"\n" +
                "}";

    }
}


