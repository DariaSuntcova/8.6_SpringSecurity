package ru.netology.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PersonPK.class)
@Table(name = "PERSONS")
public class Person {

    @Id
    @Column(length = 50)
    private String name;

    @Id
    @Column(length = 50)
    private String surname;

    @Id
    private int age;

    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;
    @Column(name = "city_of_living", nullable = false, length = 50)
    private String cityOfLiving;
}
