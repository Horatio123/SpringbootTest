package com.baimahu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTest {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void testMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("voyage plan");
        message.setText("go to lishui");
        message.setTo("chen836997293@hotmail.com");
        message.setFrom("836997293@qq.com");
        mailSender.send(message);
    }

    @Test
    public void testMimeMail() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("voyage plan mime");
        helper.setText("<b style='color:red'> lishui </b>", true);
        helper.setTo("chen836997293@hotmail.com");
        helper.setFrom("836997293@qq.com");

        helper.addAttachment("022.jpg", new File("/Users/horatio/ProgramStudy/022.jpg"));

        mailSender.send(mimeMessage);
    }
}
