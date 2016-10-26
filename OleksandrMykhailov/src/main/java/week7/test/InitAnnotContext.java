package week7.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import week7.ioc.View;

/**
 * Created by mi on 20.10.16.
 */
public class InitAnnotContext {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("week7");
        View view = context.getBean(View.class);

        view.show();
    }

}
