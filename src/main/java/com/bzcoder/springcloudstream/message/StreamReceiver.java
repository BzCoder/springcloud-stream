package com.bzcoder.springcloudstream.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author BaoZhou
 * @date 2018/9/3
 */
@Component
@EnableBinding(Processor.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(Processor.OUTPUT)
    @SendTo(Processor.INPUT)
    public String process(String message)
    {
        System.out.println(message);
        log.info("process: StreamReceiver:{}",message);
        return "我是回执";
    }
    //@StreamListener(Processor.OUTPUT)
    //public void process1(Person person)
    //{
    //    System.out.println(person);
    //    log.info("process1: StreamReceiver:{}",person);
    //}

    @StreamListener(Processor.INPUT)
    public void process2(String message)
    {
        System.out.println(message);
        log.info("process2: StreamReceiver:{}",message);
    }
}
