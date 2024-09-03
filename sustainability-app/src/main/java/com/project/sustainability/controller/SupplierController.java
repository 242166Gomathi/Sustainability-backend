package com.project.sustainability.controller;

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

//    @PostMapping("/contacts")
//    public ResponseEntity<ContactDetails> saveOrUpdateContactDetails(@Valid @RequestBody ContactDetails contactDetails) {
//        ContactDetails savedContact = supplierService.saveOrUpdateContactDetails(contactDetails);
//        return new ResponseEntity<>(savedContact, HttpStatus.OK);
//    }
//
//    @GetMapping("/contacts/{id}")
//    public ResponseEntity<ContactDetails> getContactDetailsById(@PathVariable String id) {
//        Optional<ContactDetails> contactDetails = supplierService.getContactDetailsById(id);
//        return contactDetails.map(ResponseEntity::ok)
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @DeleteMapping("/contacts/{id}")
//    public ResponseEntity<Void> deleteContactDetailsById(@PathVariable String id) {
//        supplierService.deleteContactDetailsById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<SupplierData> patchSupplier(@PathVariable String id, @RequestBody SupplierData partialSupplierData) {
//        Optional<SupplierData> existingSupplierOpt = supplierService.getSupplierById(id);
//        if (!existingSupplierOpt.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        SupplierData existingSupplier = existingSupplierOpt.get();
//
//        // Apply the updates from the partialSupplierData to the existingSupplier
//        if (partialSupplierData.getCompanyName() != null) {
//            existingSupplier.setCompanyName(partialSupplierData.getCompanyName());
//        }
//        if (partialSupplierData.getAddressLine1() != null) {
//            existingSupplier.setAddressLine1(partialSupplierData.getAddressLine1());
//        }
//        if (partialSupplierData.getState() != null) {
//            existingSupplier.setState(partialSupplierData.getState());
//        }
//        if (partialSupplierData.getCountry() != null) {
//            existingSupplier.setCountry(partialSupplierData.getCountry());
//        }
//        if (partialSupplierData.getZipcode() != null) {
//            existingSupplier.setZipcode(partialSupplierData.getZipcode());
//        }
//        if (partialSupplierData.getSupplierId() != null) {
//            existingSupplier.setSupplierId(partialSupplierData.getSupplierId());
//        }
//        if (partialSupplierData.getContactDetails() != null) {
//            existingSupplier.setContactDetails(partialSupplierData.getContactDetails());
//        }
//        if (partialSupplierData.getAssociatedSuppliers() != null) {
//            existingSupplier.setAssociatedSuppliers(partialSupplierData.getAssociatedSuppliers());
//        }
//
//        SupplierData updatedSupplier = supplierService.saveOrUpdateSupplier(existingSupplier);
//        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
//    }
@PostMapping("/{id}")
public ResponseEntity<SupplierData> updateSupplier(@PathVariable String id, @RequestBody SupplierData supplierData) {
    // Retrieve the existing supplier
    Optional<SupplierData> existingSupplierOpt = supplierService.getSupplierById(id);
    if (!existingSupplierOpt.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update the existing supplier with new data
    SupplierData existingSupplier = existingSupplierOpt.get();
    existingSupplier.setCompanyName(supplierData.getCompanyName());
    existingSupplier.setAddressLine1(supplierData.getAddressLine1());
    existingSupplier.setState(supplierData.getState());
    existingSupplier.setCountry(supplierData.getCountry());
    existingSupplier.setZipcode(supplierData.getZipcode());
    existingSupplier.setSupplierId(supplierData.getSupplierId());
    existingSupplier.setContactDetails(supplierData.getContactDetails());
    existingSupplier.setAssociatedSuppliers(supplierData.getAssociatedSuppliers());

    SupplierData updatedSupplier = supplierService.saveOrUpdateSupplier(existingSupplier);
    return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
}

}
