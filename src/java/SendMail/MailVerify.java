/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMail;

import Entity.Mail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author zhadu
 */
public class MailVerify {

    //generate vrification code
    //send email to the user email
    public void sendEmail(String email, String newpass) {

        // Recipient's email ID needs to be mentioned.
        String toEmail = email;//change accordingly

//        String toEmail = "haildhe141223@fpt.edu.vn";
        // Sender's email ID needs to be mentioned
        String from = "zhaduchanhzzzzz@gmail.com";
        final String username = "zhaduchanhzzzzz@gmail.com"; //replace mail here
        final String password = "hanhmai123@"; //enter mail pass here

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            // Set Subject: header field
            message.setSubject("Shop HADUCHANH New password");

            // Now set the actual message
            message.setText("Your new pass word is: " + newpass + "");
            message.setReplyTo(message.getFrom());
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
