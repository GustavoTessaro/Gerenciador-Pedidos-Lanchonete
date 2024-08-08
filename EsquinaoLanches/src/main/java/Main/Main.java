
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controller.Controller;
import View.Janela;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Classe principal responsável por iniciar a aplicação TarefaAvaliativaMaven.
 */
public class Main {

    public static Controller controller;
    
    /**
     * Método principal que inicia a aplicação.
     * @param args os argumentos da linha de comando (não são utilizados neste caso)
     */
    public static void main(String[] args) {
        
        controller = new Controller(); 
        controller.start();
        
    }  
}
