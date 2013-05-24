package us.codecraft.blackhole.suite.model;

/**
 * User: cairne
 * Date: 13-5-11
 * Time: 上午9:02
 */
public class CustomZone {

    private int id;

    private int groupId;

    private String pattern;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
