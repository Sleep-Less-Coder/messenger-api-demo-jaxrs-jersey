package com.hemant.restapi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.hemant.restapi.messenger.database.DatabaseClass;
import com.hemant.restapi.messenger.model.Message;

public class MessageService {
	
	//get messages from DB class
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {

	}
	
	//returns all messages as an array list
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	//get a message with a id
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	//add a new message
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	//update a message
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	//remove a message
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
	
	//get messages for a year
	public List<Message> getMessagesFromAYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();
		
		for(Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	//pagination of messages
	public List<Message> getPaginatedMessages(int start, int size) {
		List<Message> list = new ArrayList<Message>(messages.values());
		
		if(start + size > list.size()) {
			return new ArrayList<Message>();
		}
		
		return list.subList(start, start + size);
	}
}
