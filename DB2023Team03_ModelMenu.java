package DB2023Team03_FINAL;

public class DB2023Team03_ModelMenu {

    int num_registed;
    int eating_id;
    String name;
    String menu;
    String cost;


    //메뉴 테이블 생성
    public DB2023Team03_ModelMenu(int num_registed, int eating_id, String name, String menu, String cost) {
        this.num_registed = num_registed;
        this.eating_id = eating_id;
        this.name = name;
        this.menu = menu;
        this.cost = cost;
    }

  //각 변수들에 대한 getter, setter 함수
    
    public int getNum_registed() {
        return num_registed;
    }

    public void setNum_registed(int num_registed) {
        this.num_registed = num_registed;
    }

    public int getEating_id() {
        return eating_id;
    }

    public void setEating_id(int eating_id) {
        this.eating_id = eating_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}

	