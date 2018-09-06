package com.bzcoder.springcloudstream.message;

import com.bzcoder.springcloudstream.message.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author BaoZhou
 * @date 2018/9/3
 */
@RestController
public class SendMessageController {
    @Autowired
    private Processor processor;


    @GetMapping("/sendMessage")
    public void process()
    {
        String message = new StringBuilder().append("now ").append(new Date()).toString();
        processor.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/sendMessageChannel")
    public void process1()
    {
        String message = new StringBuilder().append("now ").append(new Date()).toString();
        processor.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/sendObject")
    public void sendObject()
    {
        Person person = new Person();
        person.setName("张三");
        person.setAge(123);
        //process中已设置input
        processor.output().send(MessageBuilder.withPayload(person).build());
    }
}
