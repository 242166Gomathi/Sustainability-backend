//package com.project.sustainability.controller.suppliercontroller;
//
//import com.project.sustainability.model.signup.SupplierData;
//import com.project.sustainability.service.supplierservice.SignUpService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@RestController
//@RequestMapping("/api/suppliers")
//public class SupplierController {
//
//    private static final Logger LOGGER = Logger.getLogger(SupplierController.class.getName());
//
//    @Autowired
//    private SignUpService signUpService;
//
//    /**
//     * Creates or updates suppliers.
//     * @param suppliers List of SupplierData objects to be created or updated.
//     * @param bindingResult Validation result for request body.
//     * @return ResponseEntity with created or updated suppliers or error messages.
//     */
//    @PostMapping
//    public ResponseEntity<Object> createOrUpdateSuppliers(@Valid @RequestBody List<SupplierData> suppliers, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String errorMessages = signUpService.getErrorMessages(bindingResult);
//            return ResponseEntity.badRequest().body(errorMessages);
//        }
//        List<SupplierData> createdOrUpdatedSuppliers = signUpService.saveOrUpdateSuppliers(suppliers);
//        return ResponseEntity.ok(createdOrUpdatedSuppliers);
//    }
//
//    /**
//     * Fetches a supplier by ID.
//     * @param id Supplier ID.
//     * @return ResponseEntity with supplier data or not found status.
//     */
//    @GetMapping("/{id}")
//    public ResponseEntity<SupplierData> getSupplierById(@PathVariable String id) {
//        Optional<SupplierData> supplier = signUpService.getSupplierById(id);
//        return supplier.map(ResponseEntity::ok)
//                .orElseGet(() -> {
//                    LOGGER.warning("Supplier not found with ID: " + id);
//                    return ResponseEntity.notFound().build();
//                });
//    }
//
//    /**
//     * Fetches all suppliers.
//     * @return ResponseEntity with list of all suppliers.
//     */
//    @GetMapping
//    public ResponseEntity<List<SupplierData>> getAllSuppliers() {
//        List<SupplierData> suppliers = signUpService.getAllSuppliers();
//        return ResponseEntity.ok(suppliers);
//    }
//
//    /**
//     * Deletes a supplier by ID.
//     * @param id Supplier ID.
//     * @return ResponseEntity with no content status.
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSupplier(@PathVariable String id) {
//        signUpService.deleteSupplier(id);
//        return ResponseEntity.noContent().build();
//    }
//}
package com.project.sustainability.controller.suppliercontroller;

import com.project.sustainability.model.signup.SupplierData;
import com.project.sustainability.service.supplierservice.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private static final Logger LOGGER = Logger.getLogger(SupplierController.class.getName());

    @Autowired
    private SignUpService signUpService;

    /**
     * Creates or updates suppliers.
     * @param suppliers List of SupplierData objects to be created or updated.
     * @param bindingResult Validation result for request body.
     * @return ResponseEntity with created or updated suppliers or error messages.
     */
    @PostMapping
    public ResponseEntity<Object> createOrUpdateSuppliers(@Valid @RequestBody List<SupplierData> suppliers, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessages = signUpService.getErrorMessages(bindingResult);
            return ResponseEntity.badRequest().body(errorMessages);
        }
        List<SupplierData> createdOrUpdatedSuppliers = signUpService.saveOrUpdateSuppliers(suppliers);
        return ResponseEntity.ok(createdOrUpdatedSuppliers);
    }

    /**
     * Fetches a supplier by ID.
     * @param id Supplier ID.
     * @return ResponseEntity with supplier data or not found status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplierData> getSupplierById(@PathVariable String id) {
        Optional<SupplierData> supplier = signUpService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    LOGGER.warning("Supplier not found with ID: " + id);
                    return ResponseEntity.notFound().build();
                });
    }

    /**
     * Fetches all suppliers.
     * @return ResponseEntity with list of all suppliers.
     */
    @GetMapping
    public ResponseEntity<List<SupplierData>> getAllSuppliers() {
        List<SupplierData> suppliers = signUpService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    /**
     * Deletes a supplier by ID.
     * @param id Supplier ID.
     * @return ResponseEntity with no content status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable String id) {
        signUpService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
