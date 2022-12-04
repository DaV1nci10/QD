package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.SearchPatient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchPatientDtoRepository extends ElasticsearchRepository<SearchPatient, String> {


}
