package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    private ArrayList<Cart> carts;
    private Hamburger hamburger;
    private Side side;
    private Drink drink;
    private Scanner scanner;

    // 기본 생성자
    public Kiosk(){
        carts = new ArrayList<>();
        hamburger = new Hamburger();
        side = new Side();
        drink = new Drink();
        scanner = new Scanner(System.in);
    }

    // 총 합계 금액
    public int totalPrice(){
        int total = 0;
        for (Cart cart : carts) {
            total += cart.priceCalculator();
        }

        return total;
    }

    // 카트 중복 확인
    public Cart isCart(String name){
        for (Cart cart : carts) {
            if(cart.getItem().getName().equals(name)){
                return cart;
            }
        }
        return null;
    }

    // HomePage
    public void homePage() {
        System.out.println("=====홈=====\n");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료\n");

        System.out.print("메뉴선택: ");
        homeAction(scanner.nextInt());
    }
    // HomePage 동작
    public void homeAction(int choice) {
        switch(choice){
            case 1 -> menuPage(hamburger);
            case 2 -> menuPage(side);
            case 3 -> menuPage(drink);
            case 4 -> cartPage();
            case 5 -> System.exit(0);
            default -> throw new IllegalArgumentException("Homepage: Invalid input!");
        }
    }

    // menuPage
    public void menuPage(Menu menu) {
        if(menu instanceof Hamburger){
            System.out.println("=====햄버거 메뉴=====\n");
        }else if(menu instanceof Side){
            System.out.println("=====사이드 메뉴=====\n");
        }else if(menu instanceof Drink){
            System.out.println("=====음료 메뉴=====\n");
        }
        System.out.println(menu.toString());
        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");
        menuAction(menu, scanner.nextInt());
    }
    // menuPage 동작
    public void menuAction(Menu menu, int choice) {
        if(choice == 0){
            homePage();
        }else if(choice >0 && choice <= menu.getMenu().size()){
            Cart cart = isCart(menu.getMenu().get(choice-1).getName());
            if(cart==null){
                carts.add(new Cart(menu.getMenu().get(choice-1)));
            }else{
                if(cart.getCount()<50) {
                    cart.setCount(cart.getCount()+1);
                }
            }
            homePage();
        }else{
            throw new IllegalArgumentException("SidePage: Invalid input!");
        }
    }

    // cartPage
    public void cartPage(){
        System.out.println("===== 장바구니 =====\n");
        for(Cart cart : carts){
            System.out.println("- " + cart.toString());
        }
        System.out.println("\n====================");
        System.out.println("1. 주문하기");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기");

        System.out.println("\n총 가격: " + totalPrice());

        System.out.print("\n메뉴선택 (0을 선택 시 홈으로): ");
        cartAction(scanner.nextInt());
    }
    // cartPage 동작
    public void cartAction(int choice){
        switch(choice){
            case 0 -> homePage();
            case 1 -> orderPage();
            case 2 -> updatePage();
            case 3 -> deletePage();
            default -> throw new IllegalArgumentException("CartPage: Invalid input!");
        }
    }

    // 주문하기
    public void orderPage(){
        int i = 1;
        System.out.println("주문이 완료되었습니다.");
        for(Cart cart : carts){
            System.out.println(i++ +". " + cart.toString());
        }
    }

    // 수량 조절하기
    public void updatePage(){
        int i = 1;
        System.out.println("===== 수량 조절하기 =====\n");
        System.out.println("현재 장바구니\n");
        for(Cart cart : carts){
            System.out.println(i++ +". " + cart.toString());
        }

        System.out.print("\n수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        updateAction(scanner.nextInt());
    }
    public void updateAction(int choice){
        if(choice == 0){
            homePage();
        }else if(choice>0 && choice <= carts.size()){
            System.out.print("변경할 수량을 입력하세요:");
            int num=scanner.nextInt();
            if(num<1 || 50<num){
                throw new IllegalArgumentException("UpdatePage: Invalid input!");
            }
            carts.get(choice-1).setCount(num);
            homePage();
        }else{
            throw new IllegalArgumentException("UpdatePage: Invalid input!");
        }
    }

    // 삭제하기
    public void deletePage(){
        int i = 1;
        System.out.println("===== 삭제하기 =====\n");
        System.out.println("현재 장바구니\n");
        for(Cart cart : carts){
            System.out.println(i++ +". "+ cart.toString());
        }

        System.out.print("\n삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        deleteAction(scanner.nextInt());
    }
    public void deleteAction(int choice){
        if(choice == 0){
            homePage();
        }else if(choice>0 && choice <= carts.size()){
            System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제):");
            int num = scanner.nextInt();
            switch(num){
                case 0 -> homePage();
                case 1 -> carts.remove(choice-1);
            }
            homePage();
        }else{
            throw new IllegalArgumentException("UpdatePage: Invalid input!");
        }
    }
}