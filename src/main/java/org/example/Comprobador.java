package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Comprobador {
    public static boolean comprobarEquipo(int idEquipo, Connection conexion){
        String compobarIdEquipo = "SELECT ID_EQUIPO FROM EQUIPO WHERE ID_EQUIPO = ?";
        try (PreparedStatement ps = conexion.prepareStatement(compobarIdEquipo)){
            ps.setInt(1, idEquipo);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                System.out.println("El id del equipo existe");
                return true;
            } else  {
                System.out.println("El id del equipo no existe");
                return false;
            }
        } catch (Exception e){
            System.out.println("Error al obtener el id del equipo");
            return false;
        }
    }

    public static boolean comprobarCiclista(int idCiclista, Connection conexion){
        String compobarIdCiclista = "SELECT ID_CICLISTA FROM CICLISTA WHERE ID_CICLISTA = ?";
        try (PreparedStatement ps = conexion.prepareStatement(compobarIdCiclista)){
            ps.setInt(1, idCiclista);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                System.out.println("El id del ciclista existe");
                return true;
            } else  {
                System.out.println("El id del ciclista no existe");
                return false;
            }
        } catch (Exception e){
            System.out.println("Error al obtener el id del equipo");
            return false;
        }
    }
}
