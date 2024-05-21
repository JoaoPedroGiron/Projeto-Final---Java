package jdwl.agency.model;

import Data.DbContext;

import java.sql.ResultSet;
import java.util.Scanner;

import static Tables.Cliente.usuarios;

public class QueryCliente {


    public static void cadastrarClientes() {

        Scanner scanner = new Scanner(System.in);


        System.out.println("\n Informe o seu nome: ");
        String usuario = scanner.next();

        System.out.print("\n Informe seu email: ");
        String Email = scanner.next();

        System.out.print("\n Informe seu CPF: ");
        String CPF = scanner.next();


        DbContext database = new DbContext();


        try {
            database.conectarBanco();

            boolean statusQuery = database.executarUpdateSql("INSERT INTO usuarios(nome, email, cpf) VALUES ('" + usuario + "', '" + Email + "', '" + CPF + "')");

            if (statusQuery) {
                mensagemStatus("Usuário cadastrado com sucesso!");
            }
            database.desconectarBanco();

            usuarios();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        scanner.close();

    }

    public static void listarClientes() {

        DbContext database = new DbContext();

        try {
            database.conectarBanco();

            ResultSet resultadoConsulta = database.executarQuerySql("SELECT * FROM usuarios");

            while (resultadoConsulta.next()) {
                System.out.println("Cliente - " + resultadoConsulta.getString("nome"));
            }

            database.desconectarBanco();

            usuarios();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void atualizarClientes() {

        System.out.print("\n Informe o CPF do cliente a ser atualizado:  ");

        Scanner scanner = new Scanner(System.in);

                String cpfCliente = scanner.next();
                String novoCliente = "";

                System.out.print("\n Informe o novo nome do cliente a ser atualizado: ");


                if (scanner.hasNext()) {

                    novoCliente = scanner.next();

                    DbContext database = new DbContext();

                    try {
                        database.conectarBanco();

                        boolean statusQuery = database.executarUpdateSql("UPDATE usuarios SET nome = '" + novoCliente + "'  WHERE cpf = '" +cpfCliente + "'");

                        if (statusQuery) {
                            mensagemStatus("Cliente atualizado com sucesso!");
                        }

                        database.desconectarBanco();

                        usuarios();

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            scanner.close();
        }

    public static void deletarCliente() {

        System.out.println("\n Informe o CPF do cliente a ser deletado: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {

            String cpfCliente = scanner.next();

            DbContext database = new DbContext();

            try {
                database.conectarBanco();

                boolean statusQuery = database.executarUpdateSql("DELETE FROM usuarios WHERE cpf = '" + cpfCliente + "'" );

                if (statusQuery) {
                    mensagemStatus("Cliente deletado com sucesso!");
                }

                database.desconectarBanco();

                usuarios();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        scanner.close();

    }



    public static void mensagemStatus(String mensagem) {
        System.out.print("\n");
        System.out.print("\n " + mensagem + "\uD83C\uDD65 \n");
        System.out.print("\n");
    }
}
