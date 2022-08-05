/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author trinh
 */
public class Category {
    private int cid;
    private String cname;
    private int stt;
    
    
    public Category() {
    }

    public Category(int cid, String cname , int stt) {
        this.cid = cid;
        this.cname = cname;
        this.stt = stt;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname=" + cname + ", stt=" + stt + '}';
    }

   
}
