import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
private String userName;
private String userPassword;
private Connection connection = null;
private boolean isConnectionOk = false;

    public DataBase(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean isConnectionOk() {
        return isConnectionOk;
    }

    public void dbConnect() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            connection= DriverManager.getConnection(createURL());
            isConnectionOk = true;
        }catch (SQLException e){
            isConnectionOk = false;
        }

    }//end of dbConnect

    public String createURL(){
        StringBuilder urlSB = new StringBuilder("jdbc:mysql://");
        urlSB.append("localhost:3306/");
        urlSB.append("florist?");
        urlSB.append("useUnicode=true&characterEncoding=utf-8");
        urlSB.append("&user=");
        urlSB.append(userName);
        urlSB.append("&password=");
        urlSB.append(userPassword);
        urlSB.append("&serverTimezone=CET");

        return urlSB.toString();
    }

}//end of class
