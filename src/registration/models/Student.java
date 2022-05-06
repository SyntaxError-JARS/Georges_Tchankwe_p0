package registration.models;

public class Student {
    private String sid;
    private String s_name;

    //public trainer

    public Student(String sid,String s_name) {
        super();
        this.sid=sid;
        this.s_name=s_name;
    }

    // getter and setter
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String toFileString() {
        // StringBuilder, there is also a StringBuffer (it's thread-safe)
        // Is another class for Strings that allows them to be mutated
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(sid).append(",")
                .append(s_name).append(",");

        // Without changing the mutableString class from StringBuilder we wont' have an appropriate return type
        return mutableString.toString(); // We need the toString to return it to it's appropriate type
    }

    @Override // What this is?? Annotation - basically metadata
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", s_name='" + s_name + '\''+
                '}';
    }

}
