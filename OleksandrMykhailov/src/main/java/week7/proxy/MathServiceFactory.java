package week7.proxy;

/**
 * Created by mi on 20.10.16.
 */
public class MathServiceFactory {
    public static MathService create() {
        return new MathServiceProxy(new MathServiceImpl());
    }
}
