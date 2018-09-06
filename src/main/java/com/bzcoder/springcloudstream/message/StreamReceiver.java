package com.bzcoder.springcloudstream.message;

import com.bzcoder.springcloudstream.message.Entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author BaoZhou
 * @date 2018/9/3
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.output)
    //@SendTo(StreamClient.input2)
    public void process(String message)
    {
        System.out.println(message);
        log.info("process: StreamReceiver:{}",message);
    }
    @StreamListener(StreamClient.output)
    public void process1(Person person)
    {
        System.out.println(person);
        log.info("process1: StreamReceiver:{}",person);
    }

    @StreamListener(StreamClient.input2)
    public void process2(String message)
    {
        System.out.println(message);
        log.info("process2: StreamReceiver:{}",message);
    }
}
