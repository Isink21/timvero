package Resources;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class RANDOM_ID {
    @Step
    public static String randomID(){
        String symbols = "123456789012345";

        char[] array = symbols.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(i, String.valueOf(array[i]));
        }
        Collections.shuffle(arrayList);
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(arrayList.get(i));
        }
        //System.out.println(sb);
        return id.toString();
    }
}
