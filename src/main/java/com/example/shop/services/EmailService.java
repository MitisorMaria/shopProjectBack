package com.example.shop.services;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(String address, String message) throws MessagingException;
}