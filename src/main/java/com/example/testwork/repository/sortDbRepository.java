package com.example.testwork.repository;

import com.example.testwork.models.SortDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface sortDbRepository extends CrudRepository<SortDB,Long> {



}
