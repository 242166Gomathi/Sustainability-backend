package com.project.sustainability.app.controller;

import com.project.sustainability.controller.SupplierController;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.service.supplierservice.SupplierService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SupplierControllerTest {

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveOrUpdateSupplier_Success() {
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
    public void getSupplierById_Found() {
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
    public void getSupplierById_NotFound() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        when(supplierService.getSupplierById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<SupplierData> response = supplierController.getSupplierById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void getAllSuppliers_Success() {
        // Arrange
        SupplierData supplier1 = new SupplierData();
        SupplierData supplier2 = new SupplierData();
        List<SupplierData> suppliers = Arrays.asList(supplier1, supplier2);
        when(supplierService.getAllSuppliers()).thenReturn(suppliers);

        // Act
        ResponseEntity<List<SupplierData>> response = supplierController.getAllSuppliers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(suppliers, response.getBody());
    }

    @Test
    public void deleteSupplierById() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";

        // Act
        ResponseEntity<Void> response = supplierController.deleteSupplierById(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(supplierService).deleteSupplierById(id);
    }
    @Test
    public void updateSupplier_Success() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        SupplierData existingSupplier = new SupplierData();
        SupplierData updatedSupplier = new SupplierData();
        updatedSupplier.setCompanyName("Updated Company");

        // Mock the service method to return the existing supplier
        when(supplierService.getSupplierById(id)).thenReturn(Optional.of(existingSupplier));
        when(supplierService.saveOrUpdateSupplier(existingSupplier)).thenReturn(updatedSupplier);

        // Act
        ResponseEntity<SupplierData> response = supplierController.updateSupplier(id, updatedSupplier);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedSupplier, response.getBody());
        verify(supplierService).getSupplierById(id);
        verify(supplierService).saveOrUpdateSupplier(existingSupplier);
    }

    @Test
    public void updateSupplier_NotFound() {
        // Arrange
        String id = "66d70cdef34ccb2061bc30e8";
        SupplierData updatedSupplier = new SupplierData();

        // Mock the service method to return an empty Optional
        when(supplierService.getSupplierById(id)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<SupplierData> response = supplierController.updateSupplier(id, updatedSupplier);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(supplierService).getSupplierById(id);
        verify(supplierService, never()).saveOrUpdateSupplier(any(SupplierData.class));
    }

}
