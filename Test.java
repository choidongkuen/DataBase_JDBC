// JDBC API (database API)
import javax.xml.transform.Result;
import java.sql.*;

class Select {
    public void select(String x){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String userId = "dk";
        String userPassword = "zerobase";


        // 1. jdbc 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        // 2. connection 객체 생성
        // 3. preparedStatement 객체 생성
        try {
            connection = DriverManager.getConnection(url,userId,userPassword);

            String sql = " select member_type, user_id, password, name " +
                    " from member_info " +
                    " where member_type = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , x);

        // 4. ResultSet 객체 생성 및 sql 문 실행
            rs = preparedStatement.executeQuery();

            while(rs.next()){

                String member_type = rs.getString("member_type");
                String user_id = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(member_type + " " + user_id + " " + password + " " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try{
                if(connection != null && !connection.isClosed())
                    connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

class Insert{

    public void insert(String x, String y, String z, String w){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String userId = "dk";
        String password = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, userId, password);

            String sql = " insert into member_info " +
                    " (member_type, user_id, password, name) " +
                    " values " +
                    " (?, ? , ? , ?) ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, x);
            preparedStatement.setString(2, y);
            preparedStatement.setString(3, z);
            preparedStatement.setString(4, w);


            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try{
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            }catch( SQLException e) {
                e.printStackTrace();
            }

            try{
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test{
    public static void main(String[] args) {

         Insert i = new Insert();
         i.insert("kakao","dd12@kakao.com","1212","강승현");

//         Select s = new Select();
//         s.select("kakao");
    }
}
