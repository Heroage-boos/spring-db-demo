package org.example.entity;

public class Nation {
    private Integer N_ID;
    private String N_Name;

    public Integer getN_ID() {
        return N_ID;
    }

    public void setN_ID(Integer n_ID) {
        this.N_ID = n_ID;
    }

    public String getN_Name() {
        return N_Name;
    }

    public void setN_Name(String n_Name) {
        this.N_Name = n_Name;
    }

    public void addNation() {

    }

    public String toString(){
        return "Nation{" +
                "N_ID='" + N_ID + '\'' +
                ", N_Name='" + N_Name + '\''+
        '}';

    }
}
