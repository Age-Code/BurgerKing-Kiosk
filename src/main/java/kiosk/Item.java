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
