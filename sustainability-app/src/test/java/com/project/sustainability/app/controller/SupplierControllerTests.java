package com.project.sustainability.app.controller;

import com.project.sustainability.controller.SupplierController;
import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.service.supplierservice.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SupplierControllerTests {

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveOrUpdateSupplier_Success() {
        // Arrange
        SupplierData supplierData = new SupplierData();
        when(supplierService.saveOrUpdateSupplier(any(SupplierData.class))).thenReturn(supplierData);

        // Act
        ResponseEntity<?> response = supplierController.saveOrUpdateSupplier(supplierData);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(supplierData, response.getBody());
    }

    @Test
    void getSupplierById_Found() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        SupplierData supplierData = new SupplierData();
        when(supplierService.getSupplierById(id)).thenReturn(Optional.of(supplierData));

        // Act
        ResponseEntity<SupplierData> response = supplierController.getSupplierById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(supplierData, response.getBody());
    }

    @Test
    void getSupplierById_NotFound() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        when(supplierService.getSupplierById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<SupplierData> response = supplierController.getSupplierById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void deleteSupplierById() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";

        // Act
        ResponseEntity<Void> response = supplierController.deleteSupplierById(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(supplierService).deleteSupplierById(id);
    }

    @Test
    void saveOrUpdateContactDetails_Success() {
        // Arrange
        ContactDetails contactDetails = new ContactDetails();
        when(supplierService.saveOrUpdateContactDetails(any(ContactDetails.class))).thenReturn(contactDetails);

        // Act
        ResponseEntity<ContactDetails> response = supplierController.saveOrUpdateContactDetails(contactDetails);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(contactDetails, response.getBody());
    }

    @Test
    void getContactDetailsById_Found() {
        // Arrange
        String id = "contactId";
        ContactDetails contactDetails = new ContactDetails();
        when(supplierService.getContactDetailsById(id)).thenReturn(Optional.of(contactDetails));

        // Act
        ResponseEntity<ContactDetails> response = supplierController.getContactDetailsById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(contactDetails, response.getBody());
    }

    @Test
    void getContactDetailsById_NotFound() {
        // Arrange
        String id = "contactId";
        when(supplierService.getContactDetailsById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<ContactDetails> response = supplierController.getContactDetailsById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void deleteContactDetailsById() {
        // Arrange
        String id = "contactId";

        // Act
        ResponseEntity<Void> response = supplierController.deleteContactDetailsById(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(supplierService).deleteContactDetailsById(id);
    }
}
