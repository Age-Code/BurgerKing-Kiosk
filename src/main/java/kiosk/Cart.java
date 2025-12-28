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
