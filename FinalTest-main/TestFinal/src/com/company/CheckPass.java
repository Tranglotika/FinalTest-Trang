package com.company;

import java.util.regex.Pattern;

public class CheckPass {
    public static boolean isPassValid(String pass){
        final Pattern PASS_REGEX = Pattern.compile("((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{7,15})", Pattern.CASE_INSENSITIVE);
        return PASS_REGEX.matcher(pass).matches();
    }
}
