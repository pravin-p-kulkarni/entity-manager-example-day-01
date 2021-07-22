package com.pnc.training.entitymanagerexample.dao;

import com.pnc.training.entitymanagerexample.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Employee employee){
        if(employee.getEmpId() != null) {
            entityManager.merge(employee);
        }else{
            entityManager.persist(employee);
        }
        entityManager.flush();
    }
    public Employee retrieve(Long empId){
        return entityManager.find(Employee.class,empId);
    }

    public List<Employee> retrieveAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> all = criteriaQuery.select(root);
        return entityManager.createQuery(all).getResultList();
    }

    public void delete(Long empId){
        Employee employee = entityManager.find(Employee.class,empId);
        entityManager.remove(employee);
    }

}
