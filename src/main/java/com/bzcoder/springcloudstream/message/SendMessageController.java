package com.bzcoder.springcloudstream.message;

import com.bzcoder.springcloudstream.message.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author BaoZhou
 * @date 2018/9/3
 */
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process()
    {
        String message = new StringBuilder().append("now ").append(new Date()).toString();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/sendObject")
    public void sendObject()
    {
        Person person = new Person();
        person.setName("张三");
        person.setAge(123);
        //process中已设置input
        streamClient.output().send(MessageBuilder.withPayload(person).build());
    }
}
