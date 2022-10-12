package crud;

import java.sql.*;

public class MemberService {
    // 회원 정보 출력 함수
    public static void printInfo(Member m){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String dbUserId = "dk";
        String dbPassword = "zerobase";

        // 드라이버 로드

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Connection 객체 생성하자
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;



        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " select member_type, user_id, password, name " +
                    " from member_info " +
                    " where member_type = ? ";
            // 실행할 쿼리

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m.getMemberType());

            rs = preparedStatement.executeQuery(); // 쿼리 실행
            while(rs.next()){
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 회원 가입 함수
    public static void register(Member m){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String dbUserId = "dk";
        String dbPassword = "zerobase";

        // 드라이버 로드

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Connection 객체 생성하자
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        /*
        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "3333";
        String nameValue = "zerobase";
        */
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql =   " insert into member_info " +
                    " (member_type, user_id, password, name) " +
                    " values (?,?,?,?); ";
            // 실행할 쿼리

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m.getMemberType());
            preparedStatement.setString(2, m.getUserId());
            preparedStatement.setString(3, m.getPassword());
            preparedStatement.setString(4, m.getName());


            int affected = preparedStatement.executeUpdate();
            // 쿼리 실행

            if(affected > 0)
                System.out.println("저장 성공");
            else
                System.out.println("저장 실패");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 정보 업데이트 함수
    public static void update(Member m){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String dbUserId = "dk";
        String dbPassword = "zerobase";

        // 드라이버 로드

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Connection 객체 생성하자
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "update member_info set " +
                    " password = ?  " +
                    " where member_type = ? and user_id = ? ";
            // 실행할 쿼리

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m.getPassword());
            preparedStatement.setString(2, m.getMemberType());
            preparedStatement.setString(3, m.getUserId());


            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 수정 성공 ");
            }else{
                System.out.println(" 수정 실패 ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 회원 탈퇴 함수
    public static void withdraw(Member m){

        String url = "jdbc:mariadb://localhost:3306/db1";
        String dbUserId = "dk";
        String dbPassword = "zerobase";

        // 드라이버 로드

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Connection 객체 생성하자
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;


        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " delete from member_info " +
                    "where user_id = ? and member_type = ? ";
            // 실행할 쿼리

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, m.getMemberType());
            preparedStatement.setString(2, m.getUserId());

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 삭제 성공 ");
            }else{
                System.out.println(" 삭제 실패 ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
