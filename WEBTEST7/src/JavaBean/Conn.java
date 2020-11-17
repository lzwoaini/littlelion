package JavaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Conn {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/new1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "root";
    private Connection conn = null;
    private Statement stmt;
    ResultSet rs;
    public Conn(){
        try {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        return conn;
    }
    public void executeUpdate(String sql) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String sql){
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
