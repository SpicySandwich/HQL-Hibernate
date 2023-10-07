package com.hibernate.config;

import com.hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {


    static SessionFactory factory = null;
    static {
        Configuration cfg = new Configuration();
        Properties prop = new Properties();

        prop.put(Environment.URL, "jdbc:mysql://localhost:3306/hiber");
        prop.put(Environment.USER, "root");
        prop.put(Environment.PASS, "root");
        prop.put(Environment.SHOW_SQL, true);
        prop.put(Environment.FORMAT_SQL, true);
        prop.put(Environment.HBM2DDL_AUTO, "update");

        cfg.setProperties(prop);

        //this can be multiple
        cfg.addAnnotatedClass(Product.class);

        factory = cfg.buildSessionFactory();
    }


    public static Session getSession() {
        return factory.openSession();
    }
}
