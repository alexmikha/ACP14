package week7.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class View {

    @Autowired
    private Service service;

    public View() {
    }

    public void show(){
        System.out.println(service.doService());
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
