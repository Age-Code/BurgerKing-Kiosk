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