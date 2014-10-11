package com.apatil.notynotes.data;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteItem {
	
	//Each new note has a key which is a timestamp and value which can be any string
	private String key;
	private String text;
	
	//Getters and Setters to make the key and text available anywhere in the application
	public String getKey() {
		return key;
	} 
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//For each new note, get the timestamp and set it as a key. Easily sortable later
	@SuppressLint("SimpleDateFormat")
	public static NoteItem getNew(){
		Locale locale = new Locale("en_US");   //en_US gives us a timestamp that is easily sortable
		Locale.setDefault(locale);
		
		//Getting the formatted date
		String pattern = "yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String key = formatter.format(new Date());
		
		//Creating the note object
		NoteItem note = new NoteItem();
		note.setKey(key);
		note.setText("");
		return note;
	}
	
	//Displays the actual list item
	@Override
	public String toString() {
		return this.getText();
	}

}
