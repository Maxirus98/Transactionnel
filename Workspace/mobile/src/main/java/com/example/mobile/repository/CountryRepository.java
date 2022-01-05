package com.example.mobile.repository;

import com.example.mobile.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "listCountries", path="listCountries")
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
