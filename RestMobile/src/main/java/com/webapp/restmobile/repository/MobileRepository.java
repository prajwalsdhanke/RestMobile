package com.webapp.restmobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.restmobile.model.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
