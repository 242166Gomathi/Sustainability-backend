package com.project.sustainability.service.supplierservice;


import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;

import java.util.List;
import java.util.Optional;


public interface SupplierService {
    SupplierData saveOrUpdateSupplier(SupplierData supplierData);
    List<SupplierData> saveOrUpdateSuppliers(List<SupplierData> supplierDataList);
    Optional<SupplierData> getSupplierById(String id);
    List<SupplierData> getAllSuppliers();
    void deleteSupplierById(String id);

    // Methods for handling ContactDetails
    ContactDetails saveOrUpdateContactDetails(ContactDetails contactDetails);
    Optional<ContactDetails> getContactDetailsById(String id);
    void deleteContactDetailsById(String id);
}
