package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu extends BookDTO {

    Scanner sc = new Scanner(System.in);
    BookManager bm = new BookManager();

    //Book

    //기본생성자
    public BookMenu() {
    }

    //menu 메소드 - 도서관리 프로그램에 해당하는 메인 메뉴 출력
    public void menu() {
        //반복 출력되게 한다.
        //1. 도서 추가하기
        //2. 도서 삭제하기
        //3. 도서 검색하기
        //4. 도서 정보 출력하기
        //5. 도서목록 전체 출력하기
        //6. 카테고리 오름차순 정렬하기
        //7. 카테고리 내림차순 정렬하기
        //8.
        //9. 프로그램 종료
        while (true) {
            System.out.println();
            System.out.println("=========== 도서관리 프로그램 ==========");
            System.out.println("1. 도서 정보 추가");
            System.out.println("2. 도서 정보 삭제");
            System.out.println("3. 도서 정보 검색");
            System.out.println("4. 도서 정보 출력");
            System.out.println("5. 전체 목록 보기");
            System.out.println("6. 카테고리별로 보기(오름차순)");
            System.out.println("7. 카테고리별로 보기(내림차순)");
            System.out.print("해당하는 메뉴를 선택하세요 : ");
            int menuNum = sc.nextInt(); // 선택한 번호 입력값 저장
            switch (menuNum) {
                case 1:
                    bm.addBook(this.inputBook());
                    break;
                case 2:
                    System.out.print("삭제하실 도서 번호를 입력해주세요 : ");
                    int bNum = sc.nextInt();
                    bm.deleteBook(bNum);
                    break;
                case 3:
                    System.out.print("검색할 도서 제목을 입력해주세요 : ");
                    String bTitle = sc.next();
                    bm.searchBook(bTitle);
                    break;
                case 4:
                    System.out.print("도서 정보를 출력할 도서 번호를 입력해주세요 : ");
                    int bNum2 = sc.nextInt();
                    bm.printBook(bNum2);
                    break;
                case 5:
                    bm.displayAll();
                    break;
                case 6:
                    System.out.print("카테고리별로 보기(오름차순) : ");
                    int bNum3 = sc.nextInt();
                    bm.sortedBookList(bNum3);
                    break;
                case 7:
                    System.out.print("카테고리별로 보기(내림차순)");
                    break;
            }

            if (menuNum == 9) {
                break;
            }
        }
    }

    //BookDTO 객체의 필드값을 키보드로 입력 받아 초기화하고 객체 리턴
    public BookDTO inputBook() {

        BookDTO bookDTO = new BookDTO();


            System.out.print("도서 코드를 입력하세요 1(인문), 2(자연과학), 3(의료), 4(기타) : ");
            int codeNum = sc.nextInt();
            switch (codeNum) {
                case 1:
                    bookDTO.setCategory(codeNum);
                    break;
                case 2:
                    bookDTO.setCategory(codeNum);
                    break;
                case 3:
                    bookDTO.setCategory(codeNum);
                    break;
                case 4:
                    bookDTO.setCategory(codeNum);
                    break;
                default:
                    System.out.println("잘못입력하셨습니다. 4(기타)로 입력됩니다.");
                    bookDTO.setCategory(4);
            }

        System.out.print("도서 제목을 입력하세요 : ");
        sc.nextLine();
        bookDTO.setTitle(sc.nextLine());

        System.out.print("도서 저자를 입력하세요 : ");
        bookDTO.setAuthor(sc.nextLine());

        return bookDTO;
    }


    //검색할 도서제목을 키보드로 입력 받아 리턴
    public String inputBookTitle() {
        System.out.println("검색할 도서제목을 입력하세요 : ");
        String title = sc.nextLine();

        return title;
    }


}
