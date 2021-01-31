package Utils;
import java.sql.*;
import java.util.*;

/* we have 3 interfaces
  1. Connection
  2. Statement
  3. ResultSet
  * */
public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection( //provide url to connect to db
                "jdbc:oracle:thin:@jazaws.cl18wr0cs3g4.us-east-2.rds.amazonaws.com:1521/ORCL",
                "jaz_aws",
                "928786Kg");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees order by employee_id");

        resultSet.next(); //goes to the 1st row
        //return type of next(); is boolean. If there is the next row then it will return true, if last row then false

        String firstName = resultSet.getString("first_name");
        System.out.println(firstName);

        String lastName = resultSet.getString("last_name");
        System.out.println(lastName);

        resultSet.last(); //goes to the last row

        String fName = resultSet.getString("first_name");
        System.out.println(fName);

        resultSet.first();
        System.out.println(resultSet.getString("last_name"));

        System.out.println(resultSet.getString(1));

        System.out.println(resultSet.getRow()); //returns current row number

        resultSet.last();
        System.out.println(resultSet.getObject("phone_number"));

        //-----------------------RESULTSET METADATA----------------------------
        resultSet.first();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        /*
         * RESUTSETMETADAT
         * */

        System.out.println(resultSetMetaData.getColumnName(4));
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(9));

        List<Map<String, Object>> data = new ArrayList<>();

        while (resultSet.next()) {

            Map<String, Object> map = new LinkedHashMap<>();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }

            data.add(map);
        }
        System.out.println(data.get(0).get("EMAIL"));

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).get("EMAIL"));
        }


        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).get("EMAIL"));
        }


        for (int i = 0; i < data.size(); i++) {
            for (int b = 1; b <= resultSetMetaData.getColumnCount(); b++) {
                System.out.print(" " + data.get(i).get(resultSetMetaData.getColumnName(b)));
            }
            System.out.println();
        }

        System.out.println("============================================");

        for (int i = 0; i < data.size(); i++) {

            Collection<Object> values = data.get(i).values();
            for (Object value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        //keySet to get keys


    }
}

