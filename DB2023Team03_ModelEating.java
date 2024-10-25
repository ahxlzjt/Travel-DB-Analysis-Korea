package DB2023Team03_FINAL;

public class DB2023Team03_ModelEating {

    int eating_id;
    String name;
    String region;
    String theme;
    String season;
    String description;
    int score;
    String date;

    //���� ���̺� ����
    public DB2023Team03_ModelEating(int eating_id, String name, String region, String theme,
                                    String season, String description, int score, String date) {
        this.eating_id = eating_id;
        this.name = name;
        this.region = region;
        this.theme = theme;
        this.season = season;
        this.description = description;
        this.score = score;
        this.date = date;
    }
    
  //�� �����鿡 ���� getter, setter �Լ�

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}