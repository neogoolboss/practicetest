package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu extends BookDTO {

    Scanner sc = new Scanner(System.in);
    BookManager bm = new BookManager();


    /* 기본생성자 생성*/
    public BookMenu() {
    }

    /* 도서관리 프로그램에 해당하는 메인 메뉴 출력 */
    public void menu() {

        while (true) {                              // 반복출력을 위한 while문
            System.out.println();
            System.out.println("=========== 도서관리 프로그램 ==========");
            System.out.println("           1. 도서 정보 추가");
            System.out.println("           2. 도서 정보 삭제");
            System.out.println("           3. 도서 정보 검색");
            System.out.println("           4. 도서 정보 출력");
            System.out.println("           5. 전체 도서 목록 보기");
            System.out.println("           6. 도서 목록 정렬(카테고리)");
            System.out.println("           0. 프로그램 종료");
            System.out.println("=====================================");

            System.out.print("         ✅메뉴를 선택하세요 : ");
            int menuNum = sc.nextInt();             // 선택한 번호 입력값 저장

            switch (menuNum) {

                case 1 :
                    bm.addBook(this.inputBook());
                    break;

                case 2 :
                    System.out.print("삭제할 도서 번호를 입력하세요 : ");
                    int bNum = sc.nextInt();
                    bm.deleteBook(bNum-1); // 내가 입력한 도서번호 = 인덱스값 + 1 이기 때문에 -1을 넣어서 맞춰줌
                    break;

                case 3 :
                    System.out.print("검색할 [도서제목]을 입력하세요 : ");
                    String title = sc.next();
                    bm.searchBook(title);
                    break;

                case 4 :
                    System.out.print("도서 정보를 출력할 도서 번호를 입력하세요 : ");
                    int bNum2 = sc.nextInt();
                    bm.printBook(bNum2-1); // 내가 입력한 도서번호 = 인덱스값 + 1 이기 때문에 -1을 넣어서 맞춰줌
                    break;

                case 5 :
                    bm.displayAll();
                    break;

                case 6 :
                    System.out.println("도서 목록을 카테고리 별로 정렬합니다.");
                    System.out.println("1. 오름차순");
                    System.out.println("2. 내림차순");
                    System.out.print("번호 선택 : ");
                    int select = sc.nextInt();
                    bm.sortedBookList(select);
                    break;

                case 0 :
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default :
                    System.out.println("잘못된 번호입니다.");
                    break;
            }

            if (menuNum == 0) {
                break;
            }
        }
    }

    /* BookDTO 객체의 필드 값을 키보드로 입력받아 초기화 하고 객체 리턴 */
    public BookDTO inputBook() {

        BookDTO bookDTO = new BookDTO();
        boolean codeChoice = false;

        while (!codeChoice) {

            System.out.print("도서 코드를 입력하세요 1(인문), 2(자연과학), 3(의료), 4(기타) : ");
            int codeNum = sc.nextInt();
            switch (codeNum) {
                case 1:
                    bookDTO.setCategory(codeNum);
                    codeChoice = true;
                    break;
                case 2:
                    bookDTO.setCategory(codeNum);
                    codeChoice = true;
                    break;
                case 3:
                    bookDTO.setCategory(codeNum);
                    codeChoice = true;
                    break;
                case 4:
                    bookDTO.setCategory(codeNum);
                    codeChoice = true;
                    break;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
                    break;
//                System.out.println("잘못입력하셨습니다. 4(기타)로 입력됩니다.");
//                bookDTO.setCategory(4); // 잘못입력 시 모두 기타로 넣을까 하다가 패스.
            }
        }
            System.out.print("도서 제목을 입력하세요 : ");
            sc.nextLine();
            bookDTO.setTitle(sc.nextLine());

            System.out.print("도서 저자를 입력하세요 : ");
            bookDTO.setAuthor(sc.nextLine());

            return bookDTO;
        }


    /* 검색할 도서제목을 키보드로 입력받아 리턴 */
    public String inputBookTitle() {
        System.out.println("검색할 [도서제목]을 입력하세요 : ");
        String title = sc.nextLine();
        sc.nextLine();

        return title;
    }


}
