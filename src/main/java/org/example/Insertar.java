package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertar {
    public static void inseertarCiclista(Connection conexion, Scanner sc, int idEquipo){
        boolean idEqExiste = Comprobador.comprobarEquipo(idEquipo,conexion);
        if (idEqExiste){
            //int idCiclista = ExtraerID.extraerIDCiclista(conexion);
            int idCiclista = ExtraerID.idEntreMedias(conexion);


            System.out.println("Indique el nombre del ciclista.");
            String nomCiclista = sc.nextLine();
            System.out.println("Indique la nacionalidad del ciclista.");
            String nacionalidad = sc.nextLine();
            System.out.println("Indique la edad del ciclista.");
            int edad = sc.nextInt();
            sc.nextLine();

            try {
                String insert = "INSERT INTO CICLISTA (id_ciclista, nombre, " +
                        "nacionalidad, edad, id_equipo) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps2 = conexion.prepareStatement(insert);

                ps2.setInt(1, idCiclista);
                ps2.setString(2, nomCiclista);
                ps2.setString(3, nacionalidad);
                ps2.setInt(4, edad);
                ps2.setInt(5, idEquipo);
                ps2.executeUpdate();
                System.out.println("Ciclista añadido correctamente");
                System.out.println("* ID ciclista: " + idCiclista);
                System.out.println("* Nombre del ciclista: " + nomCiclista);
                System.out.println("* Nacionalidad del ciclista: " + nacionalidad);
                System.out.println("* Edad del ciclista: " + edad);
                System.out.println("* ID equipo: " + idEquipo);

            } catch (Exception e) {
                System.out.println("Error al insertar un nuevo ciclista. " + e.getMessage());
            }
        }
    }
}
