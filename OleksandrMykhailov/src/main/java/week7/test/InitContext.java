package week7.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week7.ioc.Service;
import week7.ioc.View;

/**
 * Created by mi on 20.10.16.
 */
public class InitContext {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:week7/ioc/app-context.xml");

        View view1 = (View) applicationContext.getBean("view");

        View view2 = applicationContext.getBean(View.class);

        View view3 = applicationContext.getBean("view",View.class);

        Service service = applicationContext.getBean(Service.class);


        view1.show();
        view2.show();
        view3.show();

//        View myView = new View();
//        myView.show();

    }

}
