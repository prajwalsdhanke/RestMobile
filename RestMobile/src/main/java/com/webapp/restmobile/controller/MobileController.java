package com.webapp.restmobile.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.restmobile.model.Mobile;
import com.webapp.restmobile.service.MobileService;

@RestController
@RequestMapping(value = "/mobile")
public class MobileController {
	@Autowired
	private MobileService mobileService;

	@DeleteMapping(value = "/deleteMobile/{mobileId}")
	public void deleteUpdate(@PathVariable Integer mobileId) {
		mobileService.deleteMobile(mobileId);
	}

	@PutMapping(value = "/updateMobile/{mobileId}")
	public void updateMobile(@PathVariable Integer mobileId, @RequestBody Mobile mobile,
			@RequestParam("mobileImageName") MultipartFile file) {

		mobile.setMobileId(mobileId);
		mobileService.saveMobile(mobile, file);
	}

	@GetMapping(value = "/getMobiles")
	public List<Mobile> getMobiles() {
		return mobileService.getMobiles();
	}

	@PostMapping(value = "/saveMobile", consumes = { "multipart/form-data" })
	public void saveMobile(@ModelAttribute("mobile") Mobile mobile,
			@RequestPart("mobileImageName") MultipartFile file) {

		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		mobileService.saveMobile(mobile, file);
	}

	@GetMapping(value = "/getMobile/{mobileId}")
	public ResponseEntity<Mobile> getMobile(@PathVariable Integer mobileId) {
		try {
			Mobile mobile = mobileService.getMobile(mobileId);
			return new ResponseEntity<Mobile>(mobile, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Mobile>(HttpStatus.NOT_FOUND);
		}
	}

}
