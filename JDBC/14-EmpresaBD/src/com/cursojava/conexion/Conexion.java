package com.cursojava.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	 public static String url = "jdbc:mysql://localhost:3306/EmpresaBD";
	    public static String username = "root";
	    public static String password = "root";
	    public static Connection conn = null;

	    public static Connection conectarMySQL() {
	        try {
	            conn = DriverManager.getConnection(url, username, password);
	        } catch (SQLException e) {
	            System.out.println("[!] Error al conectarse a la base de datos");
	        }
	        return conn;
	    }
}
