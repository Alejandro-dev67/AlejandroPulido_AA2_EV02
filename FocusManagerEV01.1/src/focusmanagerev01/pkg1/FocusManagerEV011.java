/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package focusmanagerev01.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class FocusManagerEV011 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        //CONSULTA DE DATOS 
        String usuario="root";
        String password="admingap01";
        String url="jdbc:mysql://localhost:3306/gestordetareas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FocusManagerEV011.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CONSULTA DE DATOS
        try {
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM gestordetareas.usuarios");
            System.out.println("CONSULTA DE DATOS");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario")+":"+ rs.getString("nombre"));
            }while (rs.next());
            
            //INSERT
            statement.executeUpdate("INSERT INTO usuarios (nombre, correo, clave) VALUES ('Marlon', 'marloonn56@email.com', '8952')");
             System.out.println("");
            System.out.println("INSERTAR");
            rs=statement.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario")+":"+ rs.getString("nombre"));
            }while (rs.next());
            
            //UPDATE
            statement.executeUpdate("UPDATE usuarios SET nombre='Nelson' WHERE id_usuario = 2");
             System.out.println("");
            System.out.println("ACTUALIZAR");
            rs=statement.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario")+":"+ rs.getString("nombre"));
            }while (rs.next());
            
            //DELETE
            statement.executeUpdate("DELETE from usuarios WHERE id_usuario = 3");
            System.out.println("");
            System.out.println("BORRAR");
            rs=statement.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("id_usuario")+":"+ rs.getString("nombre"));
            }while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(FocusManagerEV011.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    }
    
    

