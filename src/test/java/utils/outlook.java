//
//import java.io.File;
//import java.util.Properties;
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.*;
//import javax.mail.internet.*;
//
//public class outlook {
//
//    public static void sendReportByEmail(String[] toEmails, String subject, String body, String filePath, String fileName) {
//        String from = "ashritha@quality-matrix.com"; // Your Outlook email address
//        String password = "quality@200394"; // Your Outlook password
//
//        Properties props = new Properties();
//
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.office365.com");
//        props.put("mail.smtp.port", "587");
//
//
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, password);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            for (String toEmail : toEmails) {
//                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//            }
//            message.setSubject(subject);
//
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText(body);
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//
//            if (filePath != null && !filePath.isEmpty()) {
//                messageBodyPart = new MimeBodyPart();
//                DataSource source = new FileDataSource(filePath);
//                messageBodyPart.setDataHandler(new DataHandler(source));
//                messageBodyPart.setFileName(fileName);
//                multipart.addBodyPart(messageBodyPart);
//            }
//
//            message.setContent(multipart);
//
//            Transport.send(message);
//            System.out.println("Outlook: Email sent successfully to: " + String.join(", ", toEmails));
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//}

package utils;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class outlook {

    public static void sendReportByEmail(String[] toEmails, String subject, String body, String filePath, String fileName) {
        String from = "ashritha@quality-matrix.com";
        String password = "quality@200394";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for (String toEmail : toEmails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            }
            message.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (filePath != null && !filePath.isEmpty()) {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(filePath);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                multipart.addBodyPart(messageBodyPart);
            }

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Outlook: Email sent successfully to: " + String.join(", ", toEmails));

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
