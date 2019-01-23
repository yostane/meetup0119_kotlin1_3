// In java, we can definc static members and function in an interface
interface CarJava {
    public static int numberOfWheels = 4;
    public static String makeNoise(){
        return "VROOM VROOM";
    }
}

public class Misc_09 {
    public static void main(String[] args){
        int i = CarJava.numberOfWheels;
    }
}
