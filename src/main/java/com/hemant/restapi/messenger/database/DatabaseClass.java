package com.hemant.restapi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.hemant.restapi.messenger.model.Comment;
import com.hemant.restapi.messenger.model.Message;
import com.hemant.restapi.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comment> comments = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	// initialize some messages in the messages map
	static {
		// some comments
		comments.put(1L, new Comment(1L, "Nice message!", "john"));
		comments.put(2L, new Comment(2L, "WTH?", "macy"));
		comments.put(3L, new Comment(3L, "Cool", "patrick"));
		
		//setting the comments for the message 1L
		Message message = new Message(1L, "Hello World!", "hemant");
		message.setComments(comments);
		
		messages.put(1L, message);
		messages.put(2L, new Message(2L, "Jersey is cool!", "hemant"));
		messages.put(3L, new Message(3L, "My first RESTful web service!", "hemant"));
	}

	// initialize some profiles in the profiles map
	static {
		profiles.put("hemant", new Profile(1L, "hemant", "Hemant", "Acharya"));
		profiles.put("alex", new Profile(2L, "alex", "Alexander", "Jhonshon"));
		profiles.put("john", new Profile(3L, "john", "John", "Cena"));
	}
}
