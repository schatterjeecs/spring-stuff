package org.sc.etlservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;
    private String name;
    private String position;
    private int age;

}
