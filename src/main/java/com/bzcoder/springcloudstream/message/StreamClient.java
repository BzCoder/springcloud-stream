package com.bzcoder.springcloudstream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author BaoZhou
 * @date 2018/9/6
 */
public interface StreamClient {

    String input = "input";

    String output = "output";

    String input2 = "input2";

    String output2 = "output2";

    //@Input(input)
    //SubscribableChannel input();
    //
    //@Input(input2)
    //SubscribableChannel input2();

    @Output(output)
    MessageChannel output();


    @Output(output2)
    MessageChannel output2();


}
