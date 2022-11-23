import java.io.FileNotFoundException;


import Dns.DnsClinte;
import Dns.DnsService;

public class start {
    public static void main(String[] args) throws FileNotFoundException {

        DnsClinte clinte = new DnsClinte();
        DnsService service = new DnsService();
        service.run(1);
        clinte.run(service);

    }
}
