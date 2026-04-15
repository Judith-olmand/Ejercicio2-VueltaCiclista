package org.example;

import java.sql.*;
import java.util.Scanner;

public class Mostrar {
    public static void mostrarCiclistas(Connection conexion){
        try (Statement statement = conexion.createStatement()){
            String query = "SELECT ID_CICLISTA, CICLISTA.NOMBRE AS NOM_CICLISTA, " +
                    "NACIONALIDAD, EDAD, EQUIPO.NOMBRE AS NOM_EQUIPO " +
                    "FROM CICLISTA JOIN EQUIPO USING(ID_EQUIPO)" +
                    "ORDER BY ID_CICLISTA";
            ResultSet rs = statement.executeQuery(query);
            MostrarPorPantalla(rs);
        } catch (Exception e) {
            System.out.println("Error al mostrar los ciclistas");
        }
    }

    public static void mostrarCiclistasEqupoPais(Connection conexion, Scanner sc){
        String query = "SELECT ID_CICLISTA, CICLISTA.NOMBRE AS NOM_CICLISTA, " +
                "NACIONALIDAD, EDAD, EQUIPO.NOMBRE AS NOM_EQUIPO " +
                "FROM CICLISTA JOIN EQUIPO USING(ID_EQUIPO) " +
                "WHERE PAIS LIKE ? " +
                "ORDER BY ID_CICLISTA";
        try (PreparedStatement ps = conexion.prepareStatement(query)){
            System.out.println("Indica el pais.");
            String pais = sc.nextLine();
            ps.setString(1,pais);
            ResultSet rs = ps.executeQuery();
            MostrarPorPantalla(rs);
        } catch (Exception e) {
            System.out.println("Error al mostrar los ciclistas");
        }
    }

    private static void MostrarPorPantalla(ResultSet rs) throws SQLException {
        while (rs.next()){
            int idCiclista = rs.getInt("ID_CICLISTA");
            String nombreCiclista = rs.getString("NOM_CICLISTA");
            String nacionalidad = rs.getString("NACIONALIDAD");
            int edad = rs.getInt("EDAD");
            String equipo = rs.getString("NOM_EQUIPO");
            System.out.println(idCiclista + " - " +  nombreCiclista + " - " + nacionalidad + " - " + edad + " - " + equipo);
        }
    }
}
