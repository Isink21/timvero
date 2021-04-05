package Resources;

import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.util.ArrayList;
import java.util.Collections;

@Story(value = "Random name")
public class RANDOM_NAME {
    @Step
    public static String randomName(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";

        char[] array = symbols.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(i, String.valueOf(array[i]));
        }
        Collections.shuffle(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(arrayList.get(i));
        }
        //System.out.println(sb);
        return sb.toString();
    }
}
