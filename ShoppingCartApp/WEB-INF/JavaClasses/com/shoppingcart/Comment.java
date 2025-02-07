package com.shoppingcart;
// This class shows a user comment in the shopping system.
// This features content, information and timestamps of when the comment has been done.
// The methods are getText, getUser, getTimestamp, setText and displayComment.


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Comment {
    private String text;
    private String user; 
    private LocalDateTime timestamp; 
    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
        this.timestamp = LocalDateTime.now(); 
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

 
    public void setText(String text) {
        this.text = text;
    }

    
    public void displayComment() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);
        System.out.println(user + " (" + formattedTimestamp + "): " + text);
    }
}
