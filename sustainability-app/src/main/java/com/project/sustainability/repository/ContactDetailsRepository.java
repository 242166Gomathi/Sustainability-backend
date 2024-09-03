package com.project.sustainability.repository;

import com.project.sustainability.model.ContactDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactDetailsRepository extends MongoRepository<ContactDetails, String> {
}
