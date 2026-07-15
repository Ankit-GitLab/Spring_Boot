package com.example.loose;

public class EmailNotificationService implements com.example.loose.NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email: "+message);
    }
}
