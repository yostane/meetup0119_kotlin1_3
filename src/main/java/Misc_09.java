public class Misc_09 {
    public static void main(String[] args){
        int i = CarJava.numberOfWheels;

        i = Car.nbWheels;
        // However in java, the are not directly accessible
        OldKotlinCar.Companion.getNbWheels();
    }
}
