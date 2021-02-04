package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.DBManager;

import api.DataVO;

public class DataDAO {
	DataDAO() {
	}

	private static DataDAO instance = new DataDAO();

	public static DataDAO getInstance() {
		return instance;
	}

	private String returns = "";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

//   public List<DataVO> selectAllBoard() {
//      String sql = "select * from board order by num desc";
//      
//      List<DataVO> list = new ArrayList<DataVO>();
//      Connection conn = null;
//      Statement stmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = DBManager.getConnection();
//         stmt = conn.createStatement();
//         
//         rs = stmt.executeQuery(sql);
//         
//         while (rs.next()) {
//            DataVO bVo = new DataVO();
//            
//            bVo.setNum(rs.getInt("num"));
//            bVo.setName(rs.getString("name"));
//            bVo.setEmail(rs.getString("email"));
//            bVo.setPass(rs.getString("pass"));
//            bVo.setTitle(rs.getString("title"));
//            bVo.setContent(rs.getString("content"));
//            bVo.setReadcount(rs.getInt("readcount"));
//            bVo.setWritedate(rs.getTimestamp("writedate"));
//            
//            list.add(bVo);
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         DBManager.close(conn, stmt, rs);
//      }
//      return list;
//   }

	public String insertBoard(String a) throws NamingException {

		String sql = "insert into apt(apartmentname) values('" + a + "')";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println(sql);

		try {

			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

//         Context init = new InitialContext();
//         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myoracle");
//         conn = ds.getConnection();

//         Statement stmt = conn.createStatement();

//         pstmt = conn.prepareStatement(sql);

//         pstmt.setString(1, bVo.getApartmentname());

//         pstmt.setString(2, bVo.getEmail());
//         pstmt.setString(3, bVo.getPass());
//         pstmt.setString(4, bVo.getTitle());
//         pstmt.setString(5, bVo.getContent());

//         pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return returns;
	}

	public String write(String APARTMENTNAME, String AMOUNT, String DEALYEAR, String DEALMONTH, String DEALDAY,
			String DONG, String SIGUNGU, String AREAUSE, String JIBUN, String REGIONALCODE, String FLOOR)
			throws SQLException, NamingException, ClassNotFoundException {
		try {
//      Context initContext = new InitialContext();
//      DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myoracle");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc loading complete");

			String url = "jdbc:oracle:thin:@172.30.1.46:1521:xe";
			String id = "laplas";
			String pw = "desk3550";

			Connection con = DriverManager.getConnection(url, id, pw);

//			String dealyear = "2020";
//			String sql1 = "delete from apt where dealyear=?";
//			pstmt = con.prepareStatement(sql1); // sql문 전달
//			pstmt.setString(1, dealyear);
//			pstmt.executeUpdate();

			Statement stmt = con.createStatement();
			String seq = "select max(num) from apt";
			ResultSet rs = stmt.executeQuery(seq);

			int num = -1;
			if (rs.next())
				num = rs.getInt(1);
			num++;

//        Context initCtx = new InitialContext();
//        Context envCtx = (Context) initCtx.lookup("java:comp/env");
//        DataSource ds = (DataSource) envCtx.lookup("jdbc/myoracle");
//      
//        if (ds != null)
//            conn = ds.getConnection();
//        else
//            System.out.println("WRCSDB Connection Fail");

			String sql = "insert into apt(NUM, APARTMENTNAME, AMOUNT , DEALYEAR ,DEALMONTH ,DEALDAY ,DONG ,SIGUNGU ,AREAUSE ,JIBUN ,REGIONALCODE ,FLOOR) "
					+ "values('" + num + "', '" + APARTMENTNAME + "', '" + AMOUNT + "', '" + DEALYEAR + "', '"
					+ DEALMONTH + "', '" + DEALDAY + "', '" + DONG + "', '" + SIGUNGU + "', '" + AREAUSE + "', '"
					+ JIBUN + "', '" + REGIONALCODE + "', '" + FLOOR + "')";

			System.out.println(sql);

//      Statement stmt = con.createStatement();
//      String seq = "select max(num) from listnew";
//      ResultSet rs = stmt.executeQuery(seq);
//
//      int num = -1;
//      if (rs.next())
//         num = rs.getInt(1);
//      num++;

//      String nowTime = getCurrentTime("M월 d일 HH시 mm분 ss초");
//      System.out.println(nowTime);
//
//      System.out.println("시간확인" + nowTime);

			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			returns = "success";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return returns;
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

//   public DataVO selectOneBoardByNum(String num) {
//      String sql = "select * from board where num = ?";
//      
//      DataVO bVo = null;
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      
//      try {
//         conn = DBManager.getConnection();
//         
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, num);
//         
//         rs = pstmt.executeQuery();
//         
//         if (rs.next()) {
//            bVo = new DataVO();
//            
//            bVo.setNum(rs.getInt("num"));
//            bVo.setName(rs.getString("name"));
//            bVo.setPass(rs.getString("pass"));
//            bVo.setEmail(rs.getString("email"));
//            bVo.setTitle(rs.getString("title"));
//            bVo.setContent(rs.getString("content"));
//            bVo.setWritedate(rs.getTimestamp("writedate"));
//            bVo.setReadcount(rs.getInt("readcount"));
//         }
//      } catch (Exception e) {
//         e.printStackTrace();
//      } finally {
//         DBManager.close(conn, pstmt, rs);
//      }
//      return bVo;
//   }

//   public void updateBoard(BoardVO bVo) {
//      String sql = "update board set name=?, email=?, pass=?, title=?, content=? where num=?";
//      
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      
//      try {
//         conn = DBManager.getConnection();
//         
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, bVo.getName());
//         pstmt.setString(2, bVo.getEmail());
//         pstmt.setString(3, bVo.getPass());
//         pstmt.setString(4, bVo.getTitle());
//         pstmt.setString(5, bVo.getContent());
//         pstmt.setInt(6, bVo.getNum());
//         
//         pstmt.executeUpdate();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         DBManager.close(conn, pstmt);
//      }
//   }

//   public DataVO checkPassWord(String pass, String num) {
//      String sql = "select * from board where pass=? and num=?";
//      
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      ResultSet rs = null;
//      DataVO bVo = null;
//      
//      try {
//         conn = DBManager.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, pass);
//         pstmt.setString(2, num);
//         
//         rs = pstmt.executeQuery();
//         
//         if (rs.next()) {
//            bVo = new DataVO();
//            
//            bVo.setNum(rs.getInt("num"));
//            bVo.setName(rs.getString("name"));
//            bVo.setEmail(rs.getString("email"));
//            bVo.setPass(rs.getString("pass"));
//            bVo.setTitle(rs.getString("title"));
//            bVo.setContent(rs.getString("content"));
//            bVo.setReadcount(rs.getInt("readcount"));
//            bVo.setWritedate(rs.getTimestamp("writedate"));
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//      return bVo;
//   }
	public void deleteBoard() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc loading delete complete");

			String url = "jdbc:oracle:thin:@172.30.1.46:1521:xe";
			String id = "laplas";
			String pw = "desk3550";

			Connection con = DriverManager.getConnection(url, id, pw);

			String dealyear = "2021";
			String sql1 = "delete from apt where dealyear=?";
			pstmt = con.prepareStatement(sql1); // sql문 전달
			pstmt.setString(1, dealyear);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
//   public void deleteBoard(String num) {
//      String sql = "delete board where num=?";
//      
//      Connection conn = null;
//      PreparedStatement pstmt = null;
//      
//      try {
//         conn = DBManager.getConnection();
//         pstmt = conn.prepareStatement(sql);
//         
//         pstmt.setString(1, num);
//         
//         pstmt.executeUpdate();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
