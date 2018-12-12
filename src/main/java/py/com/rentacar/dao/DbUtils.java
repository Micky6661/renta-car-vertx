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

  /*  @Inject
    Logger logger;*/

    public static SessionFactory factory;
    public EntityManagerFactory entityManagerFactory;
    public EntityManager manager;

    public DbUtils() {
        try {
            factory = new Configuration().configure("META-INF/hibernate.cfg.xml").buildSessionFactory();
            entityManagerFactory = Persistence.createEntityManagerFactory("rentacarData");
            manager = entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            // logger.error("No se ha podido crear SessionFactory. " + ex);
            ex.printStackTrace();
//            throw new Exception();
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
            //  session.close();
        }

        return id;
    }

    public List<T> findAll(String table) {
        Session session = factory.openSession();
        List<T> objList = null;
        try {
            objList = session.createQuery("FROM " + table).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            // session.close();
        }

        return objList;
    }

    public T findById(Class<T> aClass, Integer id) {
        Session session = factory.openSession();
        T obj = null;
        try {
            obj = (T) session.get(aClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
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
            //session.close();
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
            //session.close();
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
            // session.close();
        }

        return objList;
    }
}