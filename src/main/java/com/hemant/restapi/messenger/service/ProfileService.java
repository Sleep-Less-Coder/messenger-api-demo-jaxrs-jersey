package com.hemant.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hemant.restapi.messenger.database.DatabaseClass;
import com.hemant.restapi.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		
	}
	
	//get all profiles
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	//get a single profile
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	//add a new profile
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	//update a profile
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	//delete a profile
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
