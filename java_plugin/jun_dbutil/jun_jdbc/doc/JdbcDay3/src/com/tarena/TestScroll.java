package com.tarena;
import java.sql.*;
public class TestScroll {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      String sql = "select * from mytemp";//t_loginfo
      conn = ConnectionUtils.openConnection();
      stmt = conn.createStatement
      (ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = stmt.executeQuery(sql);
      rs.first();
      System.out.println("1:" + rs.getString("user_id"));
      rs.last();
      System.out.println("������99����������������:" +rs.getString("user_id"));
      //rs.beforeFirst();
      //rs.afterLast();
      rs.previous();
      System.out.println("98:" + rs.getString("user_id"));
      rs.next();
      System.out.println("99:" + rs.getString("user_id"));
      rs.absolute(99);//����������ĵ�99��
      System.out.println("99:" + rs.getString("user_id"));
      rs.relative(-10);//��������ڵ�ǰλ��ǰ10��
      System.out.println("89:" + rs.getString("user_id"));
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      ConnectionUtils.closeStatement(stmt);
      ConnectionUtils.closeConnection(conn);
    }

  }

}
