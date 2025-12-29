package kiosk;

public class Item {
    private String name;
    private int price;

    // 생성자(name, price)
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // get & set Start
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    // get & set End

    @Override
    public String toString() {
        return name + " (" +  price + "원)";
    }
}
