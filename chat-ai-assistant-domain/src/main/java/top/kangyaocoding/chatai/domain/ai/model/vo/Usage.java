package top.kangyaocoding.chatai.domain.ai.model.vo;

public class Usage {
    private int total_tokens;
    private int output_tokens;
    private int input_tokens;

    // Getters and setters
    public int getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }

    public int getOutput_tokens() {
        return output_tokens;
    }

    public void setOutput_tokens(int output_tokens) {
        this.output_tokens = output_tokens;
    }

    public int getInput_tokens() {
        return input_tokens;
    }

    public void setInput_tokens(int input_tokens) {
        this.input_tokens = input_tokens;
    }
}