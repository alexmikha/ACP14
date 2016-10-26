package week7.proxy;

/**
 * Created by mi on 20.10.16.
 */
public class Client {


    public static void main(String[] args) {
        MathService mathService = MathServiceFactory.create();
        mathService.add(23,45);
    }

}
