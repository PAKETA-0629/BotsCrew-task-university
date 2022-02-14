package org.botscrewtesttask.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "department")
public class Department {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "head_of_department")
    private Lector headOfDepartment;
}
