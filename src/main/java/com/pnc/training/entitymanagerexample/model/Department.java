package com.pnc.training.entitymanagerexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "T_PNC_DEPT")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DEPT_ID")
    private Long deptId;
    @Column(name="DEPT_NAME")
    private String deptName;
    @ManyToMany(targetEntity = Employee.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "department")
    @JsonIgnoreProperties("department")
    protected List<Employee> employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department )) return false;
        return deptId !=null && deptId == ((Department) o).getDeptId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
