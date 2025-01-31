package DB2023Team03_FINAL;

public class DB2023Team03_ModelFestival {


    int festival_id;
    String name;
    String region;
    String theme;
    String season;
    String description;
    int score;
    String date;

    //축제 테이블 생성
    public DB2023Team03_ModelFestival(int festival_id, String name, String region, String theme,
                                      String season, String description, int score, String date) {
        this.festival_id = festival_id;
        this.name = name;
        this.region = region;
        this.theme = theme;
        this.season = season;
        this.description = description;
        this.score = score;
        this.date = date;
    }

  //각 변수들에 대한 getter, setter 함수
    
    public int getFestival_id() {
        return festival_id;
    }

    public void setFestival_id(int festival_id) {
        this.festival_id = festival_id;
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