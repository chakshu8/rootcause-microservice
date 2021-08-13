package com.book.microservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.microservice.model.DBConfigure;
import com.book.microservice.model.FaultDetection;
import com.book.microservice.service.DBConfigService;


@RestController
@RequestMapping("/dbconfig")
public class DBConfigController {
	
	 @Autowired 
	 DBConfigService service;

	 
	 @GetMapping("/{micro}")
	 public ResponseEntity<List<FaultDetection>> getAllRequests(@PathVariable("micro") String micro) {
			 List<FaultDetection> list = service.getfaultDetection(micro); 
		  return new ResponseEntity<List<FaultDetection>>(list, new HttpHeaders(),
		  HttpStatus.OK); 
		  }
}
