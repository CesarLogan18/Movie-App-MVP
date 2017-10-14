package com.rappi.rappitest.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ErrorHandlerUtils {
    private static final String EXCEPTION_MSG = "Excep handled early, param cannot be null";

    public static void mCheckNotNull(@Nullable Object o) {
        if (o == null) {
            throw new IllegalArgumentException(EXCEPTION_MSG);
        }
    }

    @NonNull
    public static String checkIfStringNullReturnEmpty(@Nullable String s) {
        if (s != null)
            return s;
        else {
            return "";
        }
    }
}
