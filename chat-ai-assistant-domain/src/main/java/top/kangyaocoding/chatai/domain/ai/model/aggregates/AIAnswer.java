package top.kangyaocoding.chatai.domain.ai.model.aggregates;

import top.kangyaocoding.chatai.domain.ai.model.vo.Output;
import top.kangyaocoding.chatai.domain.ai.model.vo.Usage;

public class AIAnswer {
    private Output output;
    private Usage usage;
    private String request_id;

    // Getters and setters
    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}