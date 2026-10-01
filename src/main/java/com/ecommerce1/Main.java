package com.ecommerce1;

import com.ecommerce.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Hibernate...");

        HibernateUtil.getSessionFactory();

        System.out.println("Hibernate started successfully!");

        HibernateUtil.shutdown();
    }
}