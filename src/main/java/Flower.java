public class Flower implements Growth {

    FlowerNamesEnum name;
    double moistureLevel; // сколько требует влаги
    double currentMoisture = 0; // текукщий уровень влаги
    double currentGrowthRate = 1; // текущий рост
    double growthRate; // скорость роста
    double waterAbsorption;
    PotColor potColor;

    public Flower(FlowerNamesEnum name, double moistureLevel, double growthRate, double waterAbsorption, PotColor potColor) {
        this.name = name;
        this.moistureLevel = moistureLevel;
        this.growthRate = growthRate;
        this.waterAbsorption = waterAbsorption;
        this.potColor = potColor;
    }

    public void politCvetok() {
        this.currentMoisture += moistureLevel;
    }

    public void downgradeMoisture() {
        this.currentMoisture -= moistureLevel;
    }

    public void scaleGrowthRate() {
        this.currentGrowthRate += growthRate;
    }

    public void nextDay() {
        scaleGrowthRate();
        downgradeMoisture();
    }

    public void flowerInfo(Flower flower) {
        System.out.printf("Название цветка: %s Уровень влаги: %f Скорость роста: %f Текущий рост: %f Пьет воды: %f, Цвет горшка: %s\n", flower.name, flower.currentMoisture, flower.growthRate, flower.currentGrowthRate, flower.waterAbsorption, flower.potColor);
    }
}

