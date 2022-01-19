package com.hibernate;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="student")
@ToString
public class Student {
    @Id
    private int id;
    private String name;
    private String city;
    private Certificate certificate;
}
