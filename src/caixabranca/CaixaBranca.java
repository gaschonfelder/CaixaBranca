/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caixabranca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CaixaBranca {

    /**
     * Método responsável por realizar a conexão com um banco de dados MySQL.
     *
     * @return Uma conexão com o banco de dados.
     */
    public Connection conectarBD() {
        // Etapa 0
        Connection conn = null;

        // Etapa 2
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {}

        // Etapa 5
        return conn;
    }

    /**
     * Método responsável por verificar a existência de um usuário.
     *
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return `true` se o usuário foi encontrado, `false` caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        // Etapa 9
        String sql = "";

        // Etapa 10
        try {
            Connection conn = conectarBD();

            //INSTRUÇÃO SQL
            sql += "select nome from usuarios ";
            sql += "where login = '" + login + "'";
            sql += " and senha = '" + senha + "';";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                // Etapa 15
                result = true;
                // Etapa 16
                nome = rs.getString("nome");
            }
        } catch (Exception e) {}

        // Etapa 13 e 14
        return result;
    }

    /**
     * Variável do tipo `Connection` que representa a conexão com o banco de dados.
     */
    private Connection conn;

    /**
     * Variável do tipo `String` que armazena o nome do usuário encontrado.
     */
    private String nome;

    /**
     * Variável do tipo `boolean` que indica se o usuário foi encontrado.
     */
    private boolean result;
}
    

