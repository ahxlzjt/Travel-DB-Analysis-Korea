package DB2023Team03_FINAL;

public class DB2023Team03_ModelEntertainment_korea {

    int entertainment_id;
    String name;
    String region;
    String theme;
    String season;
    String description;
    int score;
    String date;

    //관광지 생성
    public DB2023Team03_ModelEntertainment_korea(int entertainment_id, String name, String region, String theme,
                                                 String season, String description, int score, String date) {
        this.entertainment_id = entertainment_id;
        this.name = name;
        this.region = region;
        this.theme = theme;
        this.season = season;
        this.description = description;
        this.score = score;
        this.date = date;
    }

  //각 변수들에 대한 getter, setter 함수
    
    public int getEntertainment_id() {
        return entertainment_id;
    }

    public void setEntertainment_id(int entertainment_id) {
        this.entertainment_id = entertainment_id;
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
