package org.lxh.maildemo;

import java.io.File;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAssessoriesMail {

	public static void main(String[] args) throws Exception {
		InternetAddress[] address = null;
		String mailserver = "mldnjava.cn";
		String from = "lxh@mldnjava.cn";
		String to = "mldnqa@sina.com";
		String subject = "����ħ�ֿƼ����ѧԺ";
		String messageText = "<h1>"
				+ "<a href=\"www.mldnjava.cn\">www.mldnjava.cn</a>"
				+ "����ħ�ֿƼ����ѧԺ" + "</h1>";
		java.util.Properties props = System.getProperties();
		props.put("mail.smtp.host", mailserver);
		props.put("mail.smtp.auth", "true");
		MySecurity msec = new MySecurity("lxh", "mldnjava");
		Session mailSession = Session.getDefaultInstance(props, msec);
		mailSession.setDebug(false);
		Message msg = new MimeMessage(mailSession);// �����ļ���Ϣ
		msg.setFrom(new InternetAddress(from)); // ���ô����ʼ��ķ�����
		address = InternetAddress.parse(to, false); // ָ�������˵�����
		msg.setRecipients(Message.RecipientType.TO, address); // ��ָ�����䷢��
		msg.setSubject(subject);
		msg.setSentDate(new Date()); // ���̷���

		Multipart multipart = new MimeMultipart();
		BodyPart messageBodyPart = new MimeBodyPart(); // ��Ӹ���
		DataSource source = new FileDataSource("d:" + File.separator
				+ "photo.gif");
		messageBodyPart.setDataHandler(new DataHandler(source)) ;
		messageBodyPart.setFileName("mldn.gif") ;
		multipart.addBodyPart(messageBodyPart) ;
		
		messageBodyPart = new MimeBodyPart() ;
		messageBodyPart.setContent(messageText,"text/html;charset=GBK") ;
		multipart.addBodyPart(messageBodyPart) ;
		msg.setContent(multipart) ;
		Transport.send(msg, msg.getAllRecipients());
	}

}
