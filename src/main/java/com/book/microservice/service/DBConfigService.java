package com.book.microservice.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.microservice.model.DBConfigure;
import com.book.microservice.model.FaultDetection;
import com.book.microservice.repository.DBConfigRepository;


@Service
public class DBConfigService {

	@Autowired
	DBConfigRepository repository;
	
	public List<DBConfigure> getAllMicroservice()
	{
		List<DBConfigure> list = repository.findAll();
		if(list.size() > 0)
		{
			return list;
		}else {
			 return new ArrayList<DBConfigure>();
		}
	}
		
	public List<FaultDetection> getfaultDetection(String microservice)
	{
	      List<DBConfigure> bookUIList = repository.findByBooksShop(microservice);
	      List<FaultDetection> returnArray = new ArrayList<>();
		  Double response = repository.calculateAverageResponse(microservice); 
		  Double throughput = repository.calculateAverageThroughPut(microservice);
		  Double cpu = repository.calculateAverageCpu(microservice); 
		  Double memory = repository.calculateAverageMemory(microservice);
		  for(DBConfigure db: bookUIList) {
			  FaultDetection fd = new FaultDetection();
			  fd.setMicroservice_name(microservice);
			  fd.setCpu(db.getCPU());
			  fd.setMemory(db.getMem());
		  if(Double.parseDouble(db.getResponse()) > response ||
		  Double.parseDouble(db.getThroughtput()) < throughput)
		  {
			   if(Double.parseDouble(db.getCPU()) > cpu)
			   {
				   if(Double.parseDouble(db.getMem()) > memory)
				   {
					   fd.setRoot_cause("error in cpu & memory");
				   }else
				   {
					   fd.setRoot_cause("error in cpu");
				   }
			   }else {
				   if(Double.parseDouble(db.getMem()) > memory)
				   {
					   fd.setRoot_cause("error in memory");
				   }else
				   {
					   fd.setRoot_cause("error in system");
				   }
			   }
		  }
		  else { 
			    fd.setRoot_cause("no performance issue"); 
		     }
		      returnArray.add(fd);
		  }
	     
			return returnArray;
	}
}

