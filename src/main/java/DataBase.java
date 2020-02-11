import com.github.vldrus.sql.rowset.CachedRowSetWrapper;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

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

    public void dbDisconnect(){
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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


    public ResultSet dbExecuteQuery(String queryStmt) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try{

            dbConnect();

            preparedStatement = connection.prepareStatement(queryStmt);
            resultSet = preparedStatement.executeQuery(queryStmt);
            cachedRowSet = new CachedRowSetWrapper();
            cachedRowSet.populate(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            dbDisconnect();
        }

        return cachedRowSet;
    }

    public void dbExecuteUpdate(String sqlStmt) throws SQLException {
        Statement statement = null;
        try {
            dbConnect();
            statement = connection.createStatement();
            statement.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            dbDisconnect();
        }
    }

}//end of class
