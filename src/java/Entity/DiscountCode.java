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
public class DiscountCode {
    int status;
    String content;
    double percent;

    public DiscountCode() {
    }

    public DiscountCode(int status, String content, double percent) {
        this.status = status;
        this.content = content;
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DiscountCode{" + "status=" + status + ", content=" + content + ", percent=" + percent + '}';
    }
    
}
