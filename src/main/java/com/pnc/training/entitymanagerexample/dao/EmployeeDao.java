package com.pnc.training.entitymanagerexample.dao;

import com.pnc.training.entitymanagerexample.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
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

    /*public List<Employee> getAllEmpFromDept(Long deptId){
        return entityManager.createQuery("select employee from Employee employee where employee.department.deptId = ?1")
        .setParameter(1,deptId).getResultList();
    }*/

    public List<Employee> getAllEmpFromDept(Long deptId){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> all = criteriaQuery.select(root);

        Predicate predicate = cb.equal(root.get("department").get("deptId"),deptId);
        all.where(predicate);
        return entityManager.createQuery(all).getResultList();
    }

    public List<Employee> retrieveAllEmployees(Long[] empIds){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> all = criteriaQuery.select(root);

        Expression<Long> empIdsExp = root.get("empId");
        Predicate predicate = empIdsExp.in(empIds);
        all.where(predicate);
        return entityManager.createQuery(all).getResultList();
    }

}
