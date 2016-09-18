package ua.artcode.utils.smtp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class SMTPSender implements ISMTPController {

    private String userName;
    private String passWord;
    private Session session;

    public SMTPSender(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        this.session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, passWord);
                    }
                });
    }

    @Override
    public boolean sentMessage(String to, String subject, String text, String signature) {

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(signature);

            Transport.send(message);

            return true;

        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}
