package main;
// 基本情報H27春季午後Java 設問のコード
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//
//}
//// [プログラム 1]
//abstract public class Encoder {
//    private Map<Character, String> conversionTable = new HashMap<Character, String>();
//
//    protected void addConversion(char c, String s) {
//        conversionTable.put(c, s);
//    }
//    protected void addNoConversion(char c) {
//        conversionTable./*(a)*/;
//    }
//    protected void addNoConversion(char[] collection) {
//        for (char c : collection) {
//            addNoConversion(c);
//        }
//    }
//
//    abstract protected String encode(char c);
//
//    public String encode(String s) {
//        if (s == null) {
//            return null;
//        }
//        String result = "";
//        for (char c : /* (B) */) {
//            String t = /* (C )*/;
//            if (t == null) {
//                t = encode(c);
//            }
//            result += t;
//        }
//        return result;
//    }
//
//}
//
//// [プログラム 2]
//public class HtmlEncoder extends Encoder {
//    private  static String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static String  NUMERICS = "0123456789";
//    private static String PUNCTUATIONS = "!#$%()*+,-.:;=?@[\\]^_`{|}~";
//
//    public HtmlEncoder() {
//        addNoConversion(ALPHAS.toCharArray());
//        addNoConversion(ALPHAS.toLowerCase().toCharArray());
//        addNoConversion(NUMERICS.toCharArray());
//        addNoConversion(PUNCTUATIONS.toCharArray());
//        addConversion('<', "&lt;");
//        addConversion('>', "&gt");
//        addConversion('&', "&amp");
//        addConversion('"', "&quot");
//    }
//
//    protected String encode(char c) {
//        return /*d*/;
//    }
//}
//
//// [プログラム 3]
//public class JavaScriptEncoder extends Encoder {
//    private  static String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static String  NUMERICS = "0123456789";
//
//    public JavaScriptEncoder() {
//        addNoConversion(ALPHAS.toCharArray());
//        addNoConversion(ALPHAS.toLowerCase().toCharArray());
//        addNoConversion(NUMERICS.toCharArray());
//    }
//
//    protected String encode(char c) {
//        if (c /* (e) */ 256) {
//            return String.format("\\x%02X", (int) c);
//        }
//        return String.format("\\u%04X", (int) c);
//    }
//}
//
//// [プログラム 4]
///*public*/ class HtmlEncoderTest {
//    static public void main(String[] args) {
//        new HtmlEncoder().encode("<script>alert('注意!');</script>");
//    }
//}

// 基本情報H27春季午後Java 解答のコード
import java.util.HashMap;
import java.util.Map;

public class Main {

}
// [プログラム 1]
abstract /*public*/ class Encoder {
    private Map<Character, String> conversionTable = new HashMap<Character, String>();

    protected void addConversion(char c, String s) {
        conversionTable.put(c, s);
    }
    protected void addNoConversion(char c) {
        conversionTable.put(c, String.valueOf(c)); /* conversionTable.(a); */
    }
    protected void addNoConversion(char[] collection) {
        for (char c : collection) {
            addNoConversion(c);
        }
    }

    abstract protected String encode(char c);

    public String encode(String s) {
        if (s == null) {
            return null;
        }
        String result = "";
        for (char c : s.toCharArray()) { /* char c (b) */
            String t = conversionTable.get(c); /* String t = (c)*/
            if (t == null) {
                t = encode(c);
            }
            result += t;
        }
        return result;
    }

}

// [プログラム 2]
/*public*/ class HtmlEncoder extends Encoder {
    private  static String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String  NUMERICS = "0123456789";
    private static String PUNCTUATIONS = "!#$%()*+,-.:;=?@[\\]^_`{|}~";

    public HtmlEncoder() {
        addNoConversion(ALPHAS.toCharArray());
        addNoConversion(ALPHAS.toLowerCase().toCharArray());
        addNoConversion(NUMERICS.toCharArray());
        addNoConversion(PUNCTUATIONS.toCharArray());
        addConversion('<', "&lt;");
        addConversion('>', "&gt");
        addConversion('&', "&amp");
        addConversion('"', "&quot");
    }

    protected String encode(char c) {
        return "&#" + (int) c + ";"; /* return (d) ; */
    }
}

// [プログラム 3]
/*public*/ class JavaScriptEncoder extends Encoder {
    private  static String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String  NUMERICS = "0123456789";

    public JavaScriptEncoder() {
        addNoConversion(ALPHAS.toCharArray());
        addNoConversion(ALPHAS.toLowerCase().toCharArray());
        addNoConversion(NUMERICS.toCharArray());
    }

    protected String encode(char c) {
        if (c < 256) { /* c (e) 256 */
            return String.format("\\x%02X", (int) c);
        }
        return String.format("\\u%04X", (int) c);
    }
}

// [プログラム 4]
/*public*/ class HtmlEncoderTest {
    static public void main(String[] args) {
        new HtmlEncoder().encode("<script>alert('注意!');</script>");
    }
}