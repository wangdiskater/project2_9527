package com.cskaoyan.bean;

import com.cskaoyan.vo.issue.IssueVo;

/**
 * @version 1.0
 * @ClassName Issue  ---  mall_issue的bean
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 20:34
 **/

public class Issue {
    private int    id;
    private String question;
    private String answer;
    private String add_time;
    private String update_time;
    private int    deleted;

    public Issue() {
    }

    public Issue(IssueVo issueVo) {
        this.id = issueVo.getId();
        this.question = issueVo.getQuestion();
        this.answer = issueVo.getAnswer();
        this.add_time = issueVo.getAddTime();
        this.update_time = issueVo.getUpdateTime();
        if(issueVo.isDeleted()){
            this.deleted = 1;
        }else {
            this.deleted = 0;
        }
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", add_time='" + add_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
