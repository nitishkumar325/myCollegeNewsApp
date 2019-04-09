package e.nitishkumar.minor_project;

public class notice {
    String date;
    String notice;
    String signature;

    public notice(String date, String notice, String signature) {
        this.date = date;
        this.notice = notice;
        this.signature = signature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
