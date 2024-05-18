package top.kangyaocoding.chatai.domain.ai.model.vo;

import java.util.List;

public class Output
{
    private List<Choices> choices;

    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }
}