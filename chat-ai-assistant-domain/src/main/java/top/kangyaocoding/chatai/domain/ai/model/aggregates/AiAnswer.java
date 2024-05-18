package top.kangyaocoding.chatai.domain.ai.model.aggregates;

import top.kangyaocoding.chatai.domain.ai.model.vo.Output;
import top.kangyaocoding.chatai.domain.ai.model.vo.Usage;

public class AiAnswer
{
    private Output output;

    private Usage usage;

    private String request_id;

    public void setOutput(Output output){
        this.output = output;
    }
    public Output getOutput(){
        return this.output;
    }
    public void setUsage(Usage usage){
        this.usage = usage;
    }
    public Usage getUsage(){
        return this.usage;
    }
    public void setRequest_id(String request_id){
        this.request_id = request_id;
    }
    public String getRequest_id(){
        return this.request_id;
    }
}
