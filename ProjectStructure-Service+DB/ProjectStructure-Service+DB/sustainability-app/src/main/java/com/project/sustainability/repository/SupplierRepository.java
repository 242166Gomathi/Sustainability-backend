package com.project.sustainability.repository;

import com.project.sustainability.model.signup.SupplierData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for SupplierData, extending MongoRepository for CRUD operations.
 */
@Repository
public interface SupplierRepository extends MongoRepository<SupplierData, String> {
}
