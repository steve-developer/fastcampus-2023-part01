package org.example.model;

import java.time.LocalDateTime;

public class UserDto {

    private String name;

    private Integer age;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;


    public UserDto(String name, Integer age, String email, String phoneNumber, LocalDateTime registeredAt) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", registeredAt=" + registeredAt +
            '}';
    }
}
