package library.run;

import library.view.ConsoleView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mi on 22.10.16.
 */
public class RunConsole {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
           ConsoleView consoleView = context.getBean(ConsoleView.class);
        consoleView.start();
        }
    }

