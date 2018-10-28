package pl.sdacademy.database.dao;

import pl.sdacademy.database.entity.Member;
import pl.sdacademy.database.entity.Person;

import java.util.List;

public interface PersonDao {
    void saveOrUpdate(Person person);
    Member findBy(Long id);
    List<Person> findAll();
    public void delete(Long id);
    public void delete(Person person);
}
