//package com.project.sustainability.app.controller;//package com.project.sustainability.app.controller;
////
////import com.project.sustainability.controller.suppliercontroller.SupplierController;
////import com.project.sustainability.model.signup.SupplierData;
////import com.project.sustainability.service.supplierservice.SignUpService;
////import org.junit.Before;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.test.context.junit4.SpringRunner;
////import org.springframework.validation.BindingResult;
////import org.springframework.validation.ObjectError;
////
////import java.util.Arrays;
////import java.util.List;
////import java.util.Optional;
////
////import static org.junit.Assert.*;
////import static org.mockito.Mockito.*;
////
////@RunWith(SpringRunner.class)
////@SpringBootTest
////public class SupplierControllerTest {
////
////    @Mock
////    private SignUpService signUpService;
////
////    @InjectMocks
////    private SupplierController supplierController;
////
////    @Before
////    public void setUp() {
////        MockitoAnnotations.initMocks(this);
////    }
////
//////    @Test
//////    public void testCreateSuppliers_ValidData() {
//////        // Arrange
//////        SupplierData supplier1 = new SupplierData();
//////        SupplierData supplier2 = new SupplierData();
//////        List<SupplierData> suppliers = Arrays.asList(supplier1, supplier2);
//////        when(signUpService.saveSuppliers(suppliers)).thenReturn(suppliers);
//////
//////        // Act
//////        ResponseEntity<Object> response = supplierController.createSuppliers(suppliers, mock(BindingResult.class));
//////
//////        // Assert
//////        assertEquals(HttpStatus.OK, response.getStatusCode());
//////        assertEquals(suppliers, response.getBody());
//////    }
////
//////    @Test
//////    public void testCreateSuppliers_ValidationErrors() {
//////        // Arrange
//////        SupplierData supplier = new SupplierData();
//////        List<SupplierData> suppliers = Arrays.asList(supplier);
//////        BindingResult bindingResult = mock(BindingResult.class);
//////        when(bindingResult.hasErrors()).thenReturn(true);
//////        when(bindingResult.getAllErrors()).thenReturn(Arrays.asList(
//////                new org.springframework.validation.ObjectError("objectName", "error message")));
//////
//////        // Act
//////        ResponseEntity<Object> response = supplierController.createSuppliers(suppliers, bindingResult);
//////
//////        // Assert
//////        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//////        assertTrue(((String) response.getBody()).contains("error message"));
//////    }
////
////    @Test
////    public void testGetSupplierById_Found() {
////        // Arrange
////        String id = "123";
////        SupplierData supplier = new SupplierData();
////        when(signUpService.getSupplierById(id)).thenReturn(Optional.of(supplier));
////
////        // Act
////        ResponseEntity<SupplierData> response = supplierController.getSupplierById(id);
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(supplier, response.getBody());
////    }
////
////    @Test
////    public void testGetSupplierById_NotFound() {
////        // Arrange
////        String id = "123";
////        when(signUpService.getSupplierById(id)).thenReturn(Optional.empty());
////
////        // Act
////        ResponseEntity<SupplierData> response = supplierController.getSupplierById(id);
////
////        // Assert
////        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
////    }
////
////    @Test
////    public void testGetAllSuppliers() {
////        // Arrange
////        SupplierData supplier1 = new SupplierData();
////        SupplierData supplier2 = new SupplierData();
////        List<SupplierData> suppliers = Arrays.asList(supplier1, supplier2);
////        when(signUpService.getAllSuppliers()).thenReturn(suppliers);
////
////        // Act
////        ResponseEntity<List<SupplierData>> response = supplierController.getAllSuppliers();
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(suppliers, response.getBody());
////    }
////
////    @Test
////    public void testUpdateSupplier_ValidData() {
////        // Arrange
////        String id = "123";
////        SupplierData supplier = new SupplierData();
////        supplier.setId(id);
////        when(signUpService.updateSupplier(supplier)).thenReturn(supplier);
////        BindingResult bindingResult = mock(BindingResult.class);
////        when(bindingResult.hasErrors()).thenReturn(false);
////
////        // Act
////        ResponseEntity<Object> response = supplierController.updateSupplier(id, supplier, bindingResult);
////
////        // Assert
////        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(supplier, response.getBody());
////    }
////
////    @Test
////    public void testUpdateSupplier_ValidationErrors() {
////        // Arrange
////        String id = "123";
////        SupplierData supplier = new SupplierData();
////        BindingResult bindingResult = mock(BindingResult.class);
////        ObjectError objectError = new ObjectError("objectName", "error message");
////        when(bindingResult.hasErrors()).thenReturn(true);
////        when(bindingResult.getAllErrors()).thenReturn(Arrays.asList(objectError));
////
////        // Act
////        ResponseEntity<Object> response = supplierController.updateSupplier(id, supplier, bindingResult);
////
////        // Assert
////        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
////        Object responseBody = response.getBody();
////
////        // Check if the response body is a String and contains the expected error message
////        if (responseBody instanceof String) {
////            assertTrue(((String) responseBody).contains("error message"));
////        } else {
////            fail("Expected response body to be a String.");
////        }
////    }
////
////
////
////    @Test
////    public void testDeleteSupplier() {
////        // Arrange
////        String id = "123";
////        doNothing().when(signUpService).deleteSupplier(id);
////
////        // Act
////        ResponseEntity<Void> response = supplierController.deleteSupplier(id);
////
////        // Assert
////        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
////        verify(signUpService, times(1)).deleteSupplier(id);
////    }
////}
//import com.project.sustainability.controller.suppliercontroller.SupplierController;
//import com.project.sustainability.model.signup.SupplierData;
//import com.project.sustainability.service.supplierservice.SignUpService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//public class SupplierControllerTest {
//
//    @Mock
//    private SignUpService signUpService;
//
//    @Mock
//    private BindingResult bindingResult;
//
//    @InjectMocks
//    private SupplierController supplierController;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCreateOrUpdateSuppliers_Success() {
//        // Arrange
//        List<SupplierData> suppliers = new ArrayList<>();
//        when(bindingResult.hasErrors()).thenReturn(false);
//        when(signUpService.saveOrUpdateSuppliers(suppliers)).thenReturn(suppliers);
//
//        // Act
//        ResponseEntity<Object> response = supplierController.createOrUpdateSuppliers(suppliers, bindingResult);
//
//        // Assert
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(suppliers, response.getBody());
//    }
//
//    @Test
//    public void testCreateOrUpdateSuppliers_ValidationError() {
//        // Arrange
//        List<SupplierData> suppliers = new ArrayList<>();
//        when(bindingResult.hasErrors()).thenReturn(true);
//        when(signUpService.getErrorMessages(bindingResult)).thenReturn("Validation Error");
//
//        // Act
//        ResponseEntity<Object> response = supplierController.createOrUpdateSuppliers(suppliers, bindingResult);
//
//        // Assert
//        assertEquals(400, response.getStatusCodeValue());
//        assertEquals("Validation Error", response.getBody());
//    }
//
//    @Test
//    public void testGetSupplierById_Success() {
//        // Arrange
//        SupplierData supplier = new SupplierData();
//        when(signUpService.getSupplierById("1")).thenReturn(Optional.of(supplier));
//
//        // Act
//        ResponseEntity<SupplierData> response = supplierController.getSupplierById("1");
//
//        // Assert
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(supplier, response.getBody());
//    }
//
//    @Test
//    public void testGetSupplierById_NotFound() {
//        // Arrange
//        when(signUpService.getSupplierById("1")).thenReturn(Optional.empty());
//
//        // Act
//        ResponseEntity<SupplierData> response = supplierController.getSupplierById("1");
//
//        // Assert
//        assertEquals(404, response.getStatusCodeValue());
//    }
//
//    @Test
//    public void testGetAllSuppliers_Success() {
//        // Arrange
//        List<SupplierData> suppliers = new ArrayList<>();
//        when(signUpService.getAllSuppliers()).thenReturn(suppliers);
//
//        // Act
//        ResponseEntity<List<SupplierData>> response = supplierController.getAllSuppliers();
//
//        // Assert
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(suppliers, response.getBody());
//    }
//
//    @Test
//    public void testDeleteSupplier_Success() {
//        // Act
//        ResponseEntity<Void> response = supplierController.deleteSupplier("1");
//
//        // Assert
//        assertEquals(204, response.getStatusCodeValue());
//        verify(signUpService, times(1)).deleteSupplier("1");
//    }
//}
import com.project.sustainability.controller.suppliercontroller.SupplierController;
import com.project.sustainability.model.signup.SupplierData;
import com.project.sustainability.service.supplierservice.SignUpService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SupplierControllerTest {

    @Mock
    private SignUpService signUpService;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private SupplierController supplierController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrUpdateSuppliers_Success() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        when(bindingResult.hasErrors()).thenReturn(false);
        when(signUpService.saveOrUpdateSuppliers(suppliers)).thenReturn(suppliers);

        // Act
        ResponseEntity<Object> response = supplierController.createOrUpdateSuppliers(suppliers, bindingResult);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(suppliers, response.getBody());
    }

    @Test
    public void testCreateOrUpdateSuppliers_ValidationError() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        when(bindingResult.hasErrors()).thenReturn(true);
        when(signUpService.getErrorMessages(bindingResult)).thenReturn("Validation Error");

        // Act
        ResponseEntity<Object> response = supplierController.createOrUpdateSuppliers(suppliers, bindingResult);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Validation Error", response.getBody());
    }

    @Test
    public void testGetSupplierById_Success() {
        // Arrange
        SupplierData supplier = new SupplierData();
        when(signUpService.getSupplierById("1")).thenReturn(Optional.of(supplier));

        // Act
        ResponseEntity<SupplierData> response = supplierController.getSupplierById("1");

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(supplier, response.getBody());
    }

    @Test
    public void testGetSupplierById_NotFound() {
        // Arrange
        when(signUpService.getSupplierById("1")).thenReturn(Optional.empty());

        // Act
        ResponseEntity<SupplierData> response = supplierController.getSupplierById("1");

        // Assert
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testGetAllSuppliers_Success() {
        // Arrange
        List<SupplierData> suppliers = new ArrayList<>();
        when(signUpService.getAllSuppliers()).thenReturn(suppliers);

        // Act
        ResponseEntity<List<SupplierData>> response = supplierController.getAllSuppliers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(suppliers, response.getBody());
    }

    @Test
    public void testDeleteSupplier_Success() {
        // Arrange
        doNothing().when(signUpService).deleteSupplier("1");

        // Act
        ResponseEntity<Void> response = supplierController.deleteSupplier("1");

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(signUpService, times(1)).deleteSupplier("1");
    }

    @Test
    public void testDeleteSupplier_Failure() {
        // Arrange
        doThrow(new RuntimeException("Database error")).when(signUpService).deleteSupplier("1");

        // Act
        ResponseEntity<Void> response = supplierController.deleteSupplier("1");

        // Assert
        assertEquals(500, response.getStatusCodeValue());
    }
}
