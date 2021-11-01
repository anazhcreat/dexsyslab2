import it.sauronsoftware.cron4j.Scheduler;

import java.util.*;

public class Main {
    private static ArrayList<Flower> flowers = new ArrayList<Flower>();

    public static void main(String[] args) {
        Flower roza = new Flower(FlowerNamesEnum.ROZA, 0.5, 1, 2, PotColor.RED);
        Flower ficus = new Flower(FlowerNamesEnum.FICUS, 0.8, 1.3, 3, PotColor.GREEN);
        Flower aloe = new Flower(FlowerNamesEnum.ALOE, 0.7, 2.1, 1, PotColor.BLACK);
        Flower cactus = new Flower(FlowerNamesEnum.CACTUS, 0.1, 2, 2.5, PotColor.BLUE);
        Flower orchid = new Flower(FlowerNamesEnum.ORCHID, 0.9, 3, 1.2, PotColor.YELLOW);

        Scheduler nextDay = new Scheduler();
        Main.flowers.add(roza);
        Main.flowers.add(ficus);
        Main.flowers.add(aloe);
        Main.flowers.add(cactus);
        Main.flowers.add(orchid);

        // schedule каждую минуту делает вид, что наступает следующий день
        nextDay.schedule("* * * * *", new Runnable() {
            public void run() {
                Main.flowers.forEach(flower -> {
                    flower.nextDay();
                    flower.flowerInfo(flower);
                });
            }
        });
        nextDay.start();
    }
}