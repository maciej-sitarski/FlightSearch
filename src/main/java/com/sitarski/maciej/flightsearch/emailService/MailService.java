package com.sitarski.maciej.flightsearch.emailService;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  private JavaMailSender javaMailSender;

  public MailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void sendHtmlEmail(String to, String content) {
    MimeMessage mail = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mail, true);
      helper.setTo(to);
      helper.setFrom("Flight search MS <flightsearchms@gmail.com>");
      helper.setSubject("Flight price update");
      helper.setText(content, true);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    javaMailSender.send(mail);
  }
}
