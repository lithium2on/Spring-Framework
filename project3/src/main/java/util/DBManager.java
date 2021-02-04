package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
   public static Connection getConnection() {
      Connection conn = null;
      try {
         
            String user = "laplas"; 
            String pw = "desk3550";
            String url = "jdbc:oracle:thin:@172.30.1.46:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
         
//         Context initContext = new InitialContext();
//         Context envContext = (Context) initContext.lookup("java:/comp/env");
//         DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
//         conn = ds.getConnection();
         
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      return conn;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }

   // select을 수행한 후 리소스 해제를 위한 메소드
   public static void close(Connection conn, Statement stmt, ResultSet rs) {
      try {
         rs.close();
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void close(Connection conn, Statement stmt) {
      try {
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
