package com.example.mywebsitespring.domain;

import java.util.Date;

public class CommentDto {
    private int cno;
    private int bno;
    private int pcno;
    private String content;
    private String writer;
    private Date reg_date;
    private Date up_date;


    // TODO: 2023-11-15  reg_date, up_date 왜 null 안됨?
    public CommentDto() {
        this(0, 0, 0, "default content from java", "default writer from java", new Date(), new Date());
    }

    public CommentDto(int cno, int bno, int pcno, String content, String writer, Date reg_date, Date up_date) {
        this.cno = cno;
        this.bno = bno;
        this.pcno = pcno;
        this.content = content;
        this.writer = writer;
        this.reg_date = reg_date;
        this.up_date = up_date;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getPcno() {
        return pcno;
    }

    public void setPcno(int pcno) {
        this.pcno = pcno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "cno=" + cno +
                ", bno=" + bno +
                ", pcno=" + pcno +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                '}';
    }
}
