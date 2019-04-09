package dto;

import interfaces.Drink;
import interfaces.ToPee;

public class Human implements Comparable<Human> {
    private String name;
    private Integer age;
    private Integer weight;
    private ToPee toPee;
    private Drink drink;

    public Human(String name, Integer age, Integer weight, ToPee toPee, Drink drink) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.toPee = toPee;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public ToPee getToPee() {
        return toPee;
    }

    public Drink getDrink() {
        return drink;
    }

    public int compareTo(Human human) {
        return this.age.compareTo(human.getAge());
    }
}