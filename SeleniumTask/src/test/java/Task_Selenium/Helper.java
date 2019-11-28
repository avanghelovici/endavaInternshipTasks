package Task_Selenium;

import java.util.Random;

public class Helper {

    public static final int[] RANDOM_PRODUCTS_ARRAY = new int[]{1, 2, 3, 4};
    public static final String CREDENTIALS = "artur.test@test.com";
    public static final String DRIVER_LOCATION = "C:\\Users\\avanghelovici\\IdeaProjects\\tryprog\\NewTest\\src\\main\\resources\\chromedriver.exe";

    public static int returnsInt(int[] toSort) {
        int rnd = new Random().nextInt(toSort.length);
        return toSort[rnd];
    }
}