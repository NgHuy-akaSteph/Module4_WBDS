package com.dev.springvalid.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @NotNull(message = "Id is required")
    @Pattern(regexp = "^CUS\\d{4}$", message = "Id must be started with CUS followed by 4 digits")
    private String id;

    @NotNull(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must be alphabetic")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    private String name;

    @NotNull(message = "Date of birth is required")
    private Date dob;

    @Email(message = "Email is invalid")
    private String email;




}
