public class Task_01 {
    public static String sqlQueryFromJson(String json) {
        StringBuilder whereClause = new StringBuilder();
        boolean isFirstCondition = true;

        json = json.substring(1, json.length() - 1);

        String[] keyValuePairs = json.split(", ");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replace("\"", "");
            String value = keyValue[1].replace("\"", "");

            if (!value.equals("null")) {
                if (!isFirstCondition) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append("=").append(value);
                isFirstCondition = false;
            }
        }

        String sqlQuery = "SELECT * FROM students WHERE " + whereClause.toString();
        return sqlQuery;
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println(sqlQueryFromJson(json));
    }
}