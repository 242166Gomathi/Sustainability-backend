package com.project.sustainability.model.signup;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * Represents Supplier ID information.
 */
@Data
@Document(collection = "supplier_id")
public class SupplierId {

    @Id
    private String id;

    @NotBlank(message = "Supplier ID is required")
    private String supplierId;

    private String countryCode;
    /**
     * Initializes a new SupplierId with a generated UUID.
     */
    public SupplierId() {

        this.id = UUID.randomUUID().toString();
    }
}
