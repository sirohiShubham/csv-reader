package com.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRecordsRepository extends JpaRepository<SalesRecords, Long> {

}
