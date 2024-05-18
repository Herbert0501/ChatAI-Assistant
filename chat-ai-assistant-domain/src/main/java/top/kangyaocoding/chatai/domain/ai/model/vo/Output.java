package top.kangyaocoding.chatai.domain.ai.model.vo;

import java.util.List;

public class Output {
    private List<Choices> choices;

    // Getters and setters
    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
}