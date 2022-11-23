package Dns;

import java.util.Random;
import java.util.Scanner;

public class DnsClinte {

    static Scanner scanner = new Scanner(System.in);

    public void run(DnsService servi) {

        DnsService service = servi;

        System.out.println("=================================================");
        System.out.println("++++++++++++++++++ Observação +++++++++++++++++++");
        System.out.println("=================================================");
        System.out.println("o: sites  validos precisão começar com www \n\n");

        boolean requeste = true;

        while (requeste != false) {
            System.out.println("=================================================");
            System.out.println("+++++++++++++++++++ Cliente +++++++++++++++++++++");
            System.out.println("=================================================");

            System.out.println("Escolha a oção desejada: ");
            System.out.println("        |1| para inserir.");
            System.out.println("        |2| para remover.");
            System.out.println("        |3| para buscar.");
            System.out.println("        |4| para imprimir.");
            System.out.println("        |5| Limpar console.");
            System.out.println("        |6| para sair.");
            System.out.print("Escolha: ");

            int option = scanner.nextInt();

            String key;
            String ip;
            String port;

            switch (option) {
                case 1:

                    System.out.print("Digite o endereço de um site: ");
                    key = scanner.next();
                    ip = generetorIp();
                    port = generetorPort();
                    service.insertTable(key, ip, port);

                    break;
                case 2:

                    System.out.print("Digite o endereço de um site: ");
                    key = scanner.next();
                    service.removeTable(key);

                    break;
                case 3:
                    System.out.print("Digite o endereço de um site: ");
                    key = scanner.next();
                    service.searchTable(key);

                    break;

                case 4:

                    service.imprimir();
                    break;

                case 5:
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    break;
                case 6:
                    requeste = false;

                    break;

                default:
                    requeste = false;

                    break;
            }

        }

    }

    public String generetorIp() {

        int o1 = new Random().nextInt(256);
        int o2 = new Random().nextInt(256);
        int o3 = new Random().nextInt(256);
        int o4 = new Random().nextInt(256);

        return o1 + "." + o2 + "." + o3 + "." + o4;

    }

    public String generetorPort() {

        int p = new Random().nextInt(9999);
        String port = String.valueOf(p);

        return port;

    }

}
