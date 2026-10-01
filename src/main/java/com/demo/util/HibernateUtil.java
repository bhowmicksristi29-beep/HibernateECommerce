package com.demo.util;

import com.demo.entity.Category;
import com.demo.entity.Product;
import com.demo.entity.Users;
import com.demo.entity.Orders;
import com.demo.entity.OrderDetails;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
        	sessionFactory = new Configuration()
        	        .configure("hibernate.cfg.xml")
        	        .addAnnotatedClass(Category.class)
        	        .addAnnotatedClass(Product.class)
        	        .addAnnotatedClass(Users.class)
        	        .addAnnotatedClass(Orders.class)
        	        .addAnnotatedClass(OrderDetails.class)
        	        .buildSessionFactory();

            System.out.println("Hibernate SessionFactory created successfully.");

        } catch (Throwable ex) {

            System.err.println("SessionFactory creation failed.");
            ex.printStackTrace();

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}