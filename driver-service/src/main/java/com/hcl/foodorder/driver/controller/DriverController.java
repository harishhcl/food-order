package com.hcl.foodorder.driver.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.driver.Driver;
import com.hcl.foodorder.domain.exception.DriverDetailsNotFoundException;
import com.hcl.foodorder.domain.exception.DuplicateDriverCreationException;
import com.hcl.foodorder.driver.service.DriverService;

/**
 * controller class to accept the request from external system
 * 
 * @author hari
 *
 */
@RestController
@RequestMapping("/drivers/v1")
public class DriverController {
	private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
	@Autowired
	private DriverService driverService;

	@PostMapping("/create")
	public ResponseEntity<Driver> create(@Validated @RequestBody Driver driver) throws DuplicateDriverCreationException {
		logger.info("invoked create api");
		return new ResponseEntity<>(driverService.create(driver), HttpStatus.CREATED);
	}

	@GetMapping("/get/{mobileNumber}")
	public ResponseEntity<Driver> getDriver(@PathVariable("mobileNumber") String mobileNumber)
			throws DriverDetailsNotFoundException {
		logger.info("invoked get api");
		return new ResponseEntity<>(driverService.getDriverDetails(mobileNumber), HttpStatus.OK);
	}

	@GetMapping("/getavaiabledrivers")
	public ResponseEntity<List<Driver>> getAvaiableDrivers(@RequestParam(required = false) String lat, @RequestParam(required = false) String lon, @RequestParam(required = false) String dis) {
		logger.info("invoked get all available drivers api");
		//if(StringUtils.isBlank(lat) || StringUtils.isBlank(lon) || StringUtils.isBlank(dis)) {
		if(lat==null || lon== null || dis == null) {
			//get list of all available drivers
			return new ResponseEntity<>(driverService.getAllFreeDrivers(), HttpStatus.OK);
		}
		return new ResponseEntity<>(driverService.getAllFreeDrivers(lat,lon,dis), HttpStatus.OK);
		
	}
}
