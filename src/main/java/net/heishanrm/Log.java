package net.heishanrm;

public class Log {
    public static Pair Separator = p(" || ", Color.WHITE);

    /**
     * @Description: Error - 红色 - 错误
     */
    public static void e(String message) {
        System.out.println(Color.RED + "● " + message + Color.RESET);
    }

    /**
     * @Description: Debug - 青色 - 调试
     */
    public static void d(String message) {
        System.out.println(Color.CYAN + "● " + message + Color.RESET);
    }

    /**
     * @Description: Info - 蓝色 - 信息
     */
    public static void i(String message) {
        System.out.println(Color.BLUE + "● " + message + Color.RESET);
    }

    /**
     * @Description: Verbose - 黄色 - 提示
     */
    public static void v(String message) {
        System.out.println(Color.YELLOW + "● " + message + Color.RESET);
    }

    /**
     * @Description: Warning - 紫色 - 警告
     */
    public static void w(String message) {
        System.out.println(Color.PURPLE + "● " + message + Color.RESET);
    }

    /**
     * @Description: Success - 绿色 - 成功
     */
    public static void s(String message) {
        System.out.println(Color.GREEN + "● " + message + Color.RESET);
    }

    /**
     * @Description: Alert - 白色 - 描述
     */
    public static void a(String message) {
        System.out.println(Color.WHITE + message + Color.RESET);
    }

    /**
     * @Description: Bar - 自定义颜色 - 进度条
     */
    public static void b(Pair pair) {
        System.out.println(String.valueOf(pair.color) + pair.content + Color.RESET);
    }

    /**
     * @Description: 自定义输出内容以及每段输出的颜色
     */
    public static void c(Pair... pairs) {
        StringBuilder sb = new StringBuilder();
        sb.append("● ");
        for (Pair pair : pairs) {
            sb.append(pair.color).append(pair.content).append(Color.RESET);
        }
        System.out.println(sb);
    }

    /**
     * @Description: 创建Pair对象
     */
    public static Pair p(Object content, Color color) {
        return new Pair(content, color);
    }

    public enum Color {
        RED("\033[31m"),
        GREEN("\033[32m"),
        YELLOW("\033[33m"),
        BLUE("\033[94m"),
        PURPLE("\033[35m"),
        CYAN("\033[36m"),
        WHITE("\033[37m"),
        RESET("\033[0m");
        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    /**
     * @Description: 颜色和内容的键值对
     */
    public static class Pair {
        private final Object content;
        private final Color color;

        public Pair(Object content, Color color) {
            this.content = content;
            this.color = color;
        }
    }
}
