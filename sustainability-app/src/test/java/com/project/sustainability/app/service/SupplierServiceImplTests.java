package com.project.sustainability.app.service;



import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.repository.ContactDetailsRepository;
import com.project.sustainability.repository.SupplierDataRepository;
import com.project.sustainability.service.supplierserviceImpl.SupplierServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SupplierServiceImplTests {

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Mock
    private SupplierDataRepository supplierDataRepository;

    @Mock
    private ContactDetailsRepository contactDetailsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveOrUpdateSupplier_Success() {
        // Arrange
        SupplierData supplierData = new SupplierData();
        when(supplierDataRepository.save(any(SupplierData.class))).thenReturn(supplierData);

        // Act
        SupplierData result = supplierService.saveOrUpdateSupplier(supplierData);

        // Assert
        assertEquals(supplierData, result);
    }

    @Test
    void saveOrUpdateSuppliers_Success() {
        // Arrange
        List<SupplierData> supplierDataList = Arrays.asList(new SupplierData(), new SupplierData());
        when(supplierDataRepository.saveAll(anyList())).thenReturn(supplierDataList);

        // Act
        List<SupplierData> result = supplierService.saveOrUpdateSuppliers(supplierDataList);

        // Assert
        assertEquals(supplierDataList, result);
    }

    @Test
    void getSupplierById_Found() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        SupplierData supplierData = new SupplierData();
        when(supplierDataRepository.findById(id)).thenReturn(Optional.of(supplierData));

        // Act
        Optional<SupplierData> result = supplierService.getSupplierById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(supplierData, result.get());
    }

    @Test
    void getSupplierById_NotFound() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        when(supplierDataRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<SupplierData> result = supplierService.getSupplierById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void getAllSuppliers() {
        // Arrange
        List<SupplierData> supplierDataList = Arrays.asList(new SupplierData(), new SupplierData());
        when(supplierDataRepository.findAll()).thenReturn(supplierDataList);

        // Act
        List<SupplierData> result = supplierService.getAllSuppliers();

        // Assert
        assertEquals(supplierDataList, result);
    }

    @Test
    void deleteSupplierById() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";

        // Act
        supplierService.deleteSupplierById(id);

        // Assert
        verify(supplierDataRepository).deleteById(id);
    }

    @Test
    void saveOrUpdateContactDetails_Success() {
        // Arrange
        ContactDetails contactDetails = new ContactDetails();
        when(contactDetailsRepository.save(any(ContactDetails.class))).thenReturn(contactDetails);

        // Act
        ContactDetails result = supplierService.saveOrUpdateContactDetails(contactDetails);

        // Assert
        assertEquals(contactDetails, result);
    }

    @Test
    void getContactDetailsById_Found() {
        // Arrange
        String id = "contactId";
        ContactDetails contactDetails = new ContactDetails();
        when(contactDetailsRepository.findById(id)).thenReturn(Optional.of(contactDetails));

        // Act
        Optional<ContactDetails> result = supplierService.getContactDetailsById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(contactDetails, result.get());
    }

    @Test
    void getContactDetailsById_NotFound() {
        // Arrange
        String id = "contactId";
        when(contactDetailsRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<ContactDetails> result = supplierService.getContactDetailsById(id);

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void deleteContactDetailsById() {
        // Arrange
        String id = "contactId";

        // Act
        supplierService.deleteContactDetailsById(id);

        // Assert
        verify(contactDetailsRepository).deleteById(id);
    }
}
