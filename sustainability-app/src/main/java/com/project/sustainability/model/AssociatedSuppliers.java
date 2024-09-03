package com.project.sustainability.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents SupplierData information.
 */
@Getter
@Setter
@Data
@Document(collection = "supplier_id")
public class AssociatedSuppliers {

//    @Id
//    private String id;

    @NotBlank(message = "Supplier ID is required")
    private String supplierId;

    private String countryCode;

}