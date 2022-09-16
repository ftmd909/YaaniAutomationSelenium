package Utils.mailler;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class Mailler {

    public static void send(String sub,String fileOutput){
        String from="fatma.automation@gmail.com"; //Mail Gönderen Hesap Bilgileri//
        String pass="kkvjtzzxxcbrypig"; //Gmail den alınan token//
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.from", from);
        //get Session
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,pass);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("fatma.automation@gmail.com"));
            //message.addRecipient(Message.RecipientType.CC,new InternetAddress("cc"));

            message.setSubject(sub);
            Multipart multipart = new MimeMultipart();
            String htmlContent = "<b>Test Otomasyon Raporu</b>";
            BodyPart messageBodyPart = new MimeBodyPart();
            BodyPart attachmentBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlContent , "text/html");
            multipart.addBodyPart(messageBodyPart);
            DataSource source = new FileDataSource(fileOutput);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(new File(fileOutput).getName());
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}

    }

}
