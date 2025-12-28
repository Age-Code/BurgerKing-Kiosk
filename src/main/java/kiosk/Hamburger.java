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