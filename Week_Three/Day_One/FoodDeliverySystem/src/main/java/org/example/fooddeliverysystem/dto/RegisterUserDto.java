package org.example.fooddeliverysystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.example.fooddeliverysystem.entity.Role;

public class RegisterUserDto {
    @NotNull(message = "Email is required")
    @Email
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Name is required field")
    private String fullname;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role is required")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
