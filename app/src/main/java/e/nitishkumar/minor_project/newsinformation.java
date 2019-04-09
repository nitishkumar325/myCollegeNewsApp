package e.nitishkumar.minor_project;
public class newsinformation {
    String Title;
    String date;
    String image;
    String inshort;
    String nexturl;

    public newsinformation(String title, String inshort, String image, String date,String nexturl) {
        Title = title;
        this.date = date;
        this.image = image;
        this.inshort = inshort;
        this.nexturl=nexturl;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setinshort(String detail) {
        this.inshort = detail;
    }

    public void setNexturl(String nexturl) {
        this.nexturl = nexturl;
    }

    public String getTitle() {
        return Title;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getinshort() {
        return inshort;
    }

    public String getNexturl() {
        return nexturl;
    }
}
