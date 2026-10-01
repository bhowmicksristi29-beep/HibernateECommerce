package com.demo.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.Category;
import com.demo.entity.OrderDetails;
import com.demo.entity.Orders;
import com.demo.entity.Product;
import com.demo.entity.Role;
import com.demo.entity.Users;
import com.demo.util.HibernateUtil;

public class CrudTest {

    public static void main(String[] args) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // =========================
            // READ - Category
            // =========================
            Category category = session
                    .createQuery(
                            "FROM Category WHERE name = :name",
                            Category.class)
                    .setParameter("name", "Electronics")
                    .uniqueResult();

            System.out.println("Category: " + category.getName());

            // =========================
            // READ - Products
            // =========================
            Product mouse = session
                    .createQuery(
                            "FROM Product WHERE name = :name",
                            Product.class)
                    .setParameter("name", "Wireless Mouse")
                    .uniqueResult();

            Product keyboard = session
                    .createQuery(
                            "FROM Product WHERE name = :name",
                            Product.class)
                    .setParameter("name", "Keyboard")
                    .uniqueResult();

            System.out.println("Product 1: " + mouse.getName());
            System.out.println("Product 2: " + keyboard.getName());

            // =========================
            // READ - User
            // =========================
            Users user = session
                    .createQuery(
                            "FROM Users WHERE username = :username",
                            Users.class)
                    .setParameter("username", "admin")
                    .uniqueResult();

            System.out.println("User: " + user.getUsername());

            // =========================
            // CREATE - New Order
            // =========================
            Orders order = new Orders(
                    LocalDateTime.now(),
                    new BigDecimal("2099.98"),
                    user
            );

            OrderDetails detail1 = new OrderDetails(
                    1,
                    new BigDecimal("799.99"),
                    mouse
            );

            OrderDetails detail2 = new OrderDetails(
                    1,
                    new BigDecimal("1299.99"),
                    keyboard
            );

            order.addOrderDetail(detail1);
            order.addOrderDetail(detail2);

            session.persist(order);

            // =========================
            // UPDATE - Product Stock
            // =========================
            mouse.setStockQuantity(75);

            transaction.commit();

            System.out.println("Order created successfully.");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Product stock updated successfully.");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            HibernateUtil.shutdown();
        }
    }
}