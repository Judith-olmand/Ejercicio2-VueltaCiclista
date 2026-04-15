package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Eliminar {
    public static void eliminarCiclista(Connection conexion, int idCiclista){
        boolean idCicExiste = Comprobador.comprobarCiclista(idCiclista, conexion);
        if (idCicExiste){
            try (PreparedStatement ps = conexion.prepareStatement("DELETE FROM ciclista WHERE id_ciclista = ?");
            PreparedStatement ps2 = conexion.prepareStatement("DELETE FROM participacion WHERE id_ciclista = ?")) {
                ps2.setInt(1, idCiclista);
                ps2.executeUpdate();
                ps.setInt(1, idCiclista);
                ps.executeUpdate();
                System.out.println("Ciclista eliminado con éxito");
            } catch (Exception e){
                System.out.println("Error al eliminar el ciclista");
            }
        }
    }
}
