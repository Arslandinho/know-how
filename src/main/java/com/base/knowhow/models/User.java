package com.base.knowhow.models;



import com.base.knowhow.security.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    @NotNull
    @Size(min = 1,max = 120)
    private String firstName;

    @Column(name = "secondname")
    @NotNull
    @Size(min = 1,max = 120)
    private String secondName;

    @Column(name = "email")
    @NotNull
    @Size(min = 1,max = 120)
    private String email;

//    @Column(name = "country")
//    @NotNull
//    private String country;

    @Column(name = "password")
    @NotNull
    private String password;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    //TODO Create sex field and know its type
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
