package com.ecom.ecommerce.libraries;

public class Sendgrid {

    public void sendEmailAsync(String email, String subject, String body) {
        System.out.println("Sending email to " + email + " with subject " + subject + " and body " + body);
    }
}
