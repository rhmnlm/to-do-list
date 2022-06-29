package com.activxg.todolist.constant;

public enum Status {
    Active("Active"),
    Finished("Finished"),
    Deleted("Deleted")
    ;

    private final String text;

    Status(String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }

}
