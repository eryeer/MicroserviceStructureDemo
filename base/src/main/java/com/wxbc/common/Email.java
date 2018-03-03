package com.wxbc.common;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class Email{
    private static final String SMTP_HOST = AppPropReader.getEmailHost();
    private static final String MAIL_USER_NAME = AppPropReader.getEmailUserName();
    private static final String MAIL_PW = AppPropReader.getEmailPw();
    private static final String MAIL_PROTOCAL= AppPropReader.getEmailProtocal();
    private static final String MAIL_AUTH= AppPropReader.getEmailAuth();
    private static final String MAIL_PORT= AppPropReader.getEmailPort();

    public static void sendEmail(String toEmail, String subject, String messageText) throws Exception {
        Transport transport = null;
        try{
            // 第一步：配置javax.mail.Session对象
            Properties props = Email.getMailProperties(SMTP_HOST, MAIL_PROTOCAL, MAIL_AUTH, MAIL_PORT);
            // 构建Session对象
            Session session = Session.getInstance(props);

            // 构建Message对象, 设置邮件基本信息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MAIL_USER_NAME));
            message.addRecipient(RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(MimeUtility.encodeText(subject, MimeUtility.mimeCharset("gb2312"), null));
            message.setContent(messageText, CommonConst.EMAIL_CONTENT_TYPE);

            // 发送邮件
            transport = session.getTransport();
            transport.connect(MAIL_USER_NAME, MAIL_PW);
            transport.sendMessage(message, message.getAllRecipients());
        }finally {
            if(null != transport) {
                transport.close();
            }
        }
    }

    private static Properties getMailProperties(String mailHost, String mailProtocal,
                                                String mailAuth, String mailPort) {
        Properties props = new Properties();
        props.setProperty(CommonConst.EMAIL_SMTP_HOST, mailHost);
        props.setProperty(CommonConst.EMAIL_TRANSPORT_PROTOCAL, mailProtocal);
        props.setProperty(CommonConst.EMAIL_SMTP_AUTH, mailAuth);
        props.setProperty(CommonConst.EMAIL_SMTP_PORT, mailPort);
        return props;
    }

}