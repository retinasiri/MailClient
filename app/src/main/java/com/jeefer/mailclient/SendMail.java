package com.jeefer.mailclient;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    //initialisation des variables
    String emailPort = "587"; // gmail's smtp port
    String smtpAuth = "true";
    String starttls = "true";
    String emailHost = "smtp.gmail.com";

    String fromEmail;
    String fromPassword;
    String toEmail;
    String emailSubject;
    String emailBody;

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public SendMail () {

    }

    public SendMail (String fromEmail, String fromPassword, String toEmail, String emailSubject, String emailBody) {

        // 1 -> Création de la session

        this.fromEmail = fromEmail;
        this.fromPassword = fromPassword;
        this.toEmail = toEmail;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

        //set mail server property
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);
        Log.i("GMail", "Mail server properties set.");

    }

    public MimeMessage createEmailMessage() throws AddressException, MessagingException, UnsupportedEncodingException {

        // 2 -> Creation du message

        mailSession = Session.getDefaultInstance(emailProperties, null);

        emailMessage = new MimeMessage(mailSession);

        try {

            emailMessage.setFrom(new InternetAddress(fromEmail, fromEmail));
            Log.i("GMail","toEmail: "+toEmail);
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            emailMessage.setSubject(emailSubject);
            //emailMessage.setContent(emailBody, "text/html");// for a html email
            emailMessage.setText(emailBody);// for a text email
            Log.i("GMail", "Email Message created.");

        }catch (MessagingException e){
            e.printStackTrace();
        }


        return emailMessage;
    }

    //public void sendMessage() throws AddressException, MessagingException {

    public void sendMessage() throws AddressException, MessagingException {

        // 3 -> Envoi du message

        Transport transport = mailSession.getTransport("smtp");

        try{
            transport.connect(emailHost, fromEmail, fromPassword);
            Log.i("GMail", "allrecipients: " + emailMessage.getAllRecipients());
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());

        }catch (MessagingException e){
            e.printStackTrace();

        }finally {
            try {
                if (transport != null) {
                    transport.close();
                    Log.i("GMail", "Email sent successfully.");
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }


    }



}
