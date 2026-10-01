package com.demo.test;

import com.demo.util.HibernateUtil;

public class HibernateTest {

    public static void main(String[] args) {

        try {

            HibernateUtil.getSessionFactory();

            System.out.println("Hibernate connection test successful.");

        } finally {

            HibernateUtil.shutdown();
        }
    }
}
