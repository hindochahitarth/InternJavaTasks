package org.example.fooddeliverysystem.dto;

import jakarta.validation.constraints.*;
import org.example.fooddeliverysystem.entity.Gender;
import org.example.fooddeliverysystem.entity.Role;
import org.springframework.security.access.prepost.PreAuthorize;

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

    //@NotNull // checks if value is not null allows empty string and whitespace
    @NotBlank(message = "Invalid Phone Number:Empty Phone Number")//checks if value is not null  does not allow "" or " "
    //^ start matching from beginning of string
    // \\d matches numeric digit [0-9]
    // 10 means exactly total 10 digits
    // $ ends the match at the end of string
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Phone Number")
    private String mobileNo;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private  String emailId;

    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Password must be at least 6 character ")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;


}
