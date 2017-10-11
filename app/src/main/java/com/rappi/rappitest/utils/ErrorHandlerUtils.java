package com.rappi.rappitest.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

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

    @NonNull
    public static Boolean checkIfBooleanNullReturnFalse(@Nullable Boolean b) {
        if (b != null)
            return b;
        else {
            return false;
        }
    }

    @NonNull
    public static Object returnNotNull(@Nullable Object o) {
        if (o == null) {
            throw new IllegalArgumentException(EXCEPTION_MSG);
        } else {
            return o;
        }
    }

    public static void checkListItemsNotnull(@NonNull List<?> list) {
        mCheckNotNull(list);
        for (Object o : list) {
            if (o == null) {
                throw new IllegalArgumentException(EXCEPTION_MSG);
            }
        }
    }
}
