package com.mamesur.hibernate.crud.demo.dao;


import com.mamesur.hibernate.crud.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentTypedQuery =
                entityManager.createQuery("From Student order by lastName asc", Student.class);

        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> findByLastNameQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        findByLastNameQuery.setParameter("theData", lastName);

        return findByLastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
