package org.example.fooddeliverysystem.dto;

import jakarta.validation.constraints.*;
import org.example.fooddeliverysystem.entity.Gender;
import org.example.fooddeliverysystem.entity.Role;

public class UserRequest {

    @NotBlank(message = "Name is required ")
    private String name;

    @NotNull(message = "Age is Required ")
    @Min(value = 18,message = "Age must be at least 18 ")
    @Max(value=100,message = "Age must be less than 100")
    private Integer age;

    @NotBlank(message = "Address is required")
    private String address;

    private Gender gender;

    @NotBlank
    private String mobileNo;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private  String emailId;

    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Password must be at least 6 character ")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;


}
