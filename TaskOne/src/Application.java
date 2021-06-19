import model.Kotik;

public class Application {
    public static void main(String[] args){
        Kotik kotik1 = new Kotik("Барсик",5,100,"meoooow");
        Kotik kotik2 = new Kotik();
        kotik2.setKotik("Том",10,100,"MEOOOOOW!");

        kotik1.liveAnotherDay();
        System.out.println("После тяжелого дня нашего кота по прежднему зовут " + kotik1.getStringValue(1)
                            + " и он весит целых " + kotik1.getIntValue(2) + " кг!");

        System.out.println("У нас тут два кота! Интересно, они одинаково мяукают?");
        System.out.println(kotik1.getStringValue(1) + " говорит " + kotik1.getStringValue(2));
        System.out.println(kotik2.getStringValue(1) + " говорит " + kotik2.getStringValue(2));
        if (kotik1.getStringValue(2).equals(kotik2.getStringValue(2))) System.out.println("Так и знал, что все коты одинаковые!");
        else System.out.println("Нет, по разному.");

        System.out.println("Что-ж, сегодня мы увидели целых " + Kotik.getKatCounter() + " кота!");
    }
}
