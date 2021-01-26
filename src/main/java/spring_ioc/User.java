package spring_ioc;

public class User {
    private Integer id;

    public User(Integer id, String username, String realname) {
        this.id = id;
        this.username = username;
        this.realname = realname;
    }

    private String username;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    private String realname;

    public User() {
        System.out.println("user 已加载");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"realname\":\"")
                .append(realname).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
