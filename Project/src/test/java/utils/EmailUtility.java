package utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EmailUtility {

    public static void sendEmailWithReport(String reportPath, String recipientEmail) {
        try {
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(reportPath); // Path to the report file
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(Root.prop.getProperty("emailDescription"));
            attachment.setName(Root.prop.getProperty("reportName"));

            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.gmail.com"); // SMTP server
            email.setSmtpPort(465); // SMTP port
            email.setSSLOnConnect(true); // Enable SSL
            email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator(Root.prop.getProperty("senderEmail"), Root.prop.getProperty("senderPassword"))); // Authentication
            email.addTo(recipientEmail, Root.prop.getProperty("receiverName")); // Recipient email
            email.setFrom(Root.prop.getProperty("senderEmail"), Root.prop.getProperty("senderName")); // Sender email
            email.setSubject(Root.prop.getProperty("emailSubject")); // Email subject
            email.setMsg(Root.prop.getProperty("emailBody")); // Email body

            email.attach(attachment);
            email.send();
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}