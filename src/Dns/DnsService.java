package Dns;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Node.Node;
import TableHash.TableHash;

public class DnsService {

    private TableHash tableHash;
    static Scanner fileLine;

    public void run(int sizeTable) throws FileNotFoundException {

        File file = new File("src/ips.txt");

        fileLine = new Scanner(file);

        tableHash = new TableHash(sizeTable);
        int countTimeAll = 0;

        // inserir os 25 endereços iniciais
        insertFile();
        tableHash.imprimir();

        while (countTimeAll <= 30) {

            try {
                Thread.sleep(10000);
                countTimeAll += 10;
                if (fileLine.hasNextLine()) {
                    insertFile();

                    System.out.println("Passou 10 segundos foi inserido 25 sites");
                    tableHash.imprimir();

                } else {
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void insertFile() {

        for (int i = 0; i < 25; i++) {
            if (fileLine.hasNextLine()) {
                String[] line = fileLine.nextLine().split(";");
                tableHash.insert(line[0], line[1], line[2]);
            }
        }

    }

    public void insertTable(String key, String ip, String port) {

        if (key.charAt(0) == 'w' && key.charAt(1) == 'w' && key.charAt(2) == 'w' && key.charAt(3) == '.') {
            tableHash.insert(key, ip, port);

        } else {
            System.out.println();
            System.out.println("Esse site é invalido precisa ter o WWW.");
            System.out.println();

        }

    }

    public void searchTable(String key) {

        if (key.charAt(0) == 'w' && key.charAt(1) == 'w' && key.charAt(2) == 'w' && key.charAt(3) == '.') {

            Node currente = tableHash.search(key);

            if (currente == null) {

                System.out.println();
                System.out.println("Não foi encontrado");
                System.out.println();

            } else {

                System.out.println();
                System.out.println("foi encontrado... site: " + currente.getKey() + " ip: " + currente.getValue()
                        + " port: " + currente.getPort());
                System.out.println();

            }

        } else {
            System.out.println();
            System.out.println("Esse site não exite");
            System.out.println();
        }

    }

    public void removeTable(String key) {

        if (key.charAt(0) == 'w' && key.charAt(1) == 'w' && key.charAt(2) == 'w' && key.charAt(3) == '.') {
            Node currente = tableHash.remove(key);
            if (currente == null) {
                System.out.println();
                System.out.println("Não foi encontrado");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("foi removido... site: " + currente.getKey() + " ip: " + currente.getValue()
                        + " port: " + currente.getPort());
                System.out.println();
            }

        } else {
            System.out.println();
            System.out.println("Esse site não exite");
            System.out.println();
        }

    }

    public void imprimir() {
        tableHash.imprimir();
    }

    public TableHash getTableHash() {
        return tableHash;
    }

    public void setTableHash(TableHash tableHash) {
        this.tableHash = tableHash;
    }

}
