import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.SessionFactoryUtils;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Context");
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

//        try {
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        sessionFactoryUtils.shutdown();
//    }
    }

}
