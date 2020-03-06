package com.jrljs.microproduct.barometer.controller;

import com.jrljs.microproduct.barometer.entity.BarometerInfo;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path="/test")
public class BarometerController {
	private static Logger logger = Logger.getLogger(BarometerController.class);
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/info")
    public ResponseEntity<?> getBarometerInfo() {
		long t1 = System.currentTimeMillis();
		
		logger.info("BarometerController->getBarometerInfo start" + t1);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
	    try{
	    	BarometerInfo barometerInfo = new BarometerInfo();
	    	barometerInfo.setBarometercode("01");
	    	barometerInfo.setBarometername("晴天");
	    	barometerInfo.setBarometerReason("股市行情预测");
	    	
	    	if(barometerInfo != null){
	   
		        map.put("msgCode", "1");
				
				map.put("msgInfo", "成功！");	
				
				map.put("data", barometerInfo);
	    	}
	    
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	
	    	map.put("msgCode", "-1");
			
			map.put("msgInfo", "获取数据失败！");			
	    }	
	    long t2 = System.currentTimeMillis() - t1;
	    
		logger.debug("BarometerController->getBarometerInfo end" + t2);
	
		return new ResponseEntity(map, HttpStatus.OK);		
       
    }	
	

	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@RequestMapping(value = "/serviceSpecs", method = RequestMethod.GET)
	@GetMapping(value = "/test")
	@ResponseBody
	public ResponseEntity<?> getServiceSpecs() {
				
		Map map = new HashMap<String, Object>();
	   
        map.put("msgCode", "1");
		map.put("msgInfo", "成功！");	
		map.put("data", "test k8s");	   

		return new ResponseEntity(map, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//@RequestMapping(value = "/serviceSpecs", method = RequestMethod.GET)
	@GetMapping(value = "/cal/{a}/{b}")
	@ResponseBody
	public ResponseEntity<?> cal(@PathVariable("a")Integer a , @PathVariable("b")Integer b) {
				
		Map map = new HashMap<String, Object>();
		
		Integer c = a + b;
	   
        map.put("msgCode", "1");
		map.put("msgInfo", "成功！");	
		map.put("data", c);	   

		return new ResponseEntity(map, HttpStatus.OK);
	}
	
}



