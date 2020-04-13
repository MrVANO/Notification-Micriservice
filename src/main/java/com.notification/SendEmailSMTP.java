package com.notification;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailSMTP {
    // for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.yandex.ru";
    private static final String USERNAME = "vanesfrol11";
    private static final String PASSWORD = "mmedymbfwxjehywi";

    private static final String EMAIL_FROM = "vanesfrol11@yandex.ru";

    public String sendMessage(String recipientAddress, String subject, String text) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.yandex.ru");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vanesfrol11@yandex.ru","mmedymbfwxjehywi");
            }
        }); // default session
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientAddress, false));

            // subject
            msg.setSubject(subject);

            // content
            msg.setText(text);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());
            String returnMessage = "Response: " + t.getLastServerResponse();

            t.close();

            return returnMessage;
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


}