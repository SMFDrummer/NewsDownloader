package net.heishanrm.M3u8.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringUtils {

    public static boolean isBlank(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isUrl(String str) {
        if (isEmpty(str))
            return false;
        str = str.trim();
        return str.matches("^(http|https)://.+");
    }

    public static String convertToDownloadSpeed(BigDecimal bigDecimal, int scale) {
        BigDecimal unit = new BigDecimal(1);
        BigDecimal kb = new BigDecimal(1 << 10);
        BigDecimal mb = new BigDecimal(1 << 10).multiply(kb);
        BigDecimal gb = new BigDecimal(1 << 10).multiply(mb);
        BigDecimal tb = new BigDecimal(1 << 10).multiply(gb);
        BigDecimal pb = new BigDecimal(1 << 10).multiply(tb);
        BigDecimal eb = new BigDecimal(1 << 10).multiply(pb);
        if (bigDecimal.divide(kb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(unit, scale, RoundingMode.HALF_UP) + " B";
        else if (bigDecimal.divide(mb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(kb, scale, RoundingMode.HALF_UP) + " KB";
        else if (bigDecimal.divide(gb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(mb, scale, RoundingMode.HALF_UP) + " MB";
        else if (bigDecimal.divide(tb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(gb, scale, RoundingMode.HALF_UP) + " GB";
        else if (bigDecimal.divide(pb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(tb, scale, RoundingMode.HALF_UP) + " TB";
        else if (bigDecimal.divide(eb, scale, RoundingMode.HALF_UP).compareTo(unit) < 0)
            return bigDecimal.divide(pb, scale, RoundingMode.HALF_UP) + " PB";
        return bigDecimal.divide(eb, scale, RoundingMode.HALF_UP) + " EB";
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if ((len & 1) == 1) {
            s = "0" + s;
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
