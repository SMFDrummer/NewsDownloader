package net.heishanrm;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomScanner {
    public static int Int(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine().trim());
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:" + num);
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        return num;
                    }
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个整数");
            }
        }
    }

    public static int Int(boolean confirm, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine().trim());
                if (Pattern.matches(regex, Integer.toString(num))) {
                    if (confirm) {
                        Log.v("重新输入(R)或回车继续:" + num);
                        if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                            Log.v("重新输入");
                        } else {
                            return num;
                        }
                    } else {
                        return num;
                    }
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个匹配正则" + regex + "的整数");
            }
        }
    }


    public static BigInteger BigInteger(boolean confirm) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                BigInteger num = new BigInteger(scanner.nextLine().trim());
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:" + num);
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        return num;
                    }
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个整数");
            }
        }
    }

    public static BigInteger BigInteger(boolean confirm, String regex) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                BigInteger num = new BigInteger(scanner.nextLine().trim());
                if (Pattern.matches(regex, num.toString())) {
                    if (confirm) {
                        Log.v("重新输入(R)或回车继续:" + num);
                        if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                            Log.v("重新输入");
                        } else {
                            return num;
                        }
                    } else {
                        return num;
                    }
                } else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个匹配正则" + regex + "的整数");
            }
        }
    }

    public static String String(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine().trim();
            if (confirm) {
                Log.v("重新输入(R)或回车继续:" + str);
                if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                    Log.v("重新输入");
                } else {
                    scanner.close();
                    return str;
                }
            } else {
                scanner.close();
                return str;
            }
        }
    }

    public static String String(boolean confirm, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine().trim();
            if (Pattern.matches(regex, str)) {
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:" + str);
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        scanner.close();
                        return str;
                    }
                } else {
                    scanner.close();
                    return str;
                }
            } else Log.e("非法输入，请输入一个匹配正则" + regex + "的字符串");
        }
    }

    public static String Paragraph(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            StringBuilder sb = new StringBuilder();
            int emptyLineCount = 0;
            while (emptyLineCount < 2) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    emptyLineCount++;
                    sb.append("\n");
                } else {
                    sb.append(line);
                    if (scanner.hasNextLine()) {
                        sb.append("\n");
                    }
                    emptyLineCount = 0;
                }
            }
            String content = sb.toString().trim();
            if (confirm) {
                Log.a(content);
                Log.v("重新输入(R)或回车继续");
                if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                    Log.v("重新输入");
                } else {
                    scanner.close();
                    return content;
                }
            } else {
                scanner.close();
                return content;
            }
        }
    }

    public static double Double(boolean confirm) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                double num = Double.parseDouble(scanner.nextLine().trim());
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:" + num);
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        return num;
                    }
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个小数");
            } catch (NullPointerException e) {
                Log.e("输入为空，请检查是否输入");
            }
        }
    }

    public static double Double(boolean confirm, String regex) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                double num = Double.parseDouble(scanner.nextLine().trim());
                if (Pattern.matches(regex, Double.toString(num))) {
                    if (confirm) {
                        Log.v("重新输入(R)或回车继续:" + num);
                        if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                            Log.v("重新输入");
                        } else {
                            return num;
                        }
                    } else {
                        return num;
                    }
                } else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                Log.e("非法输入，请输入一个匹配正则" + regex + "的整数");
            } catch (NullPointerException e) {
                Log.e("输入为空，请检查是否输入");
            }
        }
    }

    public static boolean Boolean(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Log.v("请输入(Y/N)");
            if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:true");
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        scanner.close();
                        return true;
                    }
                } else {
                    scanner.close();
                    return true;
                }
            } else if (scanner.nextLine().trim().equalsIgnoreCase("N")) {
                if (confirm) {
                    Log.v("重新输入(R)或回车继续:false");
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        scanner.close();
                        return false;
                    }
                } else {
                    scanner.close();
                    return false;
                }
            } else {
                Log.e("非法输入，请输入Y或N");
            }
        }
    }

    public static JSONObject JSONObject(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = Paragraph(false);
            if (JSON.isValidObject(str)) {
                JSONObject jsonObject = JSON.parseObject(str);
                if (confirm) {
                    Log.a(jsonObject.toJSONString(JSONWriter.Feature.WriteMapNullValue));
                    Log.v("重新输入(R)或回车继续");
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        scanner.close();
                        return jsonObject;
                    }
                } else {
                    scanner.close();
                    return jsonObject;
                }
            } else {
                Log.e("非法输入，请输入正确格式的{JSON}数据");
            }
        }
    }

    public static JSONArray JSONArray(boolean confirm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = Paragraph(false);
            if (JSON.isValidArray(str)) {
                JSONArray jsonArray = JSON.parseArray(str);
                if (confirm) {
                    Log.a(jsonArray.toJSONString(JSONWriter.Feature.WriteMapNullValue));
                    Log.v("重新输入(R)或回车继续");
                    if (scanner.nextLine().trim().equalsIgnoreCase("R")) {
                        Log.v("重新输入");
                    } else {
                        scanner.close();
                        return jsonArray;
                    }
                } else {
                    scanner.close();
                    return jsonArray;
                }
            } else {
                Log.e("非法输入，请输入正确格式的[JSON]数据");
            }
        }
    }
}
