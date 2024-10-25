package DB2023Team03_FINAL;

public class DB2023Team03_ModelBookmarks {


    int id;
    String name;
    String region;
    String theme;
    String season;
    String description;
    int score;
    String date;


    //�ϸ�ũ ���̺� ����
    public DB2023Team03_ModelBookmarks(int id, String name, String region, String theme,
                                       String season, String description, int score, String date) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.theme = theme;
        this.season = season;
        this.description = description;
        this.score = score;
        this.date = date;
    }
    
   //�� �����鿡 ���� getter, setter �Լ�
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
