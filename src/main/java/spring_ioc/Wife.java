package spring_ioc;

public class Wife {
    String name;

    public Wife(String name) {
        this.name = name;
    }

    public Wife() {
        System.out.println("Wife加载");
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
