package com.performance.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.performance.management.model.Institution;

public interface InstitutionRepository
    extends MongoRepository<Institution, String> {
}