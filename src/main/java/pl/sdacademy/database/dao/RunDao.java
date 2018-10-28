package pl.sdacademy.database.dao;

import pl.sdacademy.database.entity.Run;

import java.util.List;

public interface RunDao {
    void savOrUpdate(Run run);
    Run findBy(Long id);
    List<Run> findAll();
    public void delete(Long id);
    public void delete(Run run);
}
