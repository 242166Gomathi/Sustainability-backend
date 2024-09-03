package com.project.sustainability.repository;



import com.project.sustainability.model.SupplierData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierDataRepository extends MongoRepository<SupplierData, String> {
}
