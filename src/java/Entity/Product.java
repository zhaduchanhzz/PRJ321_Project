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
public class Product {
    private String pid,pname;
    private int quantity;
    private double price;
    private String img,decs;
    private int status,cateid,addbycid;
    private double avgvote;

    public Product() {
    }

    public Product(String pid, String pname, int quantity, double price, String img, String decs, int status, int cateid, int addbycid, double avgvote) {
        this.pid = pid;
        this.pname = pname;
        this.quantity = quantity;
        this.price = price;
        this.img = img;
        this.decs = decs;
        this.status = status;
        this.cateid = cateid;
        this.addbycid = addbycid;
        this.avgvote = avgvote;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public int getAddbycid() {
        return addbycid;
    }

    public void setAddbycid(int addbycid) {
        this.addbycid = addbycid;
    }

    public double getAvgvote() {
        return avgvote;
    }

    public void setAvgvote(double avgvote) {
        this.avgvote = avgvote;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", img=" + img + ", decs=" + decs + ", status=" + status + ", cateid=" + cateid + ", addbycid=" + addbycid + ", avgvote=" + avgvote + '}';
    }
    
}
