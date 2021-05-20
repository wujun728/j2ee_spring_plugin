package com.jun.base.datasource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 需要在类路径下准备数据库连接配置文件druid.properties
 */
public class DataSourceDruid {
	private static final String configFile = "druid.properties";
	private static DataSource dataSource;
	private static Properties properties = loadPropertyFile(configFile);
	static {
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(DataSourceDruid.class.getClassLoader().getResourceAsStream(configFile));
			dataSource = DruidDataSourceFactory.createDataSource(dbProperties);
			
			//com.alibaba.druid.pool.DruidDataSource.DruidDataSource
			dataSource = new DruidDataSource(); 
			dataSource = DruidDataSourceFactory.createDataSource(dbProperties); 
//			dataSource = DruidDataSourceFactory.createDataSource(properties); 
//			dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 
//			dataSource.setUsername("root"); 
//			dataSource.setPassword("11111111"); 
//			dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/jspdemo"); 
//			dataSource.setInitialSize(5); dataSource.setMinIdle(1); 
//			dataSource.setMaxActive(10); 
			// 启用监控统计功能  dataSource.setFilters("stat");
			// for mysql  dataSource.setPoolPreparedStatements(false);
			
			
			
			Connection conn = getConn();
			DatabaseMetaData mdm = conn.getMetaData();
			 System.err.println("Connected to " + mdm.getDatabaseProductName() + " " +mdm.getDatabaseProductVersion());
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.err.println("初始化连接池失败：" + e);
		}
	}

	private DataSourceDruid() {
	}

	/**
	 * 获取链接，用完后记得关闭
	 * 
	 * @see {@link DBManager#closeConn(Connection)}
	 * @return
	 */
	public static final Connection getConn() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// log.error("获取数据库连接失败：" + e);
		}
		return conn;
	}
	public static final DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 *            需要关闭的连接
	 */
	public static void closeConn(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			// log.error("关闭数据库连接失败：" + e);
		}
	}
	
    
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
	 * 
	 * @param fullFile
	 * @return
	 */
	private static Properties loadPropertyFile(String fullFile) {
		String webRootPath = null;
		if (null == fullFile || fullFile.equals(""))
			throw new IllegalArgumentException("Properties file path can not be null : " + fullFile);
		webRootPath = DataSourceDruid.class.getClassLoader().getResource("").getPath();
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(webRootPath + File.separator + fullFile));
			p = new Properties();
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: " + fullFile);
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + fullFile);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	
	public static void main(String[] args) {
		System.err.println(DataSourceDruid.getConn());
	}
}