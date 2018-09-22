/**
 * Date:     2018/9/2217:05
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 2018/9/22  17:05
 * created by zhoumb
 */
@Document(collection = "scores")
public class Score {
    private String id;
    private String student;
    private Integer[] homework;
    private Integer[] quiz;
    private float extrCredit;

    public Score() {
    }

    public Score(String id, String student, Integer[] homework, Integer[] quiz, float extrCredit) {
        this.id = id;
        this.student = student;
        this.homework = homework;
        this.quiz = quiz;
        this.extrCredit = extrCredit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Integer[] getHomework() {
        return homework;
    }

    public void setHomework(Integer[] homework) {
        this.homework = homework;
    }

    public Integer[] getQuiz() {
        return quiz;
    }

    public void setQuiz(Integer[] quiz) {
        this.quiz = quiz;
    }

    public float getExtrCredit() {
        return extrCredit;
    }

    public void setExtrCredit(float extrCredit) {
        this.extrCredit = extrCredit;
    }
}
