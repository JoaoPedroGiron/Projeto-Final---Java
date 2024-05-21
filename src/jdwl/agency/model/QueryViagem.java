package jdwl.agency.model;

import Data.DbContext;


import java.sql.ResultSet;
import java.sql.SQLException;


public class QueryViagem {


    public static void listarHotelPorDestinos() {


        DbContext database = new DbContext();

        String sql = "SELECT * FROM hoteis ";

        try {
            database.conectarBanco();

            ResultSet resultadoConsulta = database.executarQuerySql(sql);


            while (resultadoConsulta.next()) {
                int id = resultadoConsulta.getInt("ID_hotel");
                String Nome = resultadoConsulta.getString("NomeHotel");
                String informacao = resultadoConsulta.getString("Endereco");
                String Preco = resultadoConsulta.getString("PrecosPorNoite");

                System.out.println("ID:" + id + " ---- Nome hotel: " + Nome +  " ---- Endereço: " + informacao + " ---- Preço: R$" + Preco);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar destinos: " + e.getMessage());
        }
    }

    public static void listarCompanhiasAereas() {


        DbContext database = new DbContext();

        String sql = "SELECT * FROM companhiasaereas ";

        try {
            database.conectarBanco();

            ResultSet resultadoConsulta = database.executarQuerySql(sql);


            while (resultadoConsulta.next()) {
                int id = resultadoConsulta.getInt("ID_companhia");
                String Nome = resultadoConsulta.getString("NomeCompanhia");
                String rotas = resultadoConsulta.getString("RotasOperadas");

                System.out.println("ID:" + id + " ---- Nome companhia: " + Nome +  " ---- Rotas operadas: " + rotas);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar destinos: " + e.getMessage());
        }
    }

    public static void printViagem(int idHotel, int idPassagem) {
        DbContext database = new DbContext();

        String sqlHotel = "SELECT * FROM hoteis WHERE ID_hotel = '" + idHotel + "'";
        String sqlCompanhia = "SELECT * FROM companhiasaereas WHERE ID_companhia = '" +idPassagem+ "'";

        try {
            database.conectarBanco();

            ResultSet resultadoHotel = database.executarQuerySql(sqlHotel);
            ResultSet resultadoCompanhia = database.executarQuerySql(sqlCompanhia);

            while (resultadoHotel.next()) {
                String Nome = resultadoHotel.getString("NomeHotel");

                String NomeCompanhia = null;
                while (resultadoCompanhia.next()) {
                    NomeCompanhia = resultadoCompanhia.getString("NomeCompanhia");
                }

                System.out.println("\n========== PACOTE CADASTRADO ========== \n");
                System.out.println("O seu pacote com destino, ao " + Nome + "  e sua passagem com  a " + NomeCompanhia +", foram  adicionados ao pacote! Boa Viagem");


            }

        } catch (SQLException e) {
        System.err.println("Erro ao listar destinos: " + e.getMessage());
    }
    }


}




