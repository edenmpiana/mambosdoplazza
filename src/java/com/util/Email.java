/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import static org.hibernate.internal.CoreLogging.logger;

/**
 *
 * @author mariompi
 */

public class Email {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       try {
            String to="douglastoco12@gmail.com";
            String from="edenmpiana@outlook.pt";

            Properties props = new Properties();
//            props.put("mail.smtp.socketFactory.port", "587");
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.socketFactory.fallback", "true");
            props.put("mail.smtp.host", "smtp-mail.outlook.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("edenmpiana@outlook.pt","140995SLB");
                        }
                    });

//            Session emailSession = Session.getDefaultInstance(props, null);

            String msgBody = "Olá Xibú, estou testando o envio de mails... Tens amigos gays??";

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, "Mambos do Plazza"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to, "Mr. Recipient"));
            msg.setSubject("Testando Funcionalidade de Envio de Mails");
            msg.setText(msgBody);
            Transport.send(msg);
            System.out.println("Email sent successfully...");
            
        } catch (Exception e) {
           e.printStackTrace();
        
    }
    
} }
