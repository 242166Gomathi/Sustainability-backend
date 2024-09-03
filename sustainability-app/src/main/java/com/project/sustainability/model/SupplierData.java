package com.project.sustainability.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents SupplierData information.
 */
@Data
@Document(collection = "supplier_data")
public class SupplierData {

    @Id
    private String id;

    @NotBlank(message = "Please provide the company name")
    private String companyName;

    @NotBlank(message = "Please provide the address line 1")
    private String addressLine1;

    @NotBlank(message = "Please select the state")
    private String state;

    @NotBlank(message = "Please select the country")
    private String country;

    @Pattern(regexp = "^[0-9]{6}$", message = "Please provide a valid zipcode")
    private String zipcode;

    @NotBlank(message = "Please provide the supplier ID")
    private String supplierId;

    @Valid
    private List<@Valid ContactDetails> contactDetails = new ArrayList<>();

    @Valid
    private List<@Valid AssociatedSuppliers> AssociatedSuppliers = new ArrayList<>();
}
