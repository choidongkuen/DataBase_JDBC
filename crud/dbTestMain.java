package crud;

import java.util.Scanner;

public class dbTestMain {
    public static String choice;
    public static void main(String[] args){

       MemberService memberService = new MemberService();
       Member member;

        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 기능을 선택해주세요 : ");
        choice = sc.next(); // 명령 입력

        if(choice.equals("register")) {
         // 회원 가입 메소드 실행
         System.out.print("타입 입력: ");
         String memberType = sc.next();
         System.out.print("아이디 입력: ");
         String userId = sc.next();
         System.out.print("비밀번호 입력 : ");
         String password = sc.next();
         System.out.print("이름 입력 : ");
         String name = sc.next();

         member = new Member();
         member.setMemberType(memberType);
         member.setUserId(userId);
         member.setPassword(password);
         member.setName(name);

         memberService.register(member);

        }else if(choice.equals("withdraw")){
         // 회원 정보 삭제 메소드 실행
         System.out.print("타입 입력: ");
         String memberType = sc.next();
         System.out.print("아이디 입력: ");
         String userId = sc.next();

         member = new Member();
         member.setMemberType(memberType);
         member.setUserId(userId);

         memberService.withdraw(member);

        }else if(choice.equals("printInfo")){
         // 회원 정보 출력 메소드 실행

         System.out.print("타입 입력: ");
         String memberType = sc.next();

         member = new Member();
         member.setMemberType(memberType);

         memberService.printInfo(member);

        }else {
         // 회원 정보 업데이트 메소드 실행

         System.out.print("타입 입력: ");
         String memberType = sc.next();

         System.out.print("아이디 입력: ");
         String userId = sc.next();

         System.out.println("패스워드 입력: ");
         String password = sc.next();

         member = new Member();
         member.setPassword(password);
         member.setUserId(userId);
         member.setMemberType(memberType);
         memberService.update(member);
        }
    }
}
