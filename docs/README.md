# 버거킹 키오스크 만들기

- 문제정의
    - 화면 구성
        - 홈
            - 햄버거 | 사이드 | 음료 | 장바구니 | 종료
        - 햄버거 | 사이드 | 음료 선택
            - 리스트와 가격
        - 장바구니
            - 담은 메뉴 리스트
            - 주문하기 | 수량 조절하기 | 삭제하기
- 설계
    - 구상
        - Class .ver
            - Item

                ```java
                Class Item{
                	private String name;
                	private int price;
                	
                	public String toString()
                }
                ```

            - Menu

                ```java
                Class Menu{
                	ArrayList<Item> menu;
                	
                	Menu(){
                		menu = new ArrayList<>();
                	}
                	
                	public static Menu createMenu(){
                		menu = new ArrayList<>();
                		
                		menu.addAll(new Hamburger());
                		menu.addAll(new Side());
                		menu.addAll(new Drink());
                	}
                	
                	public String toString(){
                		for(Item item : this){
                			item.toString();
                		}
                	}
                }
                ```

            - Hamburger

                ```java
                Class Hamburger extends Menu{
                	Hamburger(){
                		super();
                		this.add();
                	}
                	
                }
                ```

            - Side

                ```java
                Class Side extends Menu{
                	Side(){
                		super();
                		this.add();
                	}
                	
                }
                ```

            - Drink

                ```java
                Class Drink extends Menu{
                	Drink(){
                		super();
                		this.add();
                	}
                	
                }
                ```

            - Cart

                ```java
                Class Cart{
                	private Item item;
                	private int count;
                	
                	public Cart(Item item){
                		this.item = item;
                		count = 1;
                	}
                	
                	public int priceCalculator(){
                		return item.price*count;
                	}
                	
                	@Override
                	public String toString();
                }
                ```

            - Kiosk

                ```java
                Class Kiosk{
                	private ArrayList<Cart> cart;
                	private Menu menu;
                	
                	Kiosk(){
                		cart = new ArrayList<>();
                		menu = Menu.createMenu();
                	}
                	
                	public int totalPrice();
                	public boolean isCart();
                	
                	public void homePage();
                	public void hamburgerPage();
                	public void sidePage();
                	public void drinkPage();
                	public void cartPage();
                	public void orderPage();
                	public void updatePage();
                	public void deletePage();
                }
                ```

        - Enum .ver
            - 햄버거 | 사이드 | 음료 : Enum

                ```java
                - 이름
                - 가격
                
                + toString()
                + 전체 출력
                ```

            - 장바구니 : Class

                ```java
                - 이름
                - 개수
                
                + valueOf()로 가격 계산
                ```

            - 키오스크

                ```java
                + 햄버거
                + 사이드
                + 음료
                
                - ArrayList<Enum> 메뉴
                - arraylist 장바구니
                
                + 주문
                + 수량 
                + 삭제
                ```

    - 구현
        - First
            - Class
                - Cart

                    ```java
                    package kiosk;
                    
                    import java.util.ArrayList;
                    
                    public class Cart {
                        private ArrayList<Item> items;
                    
                        public Cart() {
                            items = new ArrayList<>();
                        }
                    
                        public Cart(ArrayList<Item> items) {
                            this.items = items;
                        }
                    
                        public ArrayList<Item> getItems() {
                            return items;
                        }
                        public void setItems(ArrayList<Item> items) {
                            this.items = items;
                        }
                    
                        public int validItems(String label){
                            for(Item cartItem : items){
                                if(cartItem.getLabel().equals(label)){
                                    return items.indexOf(cartItem);
                                }
                            }
                            return -1;
                        }
                    
                        public void addItem(String label){
                            int index = validItems(label);
                            if(index == -1) {
                                items.add(new Item(label, 1));
                            }else{
                                if(items.get(index).getCount()<50){
                                    items.get(index).setCount(items.get(index).getCount() + 1);
                                }else{
                                    System.out.println("단일품목의 최대 수량은 50개 입니다.");
                    
                                }
                            }
                        }
                    
                        public int priceCalculator(){
                            int price = 0;
                            for(Item item : items){
                                if(item.matchHamburger()!=null){
                                    price += item.matchHamburger().getPrice()*item.getCount();
                                }else if(item.matchSide()!=null){
                                    price += item.matchSide().getPrice()*item.getCount();
                                }else if(item.matchDrink()!=null){
                                    price += item.matchDrink().getPrice()*item.getCount();
                                }
                            }
                            return price;
                        }
                    
                        public void changeCount(int index, int num){
                            items.get(index-1).setCount(num);
                        }
                    
                        public void removeItem(int index){
                            items.remove(index-1);
                        }
                    }
                    
                    ```

                - Item

                    ```java
                    package kiosk;
                    
                    public class Item {
                        private String label;
                        private int count;
                    
                        Item(String label, int count) {
                            this.label = label;
                            this.count = count;
                        }
                    
                        public String getLabel() {
                            return label;
                        }
                        public void setLabel(String label) {
                            this.label = label;
                        }
                    
                        public int getCount() {
                            return count;
                        }
                        public void setCount(int count) {
                            this.count = count;
                        }
                    
                        public Hamburger matchHamburger(){
                            Hamburger[] hamburger = Hamburger.values();
                            for(Hamburger hamburgerItem : hamburger){
                                if(hamburgerItem.getLabel().equals(label)){
                                    return hamburgerItem;
                                }
                            }
                            return null;
                        }
                    
                        public Side matchSide(){
                            Side[] side = Side.values();
                            for(Side sideItem : side){
                                if(sideItem.getLabel().equals(label)){
                                    return sideItem;
                                }
                            }
                            return null;
                        }
                    
                        public Drink matchDrink(){
                            Drink[] drink = Drink.values();
                            for(Drink drinkItem : drink){
                                if(drinkItem.getLabel().equals(label)){
                                    return drinkItem;
                                }
                            }
                            return null;
                        }
                    
                        @Override
                        public String toString() {
                            return label + " " + count + "개";
                        }
                    }
                    
                    ```

                - Kiosk

                    ```java
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
                    ```

                - Application

                    ```java
                    package kiosk;
                    
                    public class Application {
                        public static void main(String[] args) {
                    
                            //TODO: 구현
                            Kiosk kiosk = new Kiosk();
                            kiosk.homePage();
                        }
                    }
                    ```

            - Enum
                - Hamburger

                    ```java
                    package kiosk;
                    
                    public enum Hamburger {
                        HAMBURGER("와퍼", 6900),
                        CUBE("큐브 스테이크 와퍼", 8900),
                        CHEESE("콰트로 치즈 와퍼", 7900),
                        MONSTER("몬스터 와퍼", 9300),
                        SHRIMP("통새우 와퍼", 7900),
                        BLACK("블랙바베큐 와퍼", 9300);
                    
                        private String label;
                        private int price;
                    
                        Hamburger(String label, int price) {
                            this.label = label;
                            this.price = price;
                        }
                    
                        public String getLabel() {
                            return label;
                        }
                    
                        public int getPrice() {
                            return price;
                        }
                    
                        public String tostring() {
                            return label + " (" + price + "원)";
                        }
                    
                        public static void printSide() {
                            for(Side side : Side.values()){
                                System.out.println((side.ordinal()+1) + ". " + side.tostring());
                            }
                        }
                    }
                    ```

                - Drink

                    ```java
                    package kiosk;
                    
                    public enum Drink {
                        COKE("코카콜라", 2000),
                        COKEZERO("코카콜라 제로", 2000),
                        PEPSI("펩시", 2000),
                        PEPSIZERO("펩시 제로", 2000),
                        SPRITE("스프라이트", 2000),
                        SPRITEZERO("스프라이트 제로", 2000);
                    
                        private String label;
                        private int price;
                    
                        Drink(String label, int price) {
                            this.label = label;
                            this.price = price;
                        }
                    
                        public String getLabel() {
                            return label;
                        }
                    
                        public int getPrice() {
                            return price;
                        }
                    
                        public String tostring() {
                            return label + " (" + price + "원)";
                        }
                    
                        public static void printDrink() {
                            for(Drink drink : Drink.values()){
                                System.out.println((drink.ordinal()+1) + ". " + drink.tostring());
                            }
                        }
                    }
                    ```

                - Side

                    ```java
                    package kiosk;
                    
                    public enum Side {
                        NUGGET("너겟킹", 2500),
                        HASHBROWN("해쉬 브라운", 1800),
                        CHEESESTICK("치즈스틱", 1200),
                        ONIONRING("어니언링", 2400),
                        CRISPY("바삭킹", 3000),
                        FRENCHFRIE("감자튀김", 2000);
                    
                        private String label;
                        private int price;
                    
                        Side(String label, int price) {
                            this.label = label;
                            this.price = price;
                        }
                    
                        public String getLabel() {
                            return label;
                        }
                    
                        public int getPrice() {
                            return price;
                        }
                    
                        public String tostring() {
                            return label + " (" + price + "원)";
                        }
                    
                        public static void printSide() {
                            for(Side side : Side.values()){
                                System.out.println((side.ordinal()+1) + ". " + side.tostring());
                            }
                        }
                    }
                    ```

        - Second
    - 궁금
        - Menu라는 클래스가 정말 필요할까?
            - interface로 만들어서 메소드만 강제하는 것은 어떨까?
