package b_utilities;

import java.io.File;
import java.util.Properties;
import java.util.ResourceBundle;


import a_testbase.BaseClass;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;


public class EmailReportSender extends BaseClass {

    private static ResourceBundle rb;

    public static ResourceBundle getResourceBundle() {
        return rb;
    }
    
    public static void main(String[] args) {
		sendReport();
	}

    public static void sendReport() {

        logger.info("Email sender started...");

        // ✅ Load config.properties
        rb = ResourceBundle.getBundle("config");

        // ✅ Read values from config
        String username = rb.getString("mailusername");
        String password = rb.getString("mailpassword");
        String recipientsConfig = rb.getString("recipients"); // comma separated

        // ✅ Convert recipients string → array
        String[] recipients = recipientsConfig.split(",");

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            // ✅ Add multiple recipients
            for (String mail : recipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.trim()));
            }

            message.setSubject("IAPP Automation Suite - Execution Report");

            Multipart multipart = new MimeMultipart();

            // ✅ Email Body
            String bodyText = """
                    Hi Team,

                    The IAPP Automation Test Suite execution has completed successfully.

                    Please find the attached reports for detailed results:
                    • Automation Excel Report
                    • Extent Execution Report

                    Kindly review and reach out for any clarification.

                    Thanks and Regards,
                    Automation QA Team
                    Innodata
                    """;
            
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(bodyText);
            multipart.addBodyPart(bodyPart);

            // ✅ Attach reports
            String reportFolder = System.getProperty("user.dir") + "/reports";
            File folder = new File(reportFolder);

            if (folder.exists() && folder.isDirectory()) {

                File[] files = folder.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {

                            MimeBodyPart attachmentPart = new MimeBodyPart();
                            DataSource source = new FileDataSource(file);

                            attachmentPart.setDataHandler(new DataHandler(source));
                            attachmentPart.setFileName(file.getName());

                            multipart.addBodyPart(attachmentPart);

                            logger.info("Attached File: {}", file.getName());
                        }
                    }
                }
            }

            message.setContent(multipart);

            Transport.send(message);

            // ✅ SUCCESS LOG + CONSOLE
            logger.info("✅ Automation Report Email Sent Successfully");
           logger.debug("✅ EMAIL SENT SUCCESSFULLY");

        } catch (Exception e) {
        	logger.error("❌ Email Sending Failed: {}", e.getMessage(), e);
           logger.debug("❌ EMAIL SENDING FAILED");

        }
    }
}