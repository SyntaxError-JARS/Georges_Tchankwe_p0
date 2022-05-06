package registration.models;

public class Faculty {
    private String fid;
    private String f_name;

    //public trainer

    public Faculty(String fid,String f_name) {
        super();
        this.fid=fid;
        this.f_name=f_name;
    }

    // getter and setter
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String toFileString() {
        // StringBuilder, there is also a StringBuffer (it's thread-safe)
        // Is another class for Strings that allows them to be mutated
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(fid).append(",")
                .append(f_name).append(",");

        // Without changing the mutableString class from StringBuilder we wont' have an appropriate return type
        return mutableString.toString(); // We need the toString to return it to it's appropriate type
    }

    @Override // What this is?? Annotation - basically metadata
    public String toString() {
        return "Faculty{" +
                "fid='" + fid + '\'' +
                ", f_name='" + f_name + '\''+
                '}';
    }



}
