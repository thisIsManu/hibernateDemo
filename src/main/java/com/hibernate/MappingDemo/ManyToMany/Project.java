package com.hibernate.MappingDemo.ManyToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Builder
@Getter
@ToString
@Setter
public class Project {
    @Id
    private int pid;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;
}
