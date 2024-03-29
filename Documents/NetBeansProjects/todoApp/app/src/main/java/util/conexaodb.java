/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaodb {
        
        public static final String DRIVER = "com.mysql.jdbc.Driver";
        public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
        public static final String USER = "root";
        public static final String PASS = "";
        
        public static Connection getConnection(){
            try{
                
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na conexao com Banco de Dados");
            }
        }
        
        public static void closeConnection (Connection connection) {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexao com Banco de Dados");
        }
        }
}
