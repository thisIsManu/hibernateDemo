package com.hibernate;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Certificate {
    private String course;
    private String duration;

}
