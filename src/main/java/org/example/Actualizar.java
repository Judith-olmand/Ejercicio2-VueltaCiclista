package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Actualizar {
    public static void actualizarEquipoCiclista(Connection conexion, Scanner sc, int  idCiclista){
        //
        System.out.println("Indique el nuevo id del equipo del ciclista.");
        int idEquipo = sc.nextInt();
        sc.nextLine();
        boolean idEqExite = Comprobador.comprobarEquipo(idEquipo, conexion);
        if (idEqExite) {
            String actualizar = "UPDATE ciclista SET id_equipo=? WHERE id_ciclista=?";
            try (PreparedStatement ps = conexion.prepareStatement(actualizar)) {
                ps.setInt(1,idEquipo);
                ps.setInt(2,idCiclista);
                ps.executeUpdate();
                System.out.println("Ciclista actualizado correctamente");
                System.out.println("Nuevos datos del ciclista:");
                System.out.println("* ID ciclista: " + idCiclista);
                System.out.println("* Nuevo equipo: " + idEquipo);
            } catch (Exception e){
                System.out.println("Error al actualizar el id del equipo");
            }
        }
    }

    public static void actualizarEdadCiclista(Connection conexion, Scanner sc, int  idCiclista){
        System.out.println("Indique la nueva edad del ciclista.");
        int edad = sc.nextInt();
        sc.nextLine();
        if (edad < 18 || edad > 65) {
            System.out.println("La edad ha de estar entre 18 y 65.");
        } else {
            String actualizar = "UPDATE ciclista SET edad=? WHERE id_ciclista=?";
            try (PreparedStatement ps = conexion.prepareStatement(actualizar)) {
                ps.setInt(1,edad);
                ps.setInt(2,idCiclista);
                ps.executeUpdate();
                System.out.println("Ciclista actualizado correctamente");
                System.out.println("Nuevos datos del ciclista:");
                System.out.println("* ID ciclista: " + idCiclista);
                System.out.println("* Nueva edad: " + edad);

            } catch (Exception e){
                System.out.println("Error al actualizar la edad del ciclista");
            }
        }
    }
}
