package com.ems.EmployeeManagementService.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="department")
@Setter
@Getter
@ToString
@JsonIgnoreProperties("hibernateLazyInitializer")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "department")
public class Department implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="department_id")
    private long id;

    @Column(name="name")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return  getClass().hashCode();
    }
}
