package pl.sdacademy.database.dao;

import pl.sdacademy.database.entity.Member;

import java.util.List;

public interface MemberDao {
    void saveOrUpdate(Member member);
    Member findBy(Long id);
    List<Member> findAll();
    public void delete(Long id);
    public void delete(Member member);
}
