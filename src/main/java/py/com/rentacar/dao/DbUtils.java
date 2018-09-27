package py.com.rentacar.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import py.com.rentacar.models.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DbUtils<T> {

    public static SessionFactory factory;
    public EntityManagerFactory entityManagerFactory;
    public EntityManager manager;
    Class<T> aClass;

    public DbUtils() {
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            entityManagerFactory = Persistence.createEntityManagerFactory("rentacarData");
            manager = entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            System.err.println("No se ha podido crear SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer insert(T obj) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;

        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {cd
            session.close();
        }

        return id;
    }

    public List<Users> findAll() {
        Session session = factory.openSession();
        List<Users> objList = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            objList = session.createQuery("FROM Users").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objList;
    }

    public void update(T obj, Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            T obj = (T) session.get(aClass, id);
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}