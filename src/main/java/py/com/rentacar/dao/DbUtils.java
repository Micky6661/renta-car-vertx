package py.com.rentacar.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Miguel Martinez
 **/
public class DbUtils<T> {

    public static SessionFactory factory;
    public EntityManagerFactory entityManagerFactory;
    public EntityManager manager;

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
        } finally {
            session.close();
        }

        return id;
    }

    public List<T> findAll(String table) {
        Session session = factory.openSession();
        List<T> objList = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            objList = session.createQuery("FROM " + table).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objList;
    }

    public T findById(Class<T> aClass, Integer id) {
        Session session = factory.openSession();
        T obj = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            obj = (T) session.get(aClass, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return obj;
    }

    public void update(T obj, Integer id) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(String.valueOf(id), obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(Class<T> aClass, Integer id) {
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

    /*
     * Query Especial que obtiene Registros desde un atributo
     * */
    public List<T> getByAtribute(Class<T> aClass, String table, String param, String atribute) {
        Session session = factory.openSession();
        List<T> objList = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createSQLQuery(
                    "select * from " + table + " s where s." + atribute + " = :param")
                    .addEntity(aClass)
                    .setParameter("param", param);

            objList = (List<T>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objList;
    }
}