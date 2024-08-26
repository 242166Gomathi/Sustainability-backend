//package com.project.sustainability.service.supplierserviceImpl;
//
//import com.project.sustainability.model.signup.SupplierData;
//import com.project.sustainability.repository.SupplierRepository;
//import com.project.sustainability.service.supplierservice.SignUpService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Service
//public class SignUpServiceImpl implements SignUpService {
//
//    private static final Logger LOGGER = Logger.getLogger(SignUpServiceImpl.class.getName());
//
//    @Autowired
//    private SupplierRepository supplierRepository;
//
//    /**
//     * Saves or updates a list of suppliers.
//     * @param suppliers List of SupplierData objects to be saved or updated.
//     * @return List of saved or updated SupplierData objects.
//     */
//    public List<SupplierData> saveOrUpdateSuppliers(List<SupplierData> suppliers) {
//        try {
//            for (SupplierData supplier : suppliers) {
//                // Check if the supplier already exists
//                Optional<SupplierData> existingSupplier = supplierRepository.findById(supplier.getId());
//                if (existingSupplier.isPresent()) {
//                    // If supplier exists, update it
//                    supplier.setId(existingSupplier.get().getId());
//                }
//            }
//            return supplierRepository.saveAll(suppliers);
//        } catch (Exception e) {
//            LOGGER.severe("Error saving or updating suppliers: " + e.getMessage());
//            throw new RuntimeException("Failed to save or update suppliers", e);
//        }
//    }
//
//    @Override
//    public Optional<SupplierData> getSupplierById(String id) {
//        try {
//            return supplierRepository.findById(id);
//        } catch (Exception e) {
//            LOGGER.severe("Error fetching supplier by ID: " + e.getMessage());
//            throw new RuntimeException("Failed to fetch supplier by ID", e);
//        }
//    }
//
//    @Override
//    public List<SupplierData> getAllSuppliers() {
//        try {
//            return supplierRepository.findAll();
//        } catch (Exception e) {
//            LOGGER.severe("Error fetching all suppliers: " + e.getMessage());
//            throw new RuntimeException("Failed to fetch all suppliers", e);
//        }
//    }
//
//    @Override
//    public SupplierData updateSupplier(SupplierData supplier) {
//        try {
//            return supplierRepository.save(supplier);
//        } catch (Exception e) {
//            LOGGER.severe("Error updating supplier: " + e.getMessage());
//            throw new RuntimeException("Failed to update supplier", e);
//        }
//    }
//
//    @Override
//    public void deleteSupplier(String id) {
//        try {
//            supplierRepository.deleteById(id);
//        } catch (Exception e) {
//            LOGGER.severe("Error deleting supplier: " + e.getMessage());
//            throw new RuntimeException("Failed to delete supplier", e);
//        }
//    }
//
//    @Override
//    public String getErrorMessages(BindingResult bindingResult) {
//        StringBuilder errorMessages = new StringBuilder();
//        bindingResult.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append(". "));
//        LOGGER.warning("Validation errors: " + errorMessages.toString());
//        return errorMessages.toString();
//    }
//}
package com.project.sustainability.service.supplierserviceImpl;

import com.project.sustainability.model.signup.SupplierData;
import com.project.sustainability.repository.SupplierRepository;
import com.project.sustainability.service.supplierservice.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SignUpServiceImpl implements SignUpService {

    private static final Logger LOGGER = Logger.getLogger(SignUpServiceImpl.class.getName());

    @Autowired
    private SupplierRepository supplierRepository;

    /**
     * Saves or updates a list of suppliers.
     * @param suppliers List of SupplierData objects to be saved or updated.
     * @return List of saved or updated SupplierData objects.
     */
    public List<SupplierData> saveOrUpdateSuppliers(List<SupplierData> suppliers) {
        try {
            for (SupplierData supplier : suppliers) {
                // Check if the supplier already exists by ID
                if (supplier.getId() != null && supplierRepository.existsById(supplier.getId())) {
                    // If supplier exists, update it
                    LOGGER.info("Updating existing supplier with ID: " + supplier.getId());
                } else {
                    // If new supplier, create a new ID (or let the database handle it if it's autogenerated)
                    LOGGER.info("Creating new supplier.");
                }
            }
            return supplierRepository.saveAll(suppliers);
        } catch (Exception e) {
            LOGGER.severe("Error saving or updating suppliers: " + e.getMessage());
            throw new RuntimeException("Failed to save or update suppliers", e);
        }
    }

    @Override
    public Optional<SupplierData> getSupplierById(String id) {
        try {
            return supplierRepository.findById(id);
        } catch (Exception e) {
            LOGGER.severe("Error fetching supplier by ID: " + e.getMessage());
            throw new RuntimeException("Failed to fetch supplier by ID", e);
        }
    }

    @Override
    public List<SupplierData> getAllSuppliers() {
        try {
            return supplierRepository.findAll();
        } catch (Exception e) {
            LOGGER.severe("Error fetching all suppliers: " + e.getMessage());
            throw new RuntimeException("Failed to fetch all suppliers", e);
        }
    }

    @Override
    public SupplierData updateSupplier(SupplierData supplier) {
        try {
            return supplierRepository.save(supplier);
        } catch (Exception e) {
            LOGGER.severe("Error updating supplier: " + e.getMessage());
            throw new RuntimeException("Failed to update supplier", e);
        }
    }

    @Override
    public void deleteSupplier(String id) {
        try {
            supplierRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.severe("Error deleting supplier: " + e.getMessage());
            throw new RuntimeException("Failed to delete supplier", e);
        }
    }

    @Override
    public String getErrorMessages(BindingResult bindingResult) {
        StringBuilder errorMessages = new StringBuilder();
        bindingResult.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append(". "));
        LOGGER.warning("Validation errors: " + errorMessages.toString());
        return errorMessages.toString();
    }
}
