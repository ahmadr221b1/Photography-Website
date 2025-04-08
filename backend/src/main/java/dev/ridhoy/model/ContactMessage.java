package dev.ridhoy.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

 @Entity
public class ContactMessage {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     private String email;

     @Column(length = 1000)
     private String message;

     private LocalDateTime submittedAt = LocalDateTime.now();

     //Getters and setters
     public Long getId() {
         return id;
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

     public String getMessage() {
         return message;
     }

     public void setMessage(String message) {
         this.message = message;
     }

     public LocalDateTime getSubmittedAt() {
         return submittedAt;
     }

     public void setSubmittedAt(LocalDateTime submittedAt) {
         this.submittedAt = submittedAt;
     }
 }