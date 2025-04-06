/*Con este codigo vamos a poder conectarnos a la base de datos sin tener que estar todo
el tiempo escribiendo esas lineas de codigo*/
package clases;

//Sebas
import config.ConfigLoader;
import java.sql.*;
//---

public class ConexiónDB {
    //Conexión Local
    public static Connection conectar(){
        try{
            String host = ConfigLoader.get("db.host");
            String user = ConfigLoader.get("db.user");
            String password = ConfigLoader.get("db.password");

            Connection cn = DriverManager.getConnection("jdbc:mysql://"+ host + "/agrop", user, password);
            return cn;
            
        }
        catch(SQLException e){   
            System.out.println("Error en conexión local" + e);
        }
        return (null);
    }
}