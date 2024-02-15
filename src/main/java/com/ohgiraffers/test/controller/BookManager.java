package com.ohgiraffers.test.controller;

import com.ohgiraffers.hw2.model.comparator.AscCategory;
import com.ohgiraffers.hw2.model.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManager {


    /* 기본 생성자 - ArrayList<BookDTO> 인스턴스 생성 */
    public BookManager() {
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
    }

    ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();

    /* 전달받은 BookDTO 객체를 생성자시 선언한 ArrayList객체에 추가 */
    public void addBook(BookDTO book) {
        this.bookList.add(new BookDTO(book.getCategory(), book.getTitle(), book.getAuthor()));
        for (BookDTO bookDTO : bookList) {
            System.out.println("추가된 도서 = [" + bookDTO + "]");
        }
    }

    /* 전달받은 도서 번호로 ArrayList 안에 있는 정보 삭제 */
    public void deleteBook(int index) {
        if(index >= 0 && index < this.bookList.size()) {
            BookDTO removeBook = this.bookList.remove(index);
            System.out.println("삭제된 도서는 [" + removeBook + "] 입니다.");
        } else {
            System.out.println("유효하지 않은 도서번호입니다.");
        }

    }

    /* 전달받은 도서 제목으로 도서를 검색하고 결과값 반환 */
    public int searchBook(String title) {
        System.out.println("입력한 도서 제목은 [" + title + "]입니다.");
        for (BookDTO bookDTO : bookList) {
            if (bookDTO.getTitle().equals(title)) {
                System.out.println("검색결과 : " + bookDTO);
                return 1;
            }
        }
        System.out.println("해당 도서를 찾을 수 없습니다.");
        return -1;
    }

    /* 전달받은 인덱스에 있는 도서정보 출력 */
    public void printBook(int index) {
        System.out.println(this.bookList.get(index));
    }

    /* 도서 목록 전체 출력 */
    public void displayAll() {
        System.out.println("현재 전체 도서 목록은 : " + this.bookList.size() + "권 입니다.");
        int index = 1;
        for (BookDTO bookDTO : this.bookList) {
            System.out.println("도서번호 : " + index + " / " + bookDTO);
            index++;
        }
    }

    /* 전달받은 번호를 기준으로 해당 카테고리순으로 정렬해서 ArrayList<BookDTO>에 담아서 리턴 */
    public ArrayList<BookDTO> sortedBookList(int select) {
        ArrayList<BookDTO> sortedList = new ArrayList<>(bookList); // bookList를 복사하여 새로운 ArrayList 생성

        switch (select) {
            case 1 :
                Collections.sort(sortedList, new AscCategory());
                System.out.println("도서를 카테고리별 오름차순으로 정렬합니다:");
                break;
            case 2 :
                Collections.sort(sortedList, new DescCategory());
                System.out.println("도서를 카테고리별 내림차순으로 정렬합니다:");
                break;
            default :
                System.out.println("잘못된 선택입니다.");
                return null;
        }

        for (BookDTO book : sortedList) {
            System.out.println(book);
        }

        return sortedList;
    }

    /* 전달받은 ArrayList<BookDTO>를 향상된 for문을 이용하여 출력 */
    public void printBookList(ArrayList<BookDTO> br) {
        for (BookDTO book : br) {
            System.out.println(book);
        }
    }

}
