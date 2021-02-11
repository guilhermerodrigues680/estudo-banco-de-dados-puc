package com.db.estudo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {

    public static boolean charIsNumber(char c) {
        Pattern pattern = Pattern.compile("\\d", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(Character.toString(c));
        return matcher.find();
    }

}
