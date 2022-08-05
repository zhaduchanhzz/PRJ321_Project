/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author zhadu
 */
public class Review {
    private String pid;
    private int cid;
    private String comment;
    private int grade;

    public Review() {
    }

    public Review(String pid, int cid, String comment, int grade) {
        this.pid = pid;
        this.cid = cid;
        this.comment = comment;
        this.grade = grade;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Review{" + "pid=" + pid + ", cid=" + cid + ", comment=" + comment + ", grade=" + grade + '}';
    }
    
}
