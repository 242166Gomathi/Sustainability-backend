//package com.project.sustainability.model.signup;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
//import java.util.UUID;
//
///**
// * Represents contact details for a supplier.
// */
//@Data
//@Document(collection = "contact_detail")
//public class ContactDetails {
//
//    @Id
//    private String id;
//
//    @NotEmpty(message = "User Type is required")
//    private String userType;
//
//    @NotBlank(message = "First name is required")
//    private String firstName;
//
//    @NotBlank(message = "Last name is required")
//    private String lastName;
//
//    @Email(message = "Invalid email format")
//    private String email;
//
//    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
//    private String phoneNumber;
//
//    private String designation;
//
//    /**
//     * Initializes a new SupplierId with a generated UUID.
//     */
//    public ContactDetails() {
//        this.id = UUID.randomUUID().toString();
//    }
//}
package com.project.sustainability.model.signup;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Document(collection = "contact_detail")
public class ContactDetails {

    @Id
    private String id;

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
}
