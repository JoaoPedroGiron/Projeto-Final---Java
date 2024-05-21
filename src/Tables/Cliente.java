package Tables;

import java.util.Scanner;

import static jdwl.agency.model.App.telaPrincipal;
import static jdwl.agency.model.QueryCliente.*;

public class Cliente {


    public static void usuarios() {
        Scanner scanner = new Scanner(System.in);

            System.out.print("\nOpção 1: Cadastrar usuário ");
            System.out.print("\nOpção 2: Listar usuários ");
            System.out.print("\nOpção 3: Atualizar usuários ");
            System.out.print("\nOpção 4: Deletar usuário ");
            System.out.print("\nOpção 5: Menu principal  \n" );
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarClientes();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarClientes();
                    break;
                case 4:
                    deletarCliente();
                    break;
                case 5:
                    telaPrincipal();
                    break;
                default:
                    System.out.print("Opção inválida. Tente novamente. \n");
                    usuarios();
                    break;
            }


    }



}
