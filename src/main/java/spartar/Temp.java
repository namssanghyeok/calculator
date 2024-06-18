package spartar;

import java.util.Arrays;

public class Temp {
    public String solution(String s) {
        if (s.length() / 2 != 0) {
            return Character.toString(s.charAt(s.length() / 2));
        } else {
            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        }
    }
}
