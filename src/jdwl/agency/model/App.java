package jdwl.agency.model;


import java.util.Scanner;

import static Tables.Cliente.usuarios;
import static Tables.Destino.viagem;

public class App {


        public static void main(String[] args) {
              telaPrincipal();
        }

        public static void telaPrincipal() {

            System.out.println("Opção 1: Usuário ");
            System.out.println("Opção 2: Viagem ");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    usuarios();
                    break;
                case 2:
                    viagem();
                    break;
                default:
                    System.out.print("Opção inválida. Tente novamente. \n");
                    telaPrincipal();
                    break;

            }
        }
}
