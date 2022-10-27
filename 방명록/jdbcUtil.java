package 방명록;

import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtil {

    public static void close(ResultSet rs){
        if(rs != null && !rs.isClosed()){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
