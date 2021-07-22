package com.pnc.training.entitymanagerexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "T_PNC_EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private Long empId;
    @Column(name = "EMP_NAME")
    private String empName;
    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "DEPT_ID")
    @JsonIgnoreProperties("employees")
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee )) return false;
        return empId != null && empId == ((Employee) o).getEmpId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
