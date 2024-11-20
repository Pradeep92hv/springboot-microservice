package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// from lombak we cna use getter,setter,arg notation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity  // to make it enitity
@Table(name="users")   // to give table details like name
public class User {

    @Id   // to  make primary key
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "first_name",nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false,unique = true  )
    String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
