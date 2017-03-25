package com.pengsheng.eims.util.tools;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtil {
	
	protected Session session = null;
	
	private String host=null;
	
	private String port=null;
	
	private String user=null;
	
	private String pwd=null;
	
	public EmailUtil(String mailHost,String mailPort,String mailUser,String mailPwd) {
		
		   setHost(mailHost);		
		   setPort(mailPort);		
		   setUser(mailUser);		
		   setPwd(mailPwd);
		
	       Properties props = new Properties();
	       props.put("mail.transpost.protocol", "smtp");
	       props.put("mail.smtp.host",host);
	       // 必须要有一个类来认证
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smpt.port",port);
	       Autherticatorbean auth =  new Autherticatorbean(user,pwd);
	        // session认证
	       session = Session.getInstance(props,auth);
	        // 这个是跟踪后台消息。打印在控制台
	       session.setDebug(true);
		
	}

	public void sendMails(String emailFrom,String recipients,String subject,String text)
    {
        try
        {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailFrom));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(recipients));
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText(text);

            Transport transport = session.getTransport("smtp");
            //与发送者的邮箱相连
            transport.connect(host,user,pwd);
            //transport.send(msg);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        }
        catch (SendFailedException e)
        {
            e.printStackTrace();
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }

    }

	
	public static void main(String[] args) {
		EmailUtil e=new EmailUtil("smtp.163.com","25","stephydu","19820306");
		e.sendMails("stephydu@163.com","duy123@sina.com","测试","ok");
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
