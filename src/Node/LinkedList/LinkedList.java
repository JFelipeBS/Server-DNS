package Node.LinkedList;

import Node.Node;

public class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
    }

    public void insert(String key, String value,String port) {

        Node newNode = new Node(key, value, port);

        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {

            Node current = head;

            // atualizar chave repetida
            while (current != null) {

                if (current.getKey().equals(key)) {

                    System.out.println();
                    System.out.print("Atualização:");
                    current.setValue(value);
                    break;
                }
                current = current.getNext();
            }

            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

    }

    public Node removeFirst() {

        Node returnElement = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");

        } else {

            Node point = head;
            returnElement = point;

            // unico elemento na lista
            if (head.getNext() == null) {
                head = null;
                tail = null;
                return returnElement;
            }

            // mais de um elemento na lista
            head = head.getNext();
            head.setPrev(null);

            // isolar elemento

            point.setPrev(null);

        }

        return returnElement;
    }

    public Node removeLast() {

        Node returnElement = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return returnElement;
        } else {

            returnElement = tail;

            // unico elemento na lista
            if (tail.getPrev() == null) {
                head = null;
                tail = null;
            }

            Node prevCurrent = tail.getPrev();

            tail.setPrev(null);
            tail = prevCurrent;
            tail.setNext(null);

        }

        return returnElement;
    }

    public Node remove(String key) {

        Node elemente = null;

        if (head == null) {
            System.out.println("Null: Lista Vazia");
            return elemente;
        }
        Node retorno = searchRemove(key);
        Node antecessor = null;

        // evital um nullpoint
        if (retorno != null) {
            antecessor = retorno.getPrev();
        }

        // removendo do inicio
        if (antecessor == null) {

            if (head.getKey().equals(key) == false) {
                System.out.println("Null: Item nao existe");
            } else {
                return removeFirst();
            }

        } else {

            // removendo do final
            if (retorno == tail) {

                return removeLast();

            } else {

                // removendo do meio
                Node frente = retorno.getNext();

                antecessor.setNext(frente);
                frente.setPrev(antecessor);

                retorno.setNext(null);
                retorno.setPrev(null);

                elemente = retorno;

                return elemente;

            }
        }
        return elemente;

    }

    public Node searchRemove(String key) {

        Node current = head;

        while (current != null) {

            if (current.getKey().equals(key)) {
                return current;
            }

            current = current.getNext();

        }

        return null;
    }

    public Node search(String key) {

        Node current = head;

        while (current != null) {

            if (current.getKey().equals(key)) {

                current.setFc(current.getFc() + 1);
                frequencyCounter(current);
                return current;

            }

            current = current.getNext();

        }

        return null;
    }

    public void frequencyCounter(Node current) {

        while (current != null) {

            if (current.getPrev() == null) { // chegou nom final da lista
                break;
            }

            if (current.getFc() > current.getPrev().getFc()) {

                if (current.getNext() == null) { // final da lista

                    Node tempPrevPrev = current.getPrev().getPrev();
                    Node tempPrev = current.getPrev();
                    Node tempNext = current.getNext();

                    current.setNext(tempPrev);
                    current.setPrev(tempPrevPrev);

                    tempPrev.setPrev(current);
                    tempPrev.setNext(tempNext);
                    tail = tempPrev;

                    // evitar erros de nos nulos
                    if (tempPrevPrev != null) {
                        tempPrevPrev.setNext(current);
                    }

                    if (current.getPrev() == null) {
                        head = current;
                    }

                } else {

                    Node tempNext = current.getNext();
                    Node tempPrev = current.getPrev();

                    current.setNext(tempPrev);
                    current.setPrev(tempPrev.getPrev());

                    tempPrev.setPrev(current);
                    tempPrev.setNext(tempNext);

                    tempNext.setPrev(current.getNext());

                    // evitar erros de nos nulos
                    if (current.getPrev() != null) {
                        current.getPrev().setNext(current);
                    }

                    if (current.getPrev() == null) {
                        head = current;
                    }

                }

            } else {
                current = current.getPrev();
                break;
            }
        }

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

}
