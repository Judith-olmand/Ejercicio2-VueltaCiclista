package org.example;

import oracle.net.jdbc.TNSAddress.SOException;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idCiclista;
        int idEquipo;
        int opcion = -1;
        int opcion2 = -1;

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())){

            do {
                System.out.println("Elija una opción:");
                System.out.println("1. Añadir un nuevo ciclista.");
                System.out.println("2. Actualizar un ciclista.");
                System.out.println("3. Eliminar un ciclista.");
                System.out.println("4. Mostrar todos los ciclistas.");
                System.out.println("5. Mostrar todos los ciclistas del equipo de un pais concreto.");
                System.out.println("0. Salir.");
                try {
                    opcion = sc.nextInt();
                    sc.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("La opción ha de ser un número.");
                    sc.nextLine();
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Indique el id del equipo del nuevo ciclista.");
                        idEquipo = sc.nextInt();
                        sc.nextLine();
                        Insertar.inseertarCiclista(conn,sc,idEquipo);
                        break;

                    case 2:
                        System.out.println("Indique el id del ciclista a modificar.");
                        idCiclista = sc.nextInt();
                        sc.nextLine();
                        boolean idCicExixste = Comprobador.comprobarCiclista(idCiclista,conn);
                        if (idCicExixste) {
                            System.out.println("¿Que campo desea actualizar?");
                            System.out.println("1. ID del equipo");
                            System.out.println("2. Edad");
                            try {
                                opcion2 = sc.nextInt();
                                sc.nextLine();
                            }catch (InputMismatchException e){
                                System.out.println("La opción ha de ser un número.");
                                sc.nextLine();
                            }

                            switch (opcion2) {
                                case 1:
                                    Actualizar.actualizarEquipoCiclista(conn,sc, idCiclista);
                                    break;
                                case 2:
                                    Actualizar.actualizarEdadCiclista(conn,sc, idCiclista);
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }
                        } else {
                            System.out.println("El id del ciclista no existe");
                        }
                        break;

                    case 3:
                        System.out.println("Indique el id del ciclista");
                        idCiclista = sc.nextInt();
                        sc.nextLine();
                        Eliminar.eliminarCiclista(conn, idCiclista);
                        break;

                    case 4:
                        Mostrar.mostrarCiclistas(conn);
                        break;

                    case 5:
                        Mostrar.mostrarCiclistasEqupoPais(conn,sc);
                        break;

                    case 0:
                        System.out.println("Hasta pronto!!");
                        break;

                    default:
                        System.out.println("Opción no válida");
                        System.out.println();
                        break;
                }
            }while (opcion != 0);
        } catch (SQLException e1) {
            System.out.println("Error al conectar: " + e1.getMessage());
        }
    }
}