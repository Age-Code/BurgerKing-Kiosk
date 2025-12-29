package kiosk;

import java.util.ArrayList;

public class Menu {
    ArrayList<Item> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    // get & set Start
    public ArrayList<Item> getMenu() {
        return menu;
    }
    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }
    // get & set End

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<menu.size(); i++){
            sb.append(i+1);
            sb.append(". ");
            sb.append(menu.get(i).toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
