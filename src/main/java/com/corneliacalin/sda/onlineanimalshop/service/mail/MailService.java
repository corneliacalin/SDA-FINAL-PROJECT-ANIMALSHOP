package com.corneliacalin.sda.onlineanimalshop.service.mail;


import com.corneliacalin.sda.onlineanimalshop.config.MailProperties;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Service
public class MailService
{
    private final MailProperties mailProperties;

    public MailService(MailProperties mailProperties)
    {
        this.mailProperties = mailProperties;
    }

    public void sendMail(String from, String to, String subject, String content) throws MessagingException
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", mailProperties.isAuth());
        properties.put("mail.smtp.starttls.enable", mailProperties.isStarttls());
        properties.put("mail.smtp.host", mailProperties.getHost());
        properties.put("mail.smtp.port", mailProperties.getPort());
        properties.put("mail.smtp.ssl.trust", mailProperties.getTrust());

        Session session = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(mailProperties.getUsername(), mailProperties.getPassword());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(content, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
