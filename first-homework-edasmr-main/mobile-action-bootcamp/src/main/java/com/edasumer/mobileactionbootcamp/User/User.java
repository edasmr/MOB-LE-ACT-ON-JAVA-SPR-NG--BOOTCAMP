package com.edasumer.mobileactionbootcamp.User;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @SequenceGenerator(name = "user", sequenceName = "SeqUser")
    @GeneratedValue(generator = "user")
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Surname", length = 50)
    private String surname;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private boolean isActive;
}