package TableHash;

import Node.Node;
import Node.LinkedList.LinkedList;

public class TableHash {

    private int m;
    private int numItens;
    private LinkedList table[];

    public TableHash(int sizeTable) {

        this.m = sizeTable;
        this.numItens = 0;
        table = new LinkedList[m];

    }

    // ================================================

    public int hash(String str) {
        int h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = (31 * h + str.charAt(i)) % m;
        }
        return h;
    }
    // ================================================
    // Alterar tamanho da tabelaHash

    public void resizable() {
        LinkedList temp[] = table.clone();

        while (factorCharge() > 5) {
            m++;
        }

        Node current = null;
        table = new LinkedList[m];
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] != null) {
                current = temp[i].getHead();

            }

            while (current != null) {

                insertRes(current.getKey(), current.getValue(), current.getPort());

                current = current.getNext();
            }

        }

    }

    public float factorCharge() {
        return numItens / m;
    }

    // Inserção no final da lista
    public void insert(String key, String value, String port) {

        int keyReceived = hash(key);
        if (table[keyReceived] == null) {
            table[keyReceived] = new LinkedList();
        }

        table[keyReceived].insert(key, value, port);

        System.out.println();
        System.out.println("Site: " + key + " ip: " + value + " port: " + port + " inserido no indice " + keyReceived);
        System.out.println();


        this.numItens++;

        if (factorCharge() > 10) {
            resizable();
        }

    }

    public void insertRes(String key, String value, String port) {

        int keyReceived = hash(key);
        if (table[keyReceived] == null) {
            table[keyReceived] = new LinkedList();
        }

        table[keyReceived].insert(key, value, port);

    }

    public Node remove(String key) {
        int keyReceived = hash(key);
        return table[keyReceived].remove(key);
    }

    public Node search(String key) {
        int keyReceived = hash(key);

        if (table[keyReceived] == null) {
            return null;

        } else {
            return table[keyReceived].search(key);
        }

    }

    public void imprimir() {

        LinkedList list;
        Node node;

        for (int i = 0; i < m; i++) {
            list = table[i];
            if (list == null) {
                node = null;
            } else {
                node = list.getHead();
            }

            System.out.print(i);

            while (node != null) {
                System.out.println(" : Chave: " + node.getKey() + " ip: " + node.getValue() + " port: " + node.getPort()
                        + " fc: " + node.getFc());
                node = node.getNext();
            }

            System.out.println();

        }
    }

}
