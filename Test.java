import java.sql.*;

public class Test {
    public static void select(){

        String url = "jtbc:mariadb://localhost:3306/db1";
        String dbUserId = "dk";
        String dbPassword = "ehdrms6390";

        try {
            Class.forName("org.mariadb.jdbc.client.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // JDBC 드라이버 로드

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url,dbUserId,dbPassword);
            String sql = " select member_type, user_id, password, name " +
                    " from member_info " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "email");

            rs = preparedStatement.executeQuery(); // 쿼리 실행

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
