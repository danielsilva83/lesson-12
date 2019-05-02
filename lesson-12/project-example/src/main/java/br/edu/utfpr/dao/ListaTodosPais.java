/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.dto.PaisDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public abstract class ListaTodosPais extends PaisDAO{
     
    
    @Override
    public  List<PaisDTO> ListaTodosPais() {
        List<PaisDTO> resultado;
        resultado = new ArrayList<>();

        try ( Connection conn = DriverManager.getConnection("jdbc:derby:memory:database")) {

            String sql = "SELECT * FROM pais";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

      

            while (result.next()) {

                resultado.add(
                        PaisDTO.builder()
                                .codigoTelefone(result.getInt("codigoTelefone"))
                                .id(result.getInt("id"))
                                .nome(result.getString("nome"))
                                .sigla(result.getString("sigla"))
                                .build()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

  
}

    