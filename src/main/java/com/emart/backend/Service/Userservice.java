package com.emart.backend.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.backend.Entity.User;
import com.emart.backend.Repository.Userrepository;



@Service
public class Userservice {

	@Autowired
	private Userrepository userrepository;

	
	 public List<User> getAllUser() {
	        return userrepository.findAll();
	    }

	    public Optional<User> getUserById(String id) {
	        return userrepository.findById(id);
	    }

	    public User createUser(User user) {
	    	String password= user.getPassword();
			user.setPassword(sha256(password));
	        return userrepository.save(user);
	    }

	    public User updateUser(String id, User user) {
	    	Optional<User> optionalUser = userrepository.findById(id);
	    	if (optionalUser.isPresent()) {
	    		User existingUser = optionalUser.get();
	    		existingUser.setPassword(user.getPassword());
	            return userrepository.save(existingUser);
	        } else {
	            throw new RuntimeException("Product not found with id: " + id);
	        }
	    }

	    public void deleteUser(String id) {
	    	userrepository.deleteById(id);
	    }
	    
	    private String sha256(String password)
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
		}
	
}
