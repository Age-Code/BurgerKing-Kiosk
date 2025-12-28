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