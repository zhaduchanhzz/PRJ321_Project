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
public class Bill {

    private int oid;
    private String dateCreate, cname, cphone, caddress;
    private int status;
    private double total;
    private int cid, discount;

    public Bill(int oid, String dateCreate, String cname, String cphone, String caddress, double total, int status, int cid, int discount) {
        this.oid = oid;
        this.dateCreate = dateCreate;
        this.cname = cname;
        this.cphone = cphone;
        this.caddress = caddress;
        this.status = status;
        this.total = total;
        this.cid = cid;
        this.discount = discount;
    }

    public Bill() {
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Bill{" + "oid=" + oid + ", dateCreate=" + dateCreate + ", cname=" + cname + ", cphone=" + cphone + ", caddress=" + caddress + ", status=" + status + ", total=" + total + ", cid=" + cid + ", discount=" + discount + '}';
    }

}
