package Tables;

import java.util.Scanner;

import static jdwl.agency.model.QueryViagem.*;

public class Destino {

    public static void viagem() {
            System.out.println("\nProcure por sua viagem: \n");


            listarHotelPorDestinos();

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nDigite o ID do hotel desejado acima: \n");
            int idHotel = scanner.nextInt();

            listarCompanhiasAereas();

            System.out.print("\nDigite o ID da passagem desejada acima : ");
            int idPassagem = scanner.nextInt();

            printViagem(idHotel, idPassagem);

    }
}
