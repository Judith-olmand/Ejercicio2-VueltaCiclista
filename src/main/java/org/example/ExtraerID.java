package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExtraerID {
    public static int IDCiclistaMaximo(Connection conexion){
        try (Statement st = conexion.createStatement()){
            String consultaIDCiclista = "SELECT MAX(ID_CICLISTA) FROM CICLISTA";
            ResultSet rs1 = st.executeQuery(consultaIDCiclista);
            rs1.next();
            return rs1.getInt(1);
        } catch (Exception e){
            System.out.println("Error para obtener el id del ciclista.");
            return 0;
        }
    }

    /**
     * Comprueba que no haya ningún id entre medias vacío, por si se elimina a algún
     * ciclista del medio, volver a ocupar ese id
     */
    public static int idEntreMedias(Connection conexion){
        int idMaximo = ExtraerID.IDCiclistaMaximo(conexion);
        try (Statement st = conexion.createStatement()){
            String consultaIDCiclista = "SELECT ID_CICLISTA FROM CICLISTA ORDER BY ID_CICLISTA ASC";
            ResultSet rs = st.executeQuery(consultaIDCiclista);
            int i = 1;
            while (i <= idMaximo){
                while (rs.next()){
                    int idActual = rs.getInt(1);
                    if(idActual != i){
                        return i;
                    }
                    i++;
                }
            }
        } catch (Exception e){
            System.out.println("Error para obtener el id del ciclista" + e.getMessage());
        }
        return idMaximo + 1;
    }
}
