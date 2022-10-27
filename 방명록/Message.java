package 방명록;

public class Message {

    // 해당 클래스는 DB 테이블에서 읽어온 값을 저장하거나, DAO에 전달할 때 사용되는 클래스
    // 헤당 프로퍼티(속성)들은 DB 테이블에 칼럼명과 전부 매핑

    private int id;
    private String guestName;
    private String password;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean hasPassword(){
        return password!= null && !password.isEmpty();
    }

    public boolean matchPassword(String pwd){
        return password!=null && this.password.equals(pwd);
    }
}
