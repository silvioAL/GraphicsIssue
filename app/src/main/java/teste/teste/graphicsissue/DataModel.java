package teste.teste.graphicsissue;

public class DataModel {

    String date;
    String blueLine;
    String blueBar;
    String orangeBar;
    String redLine;
    String type;

    public DataModel(String redLine, String blueLine, String blueBar, String orangeBar, String date, String type) {
        this.date = date;
        this.blueLine = blueLine;
        this.blueBar = blueBar;
        this.orangeBar = orangeBar;
        this.redLine = redLine;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBlueLine() {
        return blueLine;
    }

    public void setBlueLine(String blueLine) {
        this.blueLine = blueLine;
    }

    public String getBlueBar() {
        return blueBar;
    }

    public void setBlueBar(String blueBar) {
        this.blueBar = blueBar;
    }

    public String getOrangeBar() {
        return orangeBar;
    }

    public void setOrangeBar(String orangeBar) {
        this.orangeBar = orangeBar;
    }

    public String getRedLine() {
        return redLine;
    }

    public void setRedLine(String redLine) {
        this.redLine = redLine;
    }

}
