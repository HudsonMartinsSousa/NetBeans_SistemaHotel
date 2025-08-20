/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

/**
 *
 * @author Martins
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;







public class FabricaConexao {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER ="root" ;
    private static final String PASS = "";
    
    
    public  static Connection getConnection()  {
       
        
        try{
            
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel","root","");
            
        
                    
              }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null ,"Erro de conexão");
       return null; 
    }
    
}
  
    //criar metodo para fechar a conexão pra não sobrecarregar o servidor------------------------------------------------
    public static void closeConnection(Connection con){
        try {
            if(con!=null){
            con.close();
        }
            }catch (SQLException ex){
                        Logger.getLogger(FabricaConexao.class.getName()) .log(Level.SEVERE, null, ex);
                        
            }
        }
    
    
   public static void closeConnection(Connection con, PreparedStatement stmt){
       closeConnection(con);
       try {
            if(stmt!=null){
            stmt.close();
        }
            }catch (SQLException ex){
                        Logger.getLogger(FabricaConexao.class.getName()) .log(Level.SEVERE, null, ex);
                        
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt,ResultSet rs){
       closeConnection(con, stmt);
       try {
            if(rs!=null){
            rs.close();
        }
            }catch (SQLException ex){
                        Logger.getLogger(FabricaConexao.class.getName()) .log(Level.SEVERE, null, ex);
                        
            }
        }
    }
        
