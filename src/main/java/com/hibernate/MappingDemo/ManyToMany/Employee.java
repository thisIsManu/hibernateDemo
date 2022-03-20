package com.hibernate.MappingDemo.ManyToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@ToString
@Setter
public class Employee {
    @Id
    private int eid;
    private String Name;

    @ManyToMany
    @JoinTable(name = "emp_project", joinColumns = {@JoinColumn(name = "e_id")}, inverseJoinColumns = {@JoinColumn(name = "p_id")})
    private List<Project> projects;
}
