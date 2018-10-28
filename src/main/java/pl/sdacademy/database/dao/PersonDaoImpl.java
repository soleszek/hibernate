package pl.sdacademy.database.dao;

import org.hibernate.Session;
import pl.sdacademy.database.entity.Member;
import pl.sdacademy.database.entity.Person;
import pl.sdacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    public void saveOrUpdate(Person person) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
        session.close();
    }

    public Person findBy(Long id) {
        try {
            Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
            Person person = (Person) session.createQuery("from Person where id=:id").setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            session.clear();

            return person;
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Person> findAll() {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> personList = session.createQuery("from Person").list();
        session.getTransaction().commit();
        session.close();

        return personList;
    }

    public void delete(Long id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session
                .createQuery("delete Person where id=:id").setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = HibernateUtils.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }
}
