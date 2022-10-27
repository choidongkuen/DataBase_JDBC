package 방명록;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDao {

    private MessageDao messageDao = new MessageDao();
    public MessageDao getInstance(){
        return this.messageDao;
    }
    private MessageDao(){};
    // 싱글톤으로 작성
    // 데이터의 공유 용이, 오직 하나의 객체만 사용 가능

    public int insert(Connection conn, Message message) throws SQLException{
        PreparedStatement pstmt = null;

        try{
            String sql = " insert into guestbook_message " +
                        " (guest_name, password, message) " +
                         " values (?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, message.getGuestName());
            pstmt.setString(2,message.getPassword());
            pstmt.setString(3,message.getMessage());
            return pstmt.executeUpdate();
        }finally {
            jdbcUtil.close(pstmt);
        }
    }
}
