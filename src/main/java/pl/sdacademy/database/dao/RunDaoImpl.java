package pl.sdacademy.database.dao;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunDaoImpl implements RunDao {


    public void savOrUpdate(Run run) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(run);
        session.getTransaction().commit();
        session.close();
    }


    public Run findBy(Long id) {
        try {
            Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Run run = (Run) session.createQuery("from Run where id=:id").setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            session.clear();

            return run;
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<Run> findAll() {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Run> runList = session.createQuery("from Run").list();
        session.getTransaction().commit();
        session.close();

        return runList;
    }


    public void delete(Long id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session
                .createQuery("delete Run where id=:id").setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    public void delete(Run run) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(run);
        session.getTransaction().commit();
        session.close();
    }
}
