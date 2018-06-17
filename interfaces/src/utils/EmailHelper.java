package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EmailHelper {
	
	public static void sendEmail(String host, String port,String sender,
            ArrayList recipientList,ArrayList ccList, String subject, String message, File attachFile, File attachFile2, File attachFile3, ArrayList attachmentList)
                    throws AddressException, MessagingException {
		final String emailUsername="noreply@scube.com.sg";
		final String emailPassword="Jonger123";
		
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", emailUsername);
        properties.put("mail.password", emailPassword);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailUsername, emailPassword);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(emailUsername));
        
        if(Validator.isNotNull(recipientList)){
        	for(int z=0; z<recipientList.size(); z++){
        		String recipient = (String)recipientList.get(z);
        		InternetAddress[] toAddresses = { new InternetAddress(recipient)};
        		 msg.setRecipients(Message.RecipientType.TO, toAddresses);
        	}
        }
        if(Validator.isNotNull(ccList)){
        	for(int z=0; z<ccList.size(); z++){
        		String recipient = (String)ccList.get(z);
        		InternetAddress[] toAddresses = { new InternetAddress(recipient)};
        		 msg.setRecipients(Message.RecipientType.CC, toAddresses);
        	}
        }
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFile != null) {
            MimeBodyPart attachPart = new MimeBodyPart();
 
            try {
                attachPart.attachFile(attachFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
 
            multipart.addBodyPart(attachPart);
        }
        if (attachFile2 != null) {
            MimeBodyPart attachPart2 = new MimeBodyPart();
 
            try {
            	attachPart2.attachFile(attachFile2);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
 
            multipart.addBodyPart(attachPart2);
        }
        if (attachFile3 != null) {
            MimeBodyPart attachPart3 = new MimeBodyPart();
 
            try {
            	attachPart3.attachFile(attachFile3);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
 
            multipart.addBodyPart(attachPart3);
        }
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
        if(Validator.isNotNull(sender)){
            msg.setReplyTo(new javax.mail.Address[]{
            		new javax.mail.internet.InternetAddress(sender)
            		
            });
            }
        // sends the e-mail
        try{
        Transport.send(msg);
        }catch(Exception ex){}
    }
}
