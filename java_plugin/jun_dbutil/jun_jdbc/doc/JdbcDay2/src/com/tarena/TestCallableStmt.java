package com.tarena;

import java.sql.*;

public class TestCallableStmt {
  static Connection conn = null;

  static {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@192.168.0.26:1521:tarena";
      conn = DriverManager.getConnection(url, "openlab", "open123");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    //callSpWithoutOutParam();
    callSpWithOutParam();
  }

  public static void callSpWithOutParam() {
    //������:insert_stu,����:mystu
    String sql = "{call total_count(?,?)}";
    try {
      CallableStatement callStmt = 
        conn.prepareCall(sql);
      callStmt.setInt(1, 30);//�������
      callStmt.
        registerOutParameter(2,Types.INTEGER);//ע������
      callStmt.execute(); 
      int n = callStmt.getInt(2);//��ȡ�������
      System.out.println("����30��" + n + "��Ա��");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public static void callSpWithoutOutParam() {
    //������:insert_stu,����:mystu
    String sql = "{call insert_stu(?,?,?,?)}";
    try {
      CallableStatement callStmt = 
        conn.prepareCall(sql);
      callStmt.setInt(1, 28);
      callStmt.setString(2, "bono");
      callStmt.setInt(3, 28);
      callStmt.setString(4, "M");
      callStmt.execute(); 
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
