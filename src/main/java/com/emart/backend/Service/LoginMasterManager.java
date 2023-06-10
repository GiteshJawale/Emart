package com.emart.backend.Service;

import org.springframework.http.ResponseEntity;

import com.emart.dto.LoginRequest;
import com.emart.dto.LoginResponse;
public interface LoginMasterManager {
	ResponseEntity<LoginResponse> login(LoginRequest request);

}

