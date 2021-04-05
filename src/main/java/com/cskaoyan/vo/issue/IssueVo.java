package com.cskaoyan.vo.issue;

import com.cskaoyan.bean.Issue;

/**
 * @version 1.0
 * @ClassName IssueVo
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/1 20:47
 **/

public class IssueVo {
    private int    id;
    private String question;
    private String answer;
    private String addTime;
    private String updateTime;
    private boolean   deleted;

    public IssueVo() {
    }

    public IssueVo(Issue issue) {
        this.id = issue.getId();
        this.question = issue.getQuestion();
        this.answer = issue.getAnswer();
        this.addTime = issue.getAdd_time();
        this.updateTime = issue.getUpdate_time();
        if(issue.getDeleted() == 0){
            this.deleted = false;
        } else {
            this.deleted = true;
        }
    }

    @Override
    public String toString() {
        return "IssueVo{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
