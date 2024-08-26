package com.project.sustainability.app.service;//package com.project.sustainability.app.service;//package com.project.sustainability.service.supplierserviceImpl;
////
////import com.project.sustainability.model.signup.SupplierData;
////import com.project.sustainability.repository.SupplierRepository;
////import org.junit.Before;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
////import org.mockito.junit.MockitoJUnitRunner;
////import org.springframework.validation.BindingResult;
////import org.springframework.validation.FieldError;
////
////import java.util.Arrays;
////import java.util.Collections;
////import java.util.List;
////import java.util.Optional;
////
////import static org.junit.Assert.*;
////import static org.mockito.Mockito.*;
////
////@RunWith(MockitoJUnitRunner.class)
////public class SignUpServiceImplTest {
////
////    @InjectMocks
////    private SignUpServiceImpl signUpService;
////
////    @Mock
////    private SupplierRepository supplierRepository;
////
////    @Mock
////    private BindingResult bindingResult;
////
////    private SupplierData supplierData;
////
////    @Before
////    public void setUp() {
////        MockitoAnnotations.initMocks(this);
////        supplierData = new SupplierData();
////        // Initialize supplierData with necessary values if needed
////    }
////
////    // Test saveSuppliers positive case
////    @Test
////    public void testSaveSuppliers_Success() {
////        // Arrange
////        List<SupplierData> suppliers = Collections.singletonList(supplierData);
////        when(supplierRepository.saveAll(suppliers)).thenReturn(suppliers);
////
////        // Act
////        List<SupplierData> result = signUpService.saveSuppliers(suppliers);
////
////        // Assert
////        assertNotNull(result);
////        assertEquals(1, result.size());
////        assertEquals(supplierData, result.get(0));
////    }
////
////    // Test saveSuppliers exception case
////    @Test(expected = RuntimeException.class)
////    public void testSaveSuppliers_Exception() {
////        // Arrange
////        List<SupplierData> suppliers = Collections.singletonList(supplierData);
////        when(supplierRepository.saveAll(suppliers)).thenThrow(new RuntimeException("Database error"));
////
////        // Act
////        signUpService.saveSuppliers(suppliers);
////    }
////
////    // Test getSupplierById positive case
////    @Test
////    public void testGetSupplierById_Success() {
////        // Arrange
////        when(supplierRepository.findById(anyString())).thenReturn(Optional.of(supplierData));
////
////        // Act
////        Optional<SupplierData> result = signUpService.getSupplierById("supplierId");
////
////        // Assert
////        assertTrue(result.isPresent());
////        assertEquals(supplierData, result.get());
////    }
////
////    // Test getSupplierById exception case
////    @Test(expected = RuntimeException.class)
////    public void testGetSupplierById_Exception() {
////        // Arrange
////        when(supplierRepository.findById(anyString())).thenThrow(new RuntimeException("Database error"));
////
////        // Act
////        signUpService.getSupplierById("supplierId");
////
////        // Assert is handled by the expected exception
////    }
////
////    // Test getAllSuppliers positive case
////    @Test
////    public void testGetAllSuppliers_Success() {
////        // Arrange
////        when(supplierRepository.findAll()).thenReturn(Collections.singletonList(supplierData));
////
////        // Act
////        List<SupplierData> result = signUpService.getAllSuppliers();
////
////        // Assert
////        assertNotNull(result);
////        assertEquals(1, result.size());
////        assertEquals(supplierData, result.get(0));
////    }
////
////    // Test getAllSuppliers exception case
////    @Test(expected = RuntimeException.class)
////    public void testGetAllSuppliers_Exception() {
////        // Arrange
////        when(supplierRepository.findAll()).thenThrow(new RuntimeException("Database error"));
////
////        // Act
////        signUpService.getAllSuppliers();
////
////        // Assert is handled by the expected exception
////    }
////
////    // Test updateSupplier positive case
////    @Test
////    public void testUpdateSupplier_Success() {
////        // Arrange
////        when(supplierRepository.save(any(SupplierData.class))).thenReturn(supplierData);
////
////        // Act
////        SupplierData result = signUpService.updateSupplier(supplierData);
////
////        // Assert
////        assertNotNull(result);
////        assertEquals(supplierData, result);
////    }
////
////    // Test updateSupplier exception case
////    @Test(expected = RuntimeException.class)
////    public void testUpdateSupplier_Exception() {
////        // Arrange
////        when(supplierRepository.save(any(SupplierData.class))).thenThrow(new RuntimeException("Database error"));
////
////        // Act
////        signUpService.updateSupplier(supplierData);
////
////        // Assert is handled by the expected exception
////    }
////
////    // Test deleteSupplier positive case
////    @Test
////    public void testDeleteSupplier_Success() {
////        // Arrange
////        doNothing().when(supplierRepository).deleteById(anyString());
////
////        // Act
////        try {
////            signUpService.deleteSupplier("supplierId");
////        } catch (Exception e) {
////            fail("Exception should not be thrown");
////        }
////    }
////
////    // Test deleteSupplier exception case
////    @Test
////    public void testDeleteSupplier_Exception() {
////        // Arrange
////        doThrow(new RuntimeException("Database error")).when(supplierRepository).deleteById(anyString());
////
////        // Act
////        try {
////            signUpService.deleteSupplier("supplierId");
////            fail("Exception should be thrown");
////        } catch (RuntimeException e) {
////            assertEquals("Failed to delete supplier", e.getMessage());
////        }
////    }
////
////    // Test getErrorMessages with validation errors
////    @Test
////    public void testGetErrorMessages() {
////        // Arrange
////        FieldError fieldError = new FieldError("objectName", "field", "Error message");
////        when(bindingResult.getAllErrors()).thenReturn(Arrays.asList(fieldError));
////
////        // Act
////        String result = signUpService.getErrorMessages(bindingResult);
////
////        // Assert
////        assertEquals("Error message. ", result);
////    }
////}
//import com.project.sustainability.model.signup.SupplierData;
//import com.project.sustainability.repository.SupplierRepository;
//import com.project.sustainability.service.supplierserviceImpl.SignUpServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.validation.BindingResult;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//public class SignUpServiceImplTest {
//
//    @Mock
//    private SupplierRepository supplierRepository;
//
//    @InjectMocks
//    private SignUpServiceImpl signUpService;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSaveOrUpdateSuppliers_Success() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        supplier.setId("1");
//        List<SupplierData> suppliers = new ArrayList<>();
//        suppliers.add(supplier);
//        when(supplierRepository.findById("1")).thenReturn(Optional.of(supplier));
//        when(supplierRepository.saveAll(suppliers)).thenReturn(suppliers);
//
//        // Act
//        List<SupplierData> result = signUpService.saveOrUpdateSuppliers(suppliers);
//
//        // Assert
//        assertEquals(suppliers, result);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testSaveOrUpdateSuppliers_Exception() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        List<SupplierData> suppliers = new ArrayList<>();
//        suppliers.add(supplier);
//        when(supplierRepository.saveAll(suppliers)).thenThrow(new RuntimeException("Error saving"));
//
//        // Act
//        signUpService.saveOrUpdateSuppliers(suppliers);
//    }
//
//    @Test
//    public void testGetSupplierById_Success() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        when(supplierRepository.findById("1")).thenReturn(Optional.of(supplier));
//
//        // Act
//        Optional<SupplierData> result = signUpService.getSupplierById("1");
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(supplier, result.get());
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testGetSupplierById_Exception() {
//        // Arrange
//        when(supplierRepository.findById("1")).thenThrow(new RuntimeException("Error fetching"));
//
//        // Act
//        signUpService.getSupplierById("1");
//    }
//
//    @Test
//    public void testGetAllSuppliers_Success() {
//        // Arrange
//        List<SupplierData> suppliers = new ArrayList<>();
//        when(supplierRepository.findAll()).thenReturn(suppliers);
//
//        // Act
//        List<SupplierData> result = signUpService.getAllSuppliers();
//
//        // Assert
//        assertEquals(suppliers, result);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testGetAllSuppliers_Exception() {
//        // Arrange
//        when(supplierRepository.findAll()).thenThrow(new RuntimeException("Error fetching"));
//
//        // Act
//        signUpService.getAllSuppliers();
//    }
//
//    @Test
//    public void testUpdateSupplier_Success() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        when(supplierRepository.save(supplier)).thenReturn(supplier);
//
//        // Act
//        SupplierData result = signUpService.updateSupplier(supplier);
//
//        // Assert
//        assertEquals(supplier, result);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testUpdateSupplier_Exception() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        when(supplierRepository.save(supplier)).thenThrow(new RuntimeException("Error updating"));
//
//        // Act
//        signUpService.updateSupplier(supplier);
//    }
//
//    @Test
//    public void testDeleteSupplier_Success() {
//        // Act
//        signUpService.deleteSupplier("1");
//
//        // Assert
//        verify(supplierRepository, times(1)).deleteById("1");
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testDeleteSupplier_Exception() {
//        // Arrange
//        doThrow(new RuntimeException("Error deleting")).when(supplierRepository).deleteById("1");
//
//        // Act
//        signUpService.deleteSupplier("1");
//    }
//
//    @Test
//    public void testGetErrorMessages_Success() {
//        // Arrange
//        BindingResult bindingResult = mock(BindingResult.class);
//        when(bindingResult.getAllErrors()).thenReturn(new ArrayList<>());
//
//        // Act
//        String result = signUpService.getErrorMessages(bindingResult);
//
//        // Assert
//        assertNotNull(result);
//    }
//}
import com.project.sustainability.model.signup.SupplierData;
import com.project.sustainability.repository.SupplierRepository;
import com.project.sustainability.service.supplierserviceImpl.SignUpServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SignUpServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SignUpServiceImpl signUpServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrUpdateSuppliers_Success_NewSupplier() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        SupplierData supplier = new SupplierData();
        suppliers.add(supplier);

        when(supplierRepository.saveAll(suppliers)).thenReturn(suppliers);

        // Act
        List<SupplierData> result = signUpServiceImpl.saveOrUpdateSuppliers(suppliers);

        // Assert
        assertEquals(suppliers, result);
        verify(supplierRepository, times(1)).saveAll(suppliers);
    }

    @Test
    public void testSaveOrUpdateSuppliers_Success_UpdateExistingSupplier() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        SupplierData supplier = new SupplierData();
        supplier.setId("1");
        suppliers.add(supplier);

        when(supplierRepository.existsById("1")).thenReturn(true);
        when(supplierRepository.saveAll(suppliers)).thenReturn(suppliers);

        // Act
        List<SupplierData> result = signUpServiceImpl.saveOrUpdateSuppliers(suppliers);

        // Assert
        assertEquals(suppliers, result);
        verify(supplierRepository, times(1)).existsById("1");
        verify(supplierRepository, times(1)).saveAll(suppliers);
    }

    @Test(expected = RuntimeException.class)
    public void testSaveOrUpdateSuppliers_Failure() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        when(supplierRepository.saveAll(suppliers)).thenThrow(new RuntimeException("Database error"));

        // Act
        signUpServiceImpl.saveOrUpdateSuppliers(suppliers);

        // Assert
        // Exception is expected
    }

    @Test
    public void testGetSupplierById_Success() {
        // Arrange
        SupplierData supplier = new SupplierData();
        when(supplierRepository.findById("1")).thenReturn(Optional.of(supplier));

        // Act
        Optional<SupplierData> result = signUpServiceImpl.getSupplierById("1");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(supplier, result.get());
        verify(supplierRepository, times(1)).findById("1");
    }

    @Test(expected = RuntimeException.class)
    public void testGetSupplierById_Failure() {
        // Arrange
        when(supplierRepository.findById("1")).thenThrow(new RuntimeException("Database error"));

        // Act
        signUpServiceImpl.getSupplierById("1");

        // Assert
        // Exception is expected
    }

    @Test
    public void testGetAllSuppliers_Success() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        when(supplierRepository.findAll()).thenReturn(suppliers);

        // Act
        List<SupplierData> result = signUpServiceImpl.getAllSuppliers();

        // Assert
        assertEquals(suppliers, result);
        verify(supplierRepository, times(1)).findAll();
    }

    @Test(expected = RuntimeException.class)
    public void testGetAllSuppliers_Failure() {
        // Arrange
        when(supplierRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act
        signUpServiceImpl.getAllSuppliers();

        // Assert
        // Exception is expected
    }

    @Test
    public void testUpdateSupplier_Success() {
        // Arrange
        SupplierData supplier = new SupplierData();
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        // Act
        SupplierData result = signUpServiceImpl.updateSupplier(supplier);

        // Assert
        assertEquals(supplier, result);
        verify(supplierRepository, times(1)).save(supplier);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateSupplier_Failure() {
        // Arrange
        SupplierData supplier = new SupplierData();
        when(supplierRepository.save(supplier)).thenThrow(new RuntimeException("Database error"));

        // Act
        signUpServiceImpl.updateSupplier(supplier);

        // Assert
        // Exception is expected
    }

    @Test
    public void testDeleteSupplier_Success() {
        // Arrange
        doNothing().when(supplierRepository).deleteById("1");

        // Act
        signUpServiceImpl.deleteSupplier("1");

        // Assert
        verify(supplierRepository, times(1)).deleteById("1");
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteSupplier_Failure() {
        // Arrange
        doThrow(new RuntimeException("Database error")).when(supplierRepository).deleteById("1");

        // Act
        signUpServiceImpl.deleteSupplier("1");

        // Assert
        // Exception is expected
    }

    @Test
    public void testGetErrorMessages() {
        // Arrange
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getAllErrors()).thenReturn(new ArrayList<>());

        // Act
        String result = signUpServiceImpl.getErrorMessages(bindingResult);

        // Assert
        assertEquals("", result);
    }
}
