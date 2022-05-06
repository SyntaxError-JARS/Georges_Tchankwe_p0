package registration.models;

public class Course {

    private String cid;
    private String c_name;
    private String fid;

    //public trainer


    public Course(String cid, String c_name, String fid) {
        this.cid = cid;
        this.c_name = c_name;
        this.fid = fid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", c_name='" + c_name + '\'' +
                ", fid='" + fid + '\'' +
                '}';
    }
}
