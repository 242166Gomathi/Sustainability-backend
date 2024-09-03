package com.project.sustainability.service.supplierserviceImpl;



import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.repository.ContactDetailsRepository;
import com.project.sustainability.repository.SupplierDataRepository;
import com.project.sustainability.service.supplierservice.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDataRepository supplierDataRepository;

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Override
    public SupplierData saveOrUpdateSupplier(SupplierData supplierData) {
        return supplierDataRepository.save(supplierData);
    }

    @Override
    public List<SupplierData> saveOrUpdateSuppliers(List<SupplierData> supplierDataList) {
        return supplierDataRepository.saveAll(supplierDataList);
    }

    @Override
    public Optional<SupplierData> getSupplierById(String id) {
        return supplierDataRepository.findById(id);
    }

    @Override
    public List<SupplierData> getAllSuppliers() {
        return supplierDataRepository.findAll();
    }

    @Override
    public void deleteSupplierById(String id) {
        supplierDataRepository.deleteById(id);
    }


//    @Override
//    public ContactDetails saveOrUpdateContactDetails(ContactDetails contactDetails) {
//        return contactDetailsRepository.save(contactDetails);
//    }
//
//    @Override
//    public Optional<ContactDetails> getContactDetailsById(String id) {
//        return contactDetailsRepository.findById(id);
//    }
//
//    @Override
//    public void deleteContactDetailsById(String id) {
//        contactDetailsRepository.deleteById(id);
//    }
}
