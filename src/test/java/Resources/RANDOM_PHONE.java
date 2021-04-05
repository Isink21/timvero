package Resources;

import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.util.ArrayList;
import java.util.Collections;

@Story(value = "Random phone")
public class RANDOM_PHONE {
    @Step
    public static String randomPhone(){
        String symbols = "1234567890";

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
        return "8044" + sb.toString();
    }
}
