package week7.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mi on 20.10.16.
 */

// <bean id="generalDao" class.../>
@Component
public class GeneralDao implements Dao{

    @Value("kolia")
    private String name;
    private int count;
    private double limit;

    public GeneralDao() {
    }

    @Override
    public String data() {
        return name + " "+ count + " " +limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
