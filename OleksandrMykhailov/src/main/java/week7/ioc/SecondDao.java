package week7.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mi on 20.10.16.
 */
@Component
public class SecondDao implements Dao {

    @Value("second dao")
    private String daoInfo;

    public SecondDao() {
    }

    public String getDaoInfo() {
        return daoInfo;
    }

    public void setDaoInfo(String daoInfo) {
        this.daoInfo = daoInfo;
    }

    @Override
    public String data() {
        return daoInfo;
    }
}


