package util;

import entity.Program;
import entity.ReserveDetails;
import entity.Student;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    /*private FactoryConfiguration(){
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Student.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }*/

    private FactoryConfiguration(){
        Properties properties = new Properties();
       /* try {
            properties.load(new FileInputStream("F:\\JavaFX\\Institute_Management_System\\src\\hibernate.properties"));
        }catch (IOException e) {
            System.out.println("cannot load properties");
            e.printStackTrace();
        }
        Configuration configuration = new Configuration().addProperties(properties)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(ReserveDetails.class)
                .addAnnotatedClass(Users.class);
        sessionFactory = configuration.buildSessionFactory();*/
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("not found");
            e.printStackTrace();
        }
        sessionFactory =  new Configuration().mergeProperties(properties).addAnnotatedClass(Student.class).addAnnotatedClass(Program.class)
                .addAnnotatedClass(ReserveDetails.class)
                .addAnnotatedClass(Users.class).buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

    /*private FactoryConfiguration(){
        Configuration configure = new Configuration().configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(ReserveDetails.class)
                .addAnnotatedClass(Users.class);
        sessionFactory = configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }*/

}
