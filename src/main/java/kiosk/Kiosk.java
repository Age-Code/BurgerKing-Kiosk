package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    private Cart cart;
    static Scanner scanner = new Scanner(System.in);

    public Kiosk() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void homePage(){
        System.out.println("=====홈=====\n");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료\n");

        System.out.print("메뉴선택: ");
        int answer = scanner.nextInt();

        switch(answer){
            case 1 -> hamburgerPage();
            case 2 -> sidePage();
            case 3 -> drinkPage();
            case 4 -> cartPage();
            case 5 -> System.exit(0);
            default -> throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public void hamburgerPage(){
        Hamburger[] hamburgers = Hamburger.values();
        System.out.println("=====햄버거 메뉴=====\n");
        for(Hamburger hamburger : hamburgers){
            System.out.println((hamburger.ordinal()+1) + ". " + hamburger.tostring());
        }
        System.out.println();

        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");
        int answer = scanner.nextInt();

        if(answer == 0){
            homePage();
        }else{
            if(answer <0 || answer > hamburgers.length){
                throw new IllegalArgumentException("잘못된 값 입력");
            }
            String label = hamburgers[answer-1].getLabel();
            cart.addItem(label);
            System.out.println(label + "를 장바구니에 담았습니다.");
            homePage();
        }
    }

    public void sidePage(){
        System.out.println("=====사이드 메뉴=====\n");
        Side[] sides = Side.values();
        for(Side side : sides){
            System.out.println((side.ordinal()+1) + ". " + side.tostring());
        }
        System.out.println();

        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

        int answer = scanner.nextInt();

        if(answer == 0){
            homePage();
        }else{
            if(answer <0 || answer > sides.length){
                throw new IllegalArgumentException("잘못된 값 입력");
            }
            String label = sides[answer-1].getLabel();
            cart.addItem(label);
            System.out.println(label + "를 장바구니에 담았습니다.");
            homePage();
        }
    }

    public void drinkPage(){
        System.out.println("==========음료 메뉴==========\n");
        Drink[] drinks = Drink.values();
        for(Drink drink : Drink.values()){
            System.out.println((drink.ordinal()+1) + ". " + drink.tostring());
        }
        System.out.println();

        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

        int answer = scanner.nextInt();

        if(answer == 0){
            homePage();
        }else{
            if(answer <0 || answer > drinks.length){
                throw new IllegalArgumentException("잘못된 값 입력");
            }
            String label = drinks[answer-1].getLabel();
            cart.addItem(label);
            System.out.println(label + "를 장바구니에 담았습니다.");
            homePage();
        }
    }

    public void cartPage(){
        System.out.println("===== 장바구니 =====\n");
        for(Item item : cart.getItems()){
            System.out.println("- " + item.toString());
        }
        System.out.println("\n====================");

        System.out.println("1. 주문하기");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기");

        System.out.println("\n총 가격: " + cart.priceCalculator() + "원\n");

        System.out.print("메뉴선택 (0을 선택 시 홈으로): ");

        int answer = scanner.nextInt();

        switch(answer){
            case 0 -> homePage();
            case 1 -> orderPage();
            case 2 -> changePage();
            case 3 -> removePage();
            default -> throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public void orderPage(){
        System.out.println("====================");
        System.out.println("       주문완료       ");
        System.out.println("====================");
        System.exit(0);
    }

    public void changePage(){
        System.out.println("===== 수량 조절하기 =====\n");
        System.out.println("현재 장바구니\n");
        for(int i = 0; i < cart.getItems().size(); i++){
            System.out.println((i+1) + ". " + cart.getItems().get(i).toString());
        }

        System.out.print("\n수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int answer = scanner.nextInt();

        if(answer == 0){
            homePage();
        }else if(answer<0 || answer>cart.getItems().size()){
            throw new IllegalArgumentException("잘못된 값 입력");
        }

        System.out.print("변경할 수량을 입력하세요:");

        int num = scanner.nextInt();
        if(num<1 || num>50){
            throw new IllegalArgumentException("잘못된 값 입력");
        }
        cart.changeCount(answer, num);
        homePage();
    }

    public void removePage(){
        System.out.println("===== 삭제하기 =====\n");
        System.out.println("현재 장바구니\n");
        for(int i = 0; i < cart.getItems().size(); i++){
            System.out.println((i+1) + ". " + cart.getItems().get(i).toString());
        }

        System.out.print("\n삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int answer = scanner.nextInt();

        if(answer == 0){
            homePage();
        }else if(answer<0 || answer>cart.getItems().size()){
            throw new IllegalArgumentException("잘못된 값 입력");
        }

        System.out.print("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제):");
        int num = scanner.nextInt();
        if(num == 0){
            homePage();
        }else if(num == 1){
            cart.removeItem(num);
            homePage();
        }else{
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }
}