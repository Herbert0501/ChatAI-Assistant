package top.kangyaocoding.chatai.domain.zsxq.model.res;

import top.kangyaocoding.chatai.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @description 结果数据
 */
public class RespData {

    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

}
