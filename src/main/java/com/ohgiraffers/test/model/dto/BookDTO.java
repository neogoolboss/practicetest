package com.ohgiraffers.test.model.dto;

public class BookDTO {

    private int bNo; // 도서 번호

    private int category; // 도서분류코드

    private String title; // 도서 제목

    private String author; // 도서 저자


    /* 기본 생성자 */
    public BookDTO() { }

    /* 카테고리, 제목, 저자를 매개변수로 갖는 생성자 */
    public BookDTO(int category, String title, String author) {
        this.category = category;
        this.title = title;
        this.author = author;
    }

    /* 세터, 게터 */
    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public int getbNo() {
        return this.bNo;
    }



    public void setCategory(int category) {
        this.category = category;
    }

    public int getCategory() {
        return this.category;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    /* toString() */
    @Override
    public String toString() {
        return "카테고리 No : " + category +
                "(" + (category == 1 ? "인문" : category == 2 ? "자연과학" : category == 3 ? "의료" : "기타") + ")" +
                " / 도서 제목 : " + title + " / 도서 저자 : " + author;
    }

}
