/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author batis
 */
public class combo {
        
private static Connection conn;
         public static final String DRIVER="com.mysql.jdbc.Driver";
       
          public static final String USUARIO="root";
         public static final String PASSWORD="xboxONE.5";
         public static final String URL="jdbc:mysql://localhost:3306/basetienda";
         PreparedStatement ps;
         ResultSet rs;
         
       public static Connection getConnection(){
             conn=null;
             try {
                 Class.forName(DRIVER);
                 conn=(Connection) DriverManager.getConnection(URL, USUARIO, PASSWORD);
                 if(conn !=null){
                     System.out.print("conexcion establecida");
                 }
                 
                 
             }catch(ClassNotFoundException | SQLException e){
                 System.out.print("conexcion no establecida"+e);
                 
             }
    

    
    return conn;
}
    
       public void caja(JComboBox NumC) {
             Connection conn=null;
             String sql="SELECT Caja_Tienda FROM tienda ORDER BY Caja_Tienda ASC";
               try{
            conn= getConnection();
                 Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            NumC.addItem("seleccione una opcion");
            while(rs.next()){
                NumC.addItem(rs.getString("Caja_Tienda"));
            }
            
            }catch(SQLException e){
                     System.err.println(e);
                     }
    
}
         public void caji(JComboBox NumC) {
             Connection conn=null;
             String sql="SELECT nombre_Proveedores FROM proveedores ORDER BY nombre_Proveedores ASC";
               try{
            conn= getConnection();
                 Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            NumC.addItem(null);
            
            while(rs.next()){
                NumC.addItem(rs.getString("nombre_Proveedores"));
            }
            
            }catch(SQLException e){
                     System.err.println(e);
                     }
    
}
               public void caju(JComboBox NumC) {
             Connection conn=null;
             String sql="SELECT cod_proveedores FROM proveedores ORDER BY cod_proveedores ASC";
               try{
            conn= getConnection();
                 Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                NumC.addItem(rs.getString("cod_proveedores"));
            }
            
            }catch(SQLException e){
                     System.err.println(e);
                     }
    
}
       }   

