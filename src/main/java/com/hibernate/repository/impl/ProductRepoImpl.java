package com.hibernate.repository.impl;

import com.hibernate.config.HibernateConfig;
import com.hibernate.model.Product;
import com.hibernate.repository.ProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {

    @Override
    public List<Product> listProduct() {
        Transaction transaction = null;
        try (Session ses = HibernateConfig.getSession()) {

            transaction = ses.beginTransaction();

            Query<Product> query = ses.createQuery("from Product", Product.class);
            List<Product> products = query.getResultList();

            transaction.commit();

            return products;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    @Override
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session ses = HibernateConfig.getSession()) {
            transaction = ses.beginTransaction();
            ses.saveOrUpdate(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Product findProduct(Integer id) {
        Transaction transaction = null;
        try(Session ses = HibernateConfig.getSession()) {
            transaction = ses.beginTransaction();
            Product product = ses.get(Product.class, id);
            transaction.commit();
            return  product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        Transaction transaction = null;
        try(Session ses = HibernateConfig.getSession()) {
            transaction = ses.beginTransaction();
            Product product = ses.get(Product.class, id);
            ses.delete(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
