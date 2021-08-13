package com.book.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.microservice.model.DBConfigure;



@Repository
public interface DBConfigRepository extends JpaRepository<DBConfigure,Long>{

	 @Query(value="SELECT * from dbconfig where Microservices = ?1 and mem > \r\n"
	    		+ "(SELECT AVG(mem) from dbconfig where Microservices = ?1 and CPU > \r\n"
	    		+ "(SELECT AVG(CPU) from dbconfig where  Microservices = ?1 and (response > \r\n"
	    		+ "(SELECT AVG(response) FROM dbconfig WHERE Microservices = ?1) or \r\n"
	    		+ "throughtput < (SELECT AVG(throughtput) FROM dbconfig WHERE Microservices = ?1))));",nativeQuery=true)
		List<DBConfigure> findByBookShop(String Microservices);
	 
	 
	  @Query(value="SELECT * FROM dbconfig WHERE Microservices = ?1",nativeQuery=
	  true) List<DBConfigure> findByBooksShop(String Microservices);
	   
	  @Query(value="SELECT AVG(response) FROM dbconfig WHERE Microservices = ?1"
	  ,nativeQuery=true) Double calculateAverageResponse(String Microservices);
	  
	  @Query(value="SELECT AVG(response) FROM dbconfig WHERE Microservices = ?1"
			  ,nativeQuery=true) Double calculateAverageCpu(String Microservices);
	  
	  @Query(value="SELECT AVG(response) FROM dbconfig WHERE Microservices = ?1"
			  ,nativeQuery=true) Double calculateAverageMemory(String Microservices);
	  
	  @Query(value="SELECT AVG(throughtput) FROM dbconfig WHERE Microservices = ?1"
	  ,nativeQuery=true) Double calculateAverageThroughPut(String Microservices);
	 
	
	
	
	
	
	
}

