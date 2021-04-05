package Resources;

import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.util.ArrayList;
import java.util.Collections;

@Story(value = "Random email")

public class RANDOM_EMAIL {
    @Step
    public static String randomEmail(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";

        char[] array = symbols.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(i, String.valueOf(array[i]));
        }
        Collections.shuffle(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(arrayList.get(i));
        }
        //System.out.println(sb);
        return sb.toString() + "@gmail.com";
    }
}
