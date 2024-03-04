package com.example.libraryManagementSystem.entity;
//import javax.validation.constraints.Email;

// Your class and annotations...


import jakarta.persistence.*;

@Entity
public class MemberEntity {
    @Id  //making primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long member_id;

    @Column(name = "name")
    private String name;



    @Column(name = "email", unique = true, nullable = false)
//    @Email(message = "Please provide a valid email address")
    private String email;

    public MemberEntity(){

    }

    public MemberEntity(long member_id, String name, String email) {
        this.member_id = member_id;
        this.name = name;
        this.email = email;    //sudo docker run --network host spring-boot-docker.jar

    }
    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString(){
        return "Course [member_id=" + member_id + ", name=" + name + ", email=" + email + "]";
    }


}
