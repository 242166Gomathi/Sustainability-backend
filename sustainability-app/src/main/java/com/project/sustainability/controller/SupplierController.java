package com.project.sustainability.controller;

import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.service.supplierservice.SupplierService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/suppliers")
@Validated
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<?> saveOrUpdateSupplier(@Valid @RequestBody SupplierData supplierData) {
        try {
            SupplierData savedSupplier = supplierService.saveOrUpdateSupplier(supplierData);
            return new ResponseEntity<>(savedSupplier, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getConstraintViolations().stream()
                    .collect(Collectors.toMap(
                            v -> v.getPropertyPath().toString(),
                            v -> v.getMessage())),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierData> getSupplierById(@PathVariable String id) {
        Optional<SupplierData> supplierData = supplierService.getSupplierById(id);
        return supplierData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<SupplierData>> getAllSuppliers() {
        List<SupplierData> suppliers = supplierService.getAllSuppliers();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable String id) {
        supplierService.deleteSupplierById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactDetails> saveOrUpdateContactDetails(@Valid @RequestBody ContactDetails contactDetails) {
        ContactDetails savedContact = supplierService.saveOrUpdateContactDetails(contactDetails);
        return new ResponseEntity<>(savedContact, HttpStatus.OK);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ContactDetails> getContactDetailsById(@PathVariable String id) {
        Optional<ContactDetails> contactDetails = supplierService.getContactDetailsById(id);
        return contactDetails.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContactDetailsById(@PathVariable String id) {
        supplierService.deleteContactDetailsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
