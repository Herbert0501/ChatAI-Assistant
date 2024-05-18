package top.kangyaocoding.chatai.domain.ai.model.vo;

import org.apache.logging.log4j.message.Message;

public class Choices
{
    private String finish_reason;

    private Message message;

    public void setFinish_reason(String finish_reason){
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason(){
        return this.finish_reason;
    }
    public void setMessage(Message message){
        this.message = message;
    }
    public Message getMessage(){
        return this.message;
    }
}