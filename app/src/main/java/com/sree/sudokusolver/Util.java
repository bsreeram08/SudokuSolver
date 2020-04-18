package com.sree.sudokusolver;

import android.content.Context;

class Util {
    static int pxFromDp(final Context context, final float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
