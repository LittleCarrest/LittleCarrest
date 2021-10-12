package com.littleCarrest.common.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class JDBCTemplate {

   //Singleton 패턴
   //해당 클래스의 인스턴스가 하나만 생성되어야 할 때 사용하는 디자인패턴
   private static JDBCTemplate instance;
   private static PoolDataSource pds;

   //생성자를 private으로 처리해 외부에서 JDBCTemplate을 생성하는 것을 차단.
   private JDBCTemplate() {
      try {
         //1. oracle jdbc Driver를 JVM에 등록
         Class.forName("oracle.jdbc.driver.OracleDriver");

          final String DB_URL="jdbc:oracle:thin:@littlecarrest_high?TNS_ADMIN=C:/littlecarrest/Wallet_littlecarrest";
           // Use the TNS Alias name along with the TNS_ADMIN - For ATP and ADW
           // final static String DB_URL="jdbc:oracle:thin:@dbname_alias?TNS_ADMIN=/Users/test/wallet_dbname";
           final String DB_USER = "ADMIN";
           final String DB_PASSWORD = "Rladbswjd123!";
           final String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";


         pds = PoolDataSourceFactory.getPoolDataSource();

         pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
         pds.setURL(DB_URL);
         pds.setUser(DB_USER);
         pds.setPassword(DB_PASSWORD);
         pds.setConnectionPoolName("JDBC_UCP_POOL");

          // Default is 0. Set the initial number of connections to be created
          // when UCP is started.
          pds.setInitialPoolSize(5);

          // Default is 0. Set the minimum number of connections
          // that is maintained by UCP at runtime.
          pds.setMinPoolSize(5);

          // Default is Integer.MAX_VALUE (2147483647). Set the maximum number of
          // connections allowed on the connection pool.
          pds.setMaxPoolSize(20);

          // Default is 30secs. Set the frequency in seconds to enforce the timeout
          // properties. Applies to inactiveConnectionTimeout(int secs),
          // AbandonedConnectionTimeout(secs)& TimeToLiveConnectionTimeout(int secs).
          // Range of valid values is 0 to Integer.MAX_VALUE. .
          pds.setTimeoutCheckInterval(5);

          // Default is 0. Set the maximum time, in seconds, that a
          // connection remains available in the connection pool.
         pds.setInactiveConnectionTimeout(10);



      } catch (ClassNotFoundException | SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }


   //외부에서 JDBCTemplate의 인스턴스를 생성하지 않고도 사용할 수 있는
   //JDBCTemplate의 인스턴스를 반환받는 용도의 메서드
   public static JDBCTemplate getInstance() {
      //instance 변수가 초기화 된적이 없다면 
      if(instance == null) {
         instance = new JDBCTemplate();
      }

      return instance;
   }

   //2. 데이터베이스와 연결 수립
   public Connection getConnection() {      
      Connection conn = null;
      try { 
      conn = pds.getConnection();
      //트랜잭션관리를 개발자가 하기 위해 Auto Commit 설정 끄기
      conn.setAutoCommit(false);

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return conn;
   }

   //3. commit / rollback
   public void commit(Connection conn) {
      try {
         conn.commit();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void rollback(Connection conn) {
      try {
         conn.rollback();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   //4. 시스템 자원(Connection, Statement, ResultSet) 반환
   public void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void close(Statement stmt) {
      try {
         if(stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void close(ResultSet rset) {
      try {
         if(rset != null && !rset.isClosed()) {
            rset.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void close(Statement stmt, Connection conn) {
      close(stmt);
      close(conn);
   }

   public void close(ResultSet rset, Statement stmt) {
      close(rset);
      close(stmt);
   }

   public void close(ResultSet rset, Statement stmt, Connection conn) {
      close(rset);
      close(stmt);
      close(conn);
   }


} 