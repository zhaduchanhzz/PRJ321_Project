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
public class Customer {

    private int id;
    private String cname, cphone, cAddress, username, password;
    private int status, role, questindex;
    private String answer, pass2 , email;

    public Customer() {
    }

    public Customer(String cname, String cphone, String cAddress, String username, String password, int status, int role, int questindex, String answer, String pass2, String email) {
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.questindex = questindex;
        this.answer = answer;
        this.pass2 = pass2;
        this.email = email;
    }

    public Customer(int id, String cname, String cphone, String cAddress, String username, String password, int status, int role, int questindex, String answer, String pass2, String email) {
        this.id = id;
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
        this.questindex = questindex;
        this.answer = answer;
        this.pass2 = pass2;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", cname=" + cname + ", cphone=" + cphone + ", cAddress=" + cAddress + ", username=" + username + ", password=" + password + ", status=" + status + ", role=" + role + ", questindex=" + questindex + ", answer=" + answer + ", pass2=" + pass2 + ", email=" + email + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getQuestindex() {
        return questindex;
    }

    public void setQuestindex(int questindex) {
        this.questindex = questindex;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }



}
