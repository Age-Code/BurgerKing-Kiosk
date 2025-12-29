package kiosk;

import java.util.ArrayList;

public class Drink extends Menu {
    public Drink() {
        super();
        menu.add(new Item("코카콜라", 2000));
        menu.add(new Item("코카콜라 제로", 2000));
        menu.add(new Item("펩시", 2000));
        menu.add(new Item("펩시 제로", 2000));
        menu.add(new Item("스프라이트", 2000));
        menu.add(new Item("스프라이트 제로", 2000));
    }
}
