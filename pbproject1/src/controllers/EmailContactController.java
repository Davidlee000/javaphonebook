package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.*;
import models.*;
import javax.mail.util.ByteArrayDataSource;

import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;


public class EmailContactController {
    private EmailContactView ecv;
    
    EmailContactController(EmailContactView ecv) {
        this.ecv = ecv;
        ecv.SendEmailListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });

        ecv.addBackListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ecv.setVisible(false);
                ContactView cv = new ContactView(ecv.getUser());
                cv.setVisible(true);
                ContactController cc = new ContactController(cv);
            }
        });
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public void sendEmail() {
        String to = ecv.getEmail();
        if (!isValidEmail(to)) {
            JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String from = "00leedavid@gmail.com"; 
        String password = "zamrhozpavukhaqq";
        ContactDataAccess contactDataAccess = new ContactDataAccess();
        User user = ecv.getUser();
        int id = user.getId();
        List<Contact> contacts = contactDataAccess.getContact(id);
        String csv = "First Name, Last Name, Phone Number, Address, Email\n";
                    for (Contact contact : contacts) {
                        csv+=(contact.getFirstname() + "," + contact.getLastname() + ", " + contact.getPhone() + ","+ contact.getAddress() + ","+ contact.getEmail()+"\n");
                    }


        String subject = "Contacts List";
        String message = "Here is the list of contacts";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message);
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachFilePart = new MimeBodyPart();
            attachFilePart.setDataHandler(new DataHandler(new ByteArrayDataSource(csv.getBytes(), "text/csv")));
            attachFilePart.setFileName("data.csv");
            multipart.addBodyPart(attachFilePart);
            
            msg.setContent(multipart);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);

            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Email sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            ecv.setVisible(false);
            ContactView cv = new ContactView(ecv.getUser());
            cv.setVisible(true);
            ContactController cc = new ContactController(cv);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
    
}