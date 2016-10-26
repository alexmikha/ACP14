package week7.proxy;

/**
 * Created by mi on 20.10.16.
 */
public class MathServiceProxy implements MathService {

    private MathService target;

    public MathServiceProxy(MathService target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.printf("In method add a = %d, b = %d", a, b);
        return target.add(a, b);
    }
}
