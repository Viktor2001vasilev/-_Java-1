package model;

import java.util.Scanner;

public class Kotik {
    // Cчетчик котов
    private static int katCounter;

    //---------------------------Переменные котов--------------------
    private int satiety = 5;
    private String name;
    private int weight;
    private int prettiness;
    private String meow;
    //---------------------------------------------------------------

    //-------------------Конструкторы, установка параметров----------
    public Kotik (String name, int weight, int prettiness, String meow) {
        this.name = name;
        this.weight = weight;
        this.prettiness = prettiness;
        this.meow = meow;
        katCounter++;
    }
    public Kotik () {
        katCounter++;
    }
    public void setKotik (String name, int weight, int prettiness, String meow) {
        this.name = name;
        this.weight = weight;
        this.prettiness = prettiness;
        this.meow = meow;
    }
    //---------------------------------------------------------------

    //---------------------------Геттеры переменных------------------
    public int getIntValue(int a) {
        switch (a) {
            case 1:
                return satiety;
            case 2:
                return weight;
            default:
                return prettiness;
        }
    }
    public String getStringValue(int a) {
        return (a == 1)?name:meow;
    }
    public static int getKatCounter() {
        return katCounter;
    }
    //---------------------------------------------------------------

    //---------------------------Действия котов----------------------
    //Есть
    private boolean eatOrNotToEat(int kg) {
        if ((weight + kg) > 15) return false;
        else return true;
    }
    public boolean eat(int kg) {
        if (!eatOrNotToEat(kg)) {
            System.out.println(name +" уже и так слишком толстый!");
            return false;
        }
        else {
            satiety += kg;
            weight += kg;
            System.out.println(name + " покушал");
            return true;
        }

    }
    public boolean eat(int kg, String food) {
        if (!eatOrNotToEat(kg)) {
            System.out.println(name +" уже и так слишком толстый!");
            return false;
        }
        else {
            satiety += kg;
            weight += kg;
            System.out.println(name + " покушал " + food + ".");
            return true;
        }

    }
    public boolean eat() {
        if (!eat(4, "кошачий корм")) return false;
        else return true;
    }
    //Играть
    public boolean play() {
        if (satiety <= 0) {
            System.out.println(name + " слишком голоден, чтобы играть!");
            return false;
        }
        else {
            System.out.println(name + " играет с вазой.");
            satiety -= 2;
            weight -= 2;
            return true;
        }
    }
    //Спать
    public boolean sleep() {
        if (satiety <= 0) {
            System.out.println(name + " слишком голоден, чтобы спать!");
            return false;
        }
        else {
            System.out.println(name + " крепко спит.");
            satiety -= 1;
            weight -= 1;
            return true;
        }
    }
    //Умыться
    public boolean wash() {
        if (satiety <= 0) {
            System.out.println(name + " слишком голоден, чтобы мыться!");
            return false;
        }
        else {
            System.out.println(name + " умывается.");
            satiety -= 1;
            weight -= 1;
            return true;
        }
    }
    //Ловить мышь
    public boolean chaseMouse() {
        if (satiety <= 0) {
            System.out.println(name + " слишком голоден, чтобы гоняться за мышами!");
            return false;
        } else {
            System.out.println(name + " терроризирует мышей.");
            satiety -= 3;
            weight -= 3;
            return true;
        }
    }
    //---------------------------------------------------------------

    //---------------------------Live Another Day--------------------
    public void liveAnotherDay() {
        for (int count = 0; count < 24; count++) {
            System.out.println("ШЕЛ "+ (count+1) + " ЧАС...");
            int randomToDoNumber = 1 + (int)(Math.random()*5);
            switch (randomToDoNumber) {
                case 1:
                    if (!eat()) {
                        feedTheCat();
                        break;
                    }
                    else break;
                case 2:
                    if (!play()) {
                        feedTheCat();
                        break;
                    }
                    else break;
                case 3:
                    if (!sleep()) {
                        feedTheCat();
                        break;
                    }
                    else break;
                case 4:
                    if (!wash()) {
                        feedTheCat();
                        break;
                    }
                    else break;
                case 5:
                    if (!chaseMouse()) {
                        feedTheCat();
                        break;
                    }
                    else break;
            }
        }
    }
    //---------------------------------------------------------------

    //---------------------------Покормить кота ---------------------
    public void feedTheCat() {
        Scanner getFromGamer = new Scanner(System.in);
        String pressEnter;
        System.out.println("Покорми кота!");
        do {
            System.out.println("Нажмите Enter, чтобы покормить кота.");
            pressEnter = getFromGamer.nextLine();
            if (pressEnter.equals("")) {
                eat();
            } else {
                System.out.println("Это не Enter.");
            }
        }
        while (!pressEnter.equals(""));
    }
    //---------------------------------------------------------------


}
