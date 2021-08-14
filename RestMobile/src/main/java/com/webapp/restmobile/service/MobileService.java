package com.webapp.restmobile.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.restmobile.model.Mobile;
import com.webapp.restmobile.repository.MobileRepository;

@Service
public class MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	private final Path path = Paths.get("upload");

	public void saveMobile(Mobile mobile, MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));

			String fileName = file.getOriginalFilename();
			

			mobile.setMobileImageName(fileName);

			mobileRepository.save(mobile);
		} catch (IOException e) {
			throw new RuntimeException("File cannot be stored. Error: " + e.getMessage());
		}

	}

	public void deleteMobile(Integer mobileId) {
		mobileRepository.deleteById(mobileId);
	}

	public List<Mobile> getMobiles() {
		return mobileRepository.findAll();
	}

	public Mobile getMobile(Integer mobileId) {
		return mobileRepository.findById(mobileId).get();
	}
}
