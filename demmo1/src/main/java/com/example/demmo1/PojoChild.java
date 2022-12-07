package com.example.demmo1;

public class PojoChild {

    private String Name;
    private String SecondName;
    private String ThirdName;
    private String Gender;

    public PojoChild(String Name, String SecondName, String ThirdName, String Gender) {
        this.Name = Name;
        this.SecondName = SecondName;
        this.ThirdName = ThirdName;
        this.Gender = Gender;
    }

    public PojoChild() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String ThirdName) {
        this.ThirdName = ThirdName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
}
