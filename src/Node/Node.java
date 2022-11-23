package Node;

public class Node {

    private String key;
    private String value;
    private String port;
    private int fc; // frequency counter

    private Node next;
    private Node prev;

    public Node(String key, String value, Node next, Node prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.next = prev;
        this.fc = 0;
    }

    public Node(String key, String value, String port) {
        this.key = key;
        this.value = value;
        this.port = port;
        this.next = null;
        this.prev = null;
        this.fc = 0;
    }

    // construtor para teste do contador de frequencia
    public Node(String key, String value, int fc) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
        this.fc = fc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node [key=" + key + ", value=" + value + ", fc=" + fc + "]";
    }

}
