package br.com.synergy.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ChatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String chat;
	
	public ChatBean(){
		chat = new String();
		
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}
	
	

}
