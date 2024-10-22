package com.cursojava.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cursojava.modelo.Empleado;

public class EmpleadoDAO {
	
	//Querys
	private String selectEmpleados = "SELECT * FROM empleados";
	private String selectEmpleadoApellido = "SELECT * FROM empleados WHERE apellido1 = ?";
	private String selectEmpleadoId= "SELECT * FROM empleados WHERE id = ?";
	private String insertEmpleado = "INSERT INTO empleados (nombre, apellido1, apellido2, fecha_nacimiento, salario) VALUES (?, ?, ?, ?, ?)";
	private String updateEmpleado = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, fecha_nacimiento = ?, salario = ? WHERE id = ?";
	private String deleteEmpleado = "DELETE FROM empleados WHERE id = ?";
	
	//Conexion que se pasa al instanciar la clase
	private Connection conexion;
	
	
	//Constructor
	public EmpleadoDAO(Connection conex) {
		this.conexion = conex; 
	}
	/**
	 * el metodo selectEmpleados hace una query de tipo select * a la base de datos que devuelve un resultset 
	 * Recoge los resultados obtenidos y los parsea a objetos empleado con los que es mas facil trabajar. 
	 * @return Una arraylist con los empleados encontrados
	 */
	public ArrayList<Empleado> selectEmpleados() {
        Empleado empleado= null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(selectEmpleados)) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                Double salario = rs.getDouble("salario");
                empleado = new Empleado(id , nombre, apellido1 , apellido2, fechaNacimiento, salario);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return empleados;
    }
	/**
	 * Busca los empleados por el apellido en la base de datos. 
	 * @param apellido a buscar
	 * @return una arraylist de empleados. Generalmente los apellidos no coincidiran pero como pueden hacerlo los imprime todos.
	 */
	public ArrayList<Empleado> selectEmpleadoPorApellido(String apellido) {
        Empleado empleado= null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(selectEmpleadoApellido)) {
            ps.setString(1, apellido);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                Double salario = rs.getDouble("salario");
                empleado = new Empleado(id , nombre, apellido1 , apellido2, fechaNacimiento, salario);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return empleados;
    }
	/**
	 * El metodo selectEmpleadoPorId busca un empleado por su id en la base de datos. Esto es util ya que el id es unico de cada empleado
	 * Dada las especificaciones del proyecto el usuario no usa este metodo. Es un metodo interno que utilizan algunos otros metodos para funcionar correctamente
	 * @param idBuscar: El id a buscar en la base de datos
	 * @return El empleado encontrado
	 */
	public Empleado selectEmpleadoPorId(int idBuscar) {
        Empleado empleado= null;
        
        try (PreparedStatement ps = conexion.prepareStatement(selectEmpleadoId)) {
            ps.setInt(1, idBuscar);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id= rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                Date fechaNacimiento = rs.getDate("fecha_nacimiento");
                Double salario = rs.getDouble("salario");
                empleado = new Empleado(id , nombre, apellido1 , apellido2, fechaNacimiento, salario);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return empleado;
    }
	/**
	 * El metodo insertar Empleado Introduce un emplado en la base de datos
	 * No hace ninguna comprobacion porque para cuando llega aqui ya todos los datos han sido comprobados
	 * @param empleado a insertar
	 */
	public void insertarEmpleado(Empleado empleado) {
        try (PreparedStatement ps = conexion.prepareStatement(insertEmpleado)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setDate(4, empleado.getFechaNacimiento());
            ps.setDouble(5, empleado.getSalario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza un empleado existente en la base de datos
     * @param empleado con los datos actualizados (Debe compartir id con el original)
     */
    public void actualizarEmpleado (Empleado empleado) {
        try (PreparedStatement ps = conexion.prepareStatement(updateEmpleado)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setDate(4, empleado.getFechaNacimiento());
            ps.setDouble(5, empleado.getSalario());
            ps.setInt(6, empleado.getId());
            ps.executeUpdate();
  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un empleado de la base de datos
     * @param El empleado que queremos eliminar
     */
    public void eliminarEmpleado(Empleado empleadoAEliminar) {
        try (PreparedStatement ps = conexion.prepareStatement(deleteEmpleado)) {
            ps.setInt(1, empleadoAEliminar.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
