package kiosk;

public class Cart {
    private Item item;
    private int count;

    public Cart(Item item) {
        this.item = item;
        this.count = 1;
    }

    // get & set Start
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    // get & set End

    // 합계 계산기
    public int priceCalculator(){
        return item.getPrice()*count;
    }

    @Override
    public String toString(){
        return item.getName() + " " + count + "개";
    }
}
