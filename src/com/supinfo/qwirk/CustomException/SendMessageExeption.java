package com.supinfo.qwirk.CustomException;

import com.supinfo.qwirk.Entity.Message;

/**
 * com.supinfo.qwirk.CustomException
 * Created by Theo on 14/12/2016 for Qwirk.
 */
public class SendMessageExeption extends Exception {

    String errorMessage;
    Message messageInfo;

    public SendMessageExeption() {}

    public SendMessageExeption(String errorMessage,Message messageInfo)
    {
        super(errorMessage);

        this.errorMessage = errorMessage;
        this.messageInfo = messageInfo;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Message getMessageInfo() {
        return messageInfo;
    }

    public void setMessage(Message messageInfo) {
        this.messageInfo = messageInfo;
    }
}
