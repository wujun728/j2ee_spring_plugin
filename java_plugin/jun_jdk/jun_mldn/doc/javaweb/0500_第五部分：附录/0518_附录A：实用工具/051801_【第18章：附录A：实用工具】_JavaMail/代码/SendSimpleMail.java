package org.lxh.maildemo;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSimpleMail {

	public static void main(String[] args) throws Exception {
		InternetAddress[] address = null;
		String mailserver = "mldnjava.cn";
		String from = "lxh@mldnjava.cn";
		String to = "mldnqa@sina.com";
		String subject = "����ħ�ֿƼ����ѧԺ";
		String messageText = "www.mldnjava.cn" + "����ħ�ֿƼ����ѧԺ";
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
		msg.setText(messageText); // ���͵�����
		Transport.send(msg, msg.getAllRecipients());
	}

}
