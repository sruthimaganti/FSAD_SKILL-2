package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Product p1 = new Product("Laptop", "Electronics", 65000, 10);
        Product p2 = new Product("Mobile", "Electronics", 25000, 20);

        session.persist(p1);
        session.persist(p2);

        // READ
        Product product = session.get(Product.class, 1);
        System.out.println("Product Name: " + product.getName());

        // UPDATE
        product.setPrice(60000);
        session.merge(product);

        // DELETE
        Product del = session.get(Product.class, 2);
        session.remove(del);

        tx.commit();
        session.close();

        System.out.println("CRUD Operations Completed");
    }
}