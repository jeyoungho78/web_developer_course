package com.example.spring.basic02;

public class A {

    public A() {
        GlobalObject.setValue("Undetermined");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("{}");
        sb.append("GlobalObject.getValue()=").append(GlobalObject.getValue()).append("}");
        return sb.toString();
    }
}

