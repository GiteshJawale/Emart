package com.emart.backend.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.User;
import com.emart.backend.Repository.Userrepository;
import com.emart.dto.LoginRequest;
import com.emart.dto.LoginResponse;



@Service
public class LoginMasterManagerImpl implements LoginMasterManager  
{

	@Autowired
	private Userrepository repository;
	
//	@Autowired
//	BCryptPasswordEncoder passwordencoder;
	
public ResponseEntity<LoginResponse> login(LoginRequest request) 
{ 
	String passwordHash = hash256(request.getPassword()); // hash the password using SHA-256
	User person = repository.findAll().stream()
			.filter(user -> user.getUsername().equals(request.getUsername()) && user.getPassword().equals(passwordHash))
			.findFirst()
			.orElse(null);
	//System.out.print(person);

	if (person != null && person.getUsername().equals(request.getUsername()) && person.getPassword().equals(passwordHash)) 
	{
			return ResponseEntity.ok().body(new LoginResponse(true, person));
	} 
	else 
	{
		return ResponseEntity.ok().body(new LoginResponse(false, null));
	}
}
private String hash256(String password)
{
	try
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		StringBuilder hexstring = new StringBuilder();
		for(byte b : hash)
		{
			String hex =Integer.toHexString(0xff & b);
			if(hex.length()==1)
				hexstring.append('0');
			hexstring.append(hex);
		}
		return hexstring.toString();
	}
	catch(NoSuchAlgorithmException e)
	{
		throw new RuntimeException(e);
	}
	
	//return null;
}

}
