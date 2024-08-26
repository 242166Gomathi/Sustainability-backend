package com.project.sustainability.service.supplierservice;

import com.project.sustainability.model.signup.SupplierData;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface SignUpService {
//    List<SupplierData> saveSuppliers(List<SupplierData> suppliers);
//    Optional<SupplierData> getSupplierById(String id);
//    List<SupplierData> getAllSuppliers();
//    SupplierData updateSupplier(SupplierData supplier);
//    void deleteSupplier(String id);
//
//    String getErrorMessages(BindingResult bindingResult);
//}
List<SupplierData> saveOrUpdateSuppliers(List<SupplierData> suppliers);
    Optional<SupplierData> getSupplierById(String id);
    List<SupplierData> getAllSuppliers();
    SupplierData updateSupplier(SupplierData supplier) ;
    void deleteSupplier(String id);
    String getErrorMessages(BindingResult bindingResult);}