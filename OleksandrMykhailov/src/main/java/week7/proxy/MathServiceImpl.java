package week7.proxy;

/**
 * Created by mi on 20.10.16.
 */
public class MathServiceImpl implements MathService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
