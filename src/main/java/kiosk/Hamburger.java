package kiosk;

public class Hamburger extends Menu {
    public Hamburger() {
        super();
        menu.add(new Item("와퍼", 6900));
        menu.add(new Item("큐브 스테이크 와퍼", 8900));
        menu.add(new Item("콰트로 치즈 와퍼", 7900));
        menu.add(new Item("몬스터 와퍼", 9300));
        menu.add(new Item("통새우 와퍼", 7900));
        menu.add(new Item("블랙바베큐 와퍼", 9300));
    }
}
