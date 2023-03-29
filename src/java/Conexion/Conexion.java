
package Conexion;

import java.sql.*;

public class Conexion {
    
    //ATRIBUTOS
    private static Connection conn = null;

    //CONSTRUCTOR
    private Conexion(){
        String url = "jdbc:mysql://localhost:3306/JDBCExample";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "12345";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    };
    
    //MÉTODOS GETCONNECTION
    public static Connection getConexion(){
        if(conn == null){
            new Conexion();
        }
        
        return conn;
    }
    
    //MÉTODO CLOSE
    public void close() {
        if(conn != null) {
            try {
                conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
