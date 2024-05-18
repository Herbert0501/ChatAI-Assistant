package top.kangyaocoding.chatai.domain.ai.model.vo;

public class Choices {
    private String finish_reason;
    private Message message;

    // Getters and setters
    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}