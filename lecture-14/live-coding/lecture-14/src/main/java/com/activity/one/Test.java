package com.activity.one;

import java.util.Objects;

public class Test {
    private int type;
    private int name;

    public Test(int type, int name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean equals(Test o) {
        if (!(o instanceof Test test)) {
            return false;
        }
        return getType() == test.getType() && getName() == test.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName());
    }

    @Override
    public String toString() {
        return "Test{" +
            "type=" + type +
            ", name=" + name +
            '}';
    }
}
