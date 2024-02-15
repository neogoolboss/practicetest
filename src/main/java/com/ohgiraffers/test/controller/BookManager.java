package com.ohgiraffers.test.controller;

import com.ohgiraffers.test.hw2.model.comparator.AscCategory;
import com.ohgiraffers.test.hw2.model.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookManager {


    //기본 생성자 - ArrayList<BookDTO> 인스턴스 생성
    public BookManager() {
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
    }

    ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

    // 전달받은 BookDTO 객체를 생성자시 선언한 ArrayList객체에 추가
    public void addBook(BookDTO book) {
        this.bookList.add(new BookDTO(book.getCategory(), book.getTitle(), book.getAuthor()));
        for (BookDTO bookDTO : bookList) {
            System.out.println("추가된 도서 = [" + bookDTO + "]");
        }
    }

    //전달받은 도서 번호로 ArrayList 안에 있는 정보 삭제
    public void deleteBook(int index) {
        this.bookList.remove(index);
        for (BookDTO bookDTO : bookList) {
            System.out.println("삭제된 도서 = [" + bookDTO + "]");
        }
    }

    //전달받은 도서 제목으로 도서를 검색하고 결과값 반환
    public int searchBook(String bTitle) {
        System.out.println("입력한 도서 제목 : " + bTitle + "입니다. 해당 도서의 검색결과는 : " + this.bookList.equals(bTitle));
        for (BookDTO bookDTO : bookList) {
            System.out.println("bookList : " + bookDTO);
        }
        return this.bookList.equals(bTitle) ? 1 : -1;

    }

    //전달받은 인덱스에 있는 도서정보 출력
    public void printBook(int index) {
        System.out.println(this.bookList.get(index));
    }

    //도서 목록 전체 출력
    public void displayAll() {
        System.out.println("현재 전체 도서 목록은 : " + this.bookList.size());
        for (BookDTO bookDTO : this.bookList) {
            System.out.println(bookDTO);
        }
    }

    // 전달받은 번호를 기준으로 해당 카테고리순으로 정렬해서 ArrayList<BookDTO>에 담아서 리턴
    public ArrayList<BookDTO> sortedBookList(int select) {
        //정렬 관련 메소드 호출 필요
        Scanner sc = new Scanner(System.in);

        System.out.println("오름차순으로 정렬 choice 1");
        System.out.println("내림차순으로 정렬 choice 2");
        System.out.print("번호를 입력하세요 : ");

        int choiceNum = sc.nextInt();

        while (true) {

            switch (choiceNum) {
                case 1:
                    this.bookList.sort(new AscCategory());
                    break;
                case 2:
                    this.bookList.sort(new DescCategory());
                    break;
                default:
                    System.out.println("1 과 2중에 골라주세요");
                    break;
            }
            if (choiceNum == 1 || choiceNum == 2) {
                break;
            }
        }
        return null;
    }

    // 전달받은 ArrayList<BookDTO>를 향상된 for문을 이용하여 출력
    public void printBookList(ArrayList<BookDTO> br) {
        for (BookDTO book : br) {
            System.out.println(book);
        }
    }

}
