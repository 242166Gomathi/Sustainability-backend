package com.project.sustainability.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents Contact Details information.
 */
@Data
@Document(collection = "contact_details")
public class ContactDetails {

    @NotEmpty(message = "User Type is required")
    private String userType;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phoneNumber;

    private String designation;

    public ContactDetails() {
        // Default constructor
    }
}
