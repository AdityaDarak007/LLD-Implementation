package com.ecom.ecommerce.services;

import com.ecom.ecommerce.libraries.Sendgrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendGridService implements EmailService {
    private Sendgrid sendgrid;

    @Autowired
    public SendGridService(Sendgrid sendgrid) {
        this.sendgrid = sendgrid;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendgrid.sendEmailAsync(to, subject, body);
    }
}
