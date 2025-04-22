package Programa;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/

public class Main{
  public static void main(String[] args){
    //Main main = new Main();
    //main.createConnection();
    
    new MainFrame();
  }

  /*private void createConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vca_utilidades","root","root");
    
      System.out.println("Conectado");
    } 
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (SQLException e){
      e.printStackTrace();
    }
  } */
}