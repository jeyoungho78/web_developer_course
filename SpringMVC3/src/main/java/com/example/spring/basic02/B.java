package com.example.spring.basic02;


public class B {

    public B() {
        GlobalObject.setValue("Completed");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("B");
        sb.append("{}");
        sb.append("GlobalObject.getValue()=").append(GlobalObject.getValue()).append("}");
        return sb.toString();
    }
}

