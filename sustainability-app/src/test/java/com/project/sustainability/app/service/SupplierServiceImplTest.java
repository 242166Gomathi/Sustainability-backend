package com.project.sustainability.app.service;


import com.project.sustainability.model.ContactDetails;
import com.project.sustainability.model.SupplierData;
import com.project.sustainability.repository.ContactDetailsRepository;
import com.project.sustainability.repository.SupplierDataRepository;

import com.project.sustainability.service.supplierserviceImpl.SupplierServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SupplierServiceImplTest {

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Mock
    private SupplierDataRepository supplierDataRepository;

    @Mock
    private ContactDetailsRepository contactDetailsRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveOrUpdateSupplier_Success() {
        // Arrange
        SupplierData supplierData = new SupplierData();
        when(supplierDataRepository.save(supplierData)).thenReturn(supplierData);

        // Act
        SupplierData result = supplierService.saveOrUpdateSupplier(supplierData);

        // Assert
        assertEquals(supplierData, result);
        verify(supplierDataRepository).save(supplierData);
    }

    @Test
    public void saveOrUpdateSuppliers_Success() {
        // Arrange
        SupplierData supplier1 = new SupplierData();
        SupplierData supplier2 = new SupplierData();
        List<SupplierData> supplierList = Arrays.asList(supplier1, supplier2);
        when(supplierDataRepository.saveAll(supplierList)).thenReturn(supplierList);

        // Act
        List<SupplierData> result = supplierService.saveOrUpdateSuppliers(supplierList);

        // Assert
        assertEquals(supplierList, result);
        verify(supplierDataRepository).saveAll(supplierList);
    }

    @Test
    public void getSupplierById_Found() {
        // Arrange
        String id = "1";
        SupplierData supplierData = new SupplierData();
        when(supplierDataRepository.findById(id)).thenReturn(Optional.of(supplierData));

        // Act
        Optional<SupplierData> result = supplierService.getSupplierById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(supplierData, result.get());
        verify(supplierDataRepository).findById(id);
    }

    @Test
    public void getSupplierById_NotFound() {
        // Arrange
        String id = "1";
        when(supplierDataRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<SupplierData> result = supplierService.getSupplierById(id);

        // Assert
        assertFalse(result.isPresent());
        verify(supplierDataRepository).findById(id);
    }

    @Test
    public void getAllSuppliers_Success() {
        // Arrange
        SupplierData supplier1 = new SupplierData();
        SupplierData supplier2 = new SupplierData();
        List<SupplierData> suppliers = Arrays.asList(supplier1, supplier2);
        when(supplierDataRepository.findAll()).thenReturn(suppliers);

        // Act
        List<SupplierData> result = supplierService.getAllSuppliers();

        // Assert
        assertEquals(suppliers, result);
        verify(supplierDataRepository).findAll();
    }

    @Test
    public void deleteSupplierById() {
        // Arrange
        String id = "1";

        // Act
        supplierService.deleteSupplierById(id);

        // Assert
        verify(supplierDataRepository).deleteById(id);
    }


}
