package net.heishanrm;

public class Main {
    public static void main(String[] args) {
        Log.s("黑山融媒新闻下载工具，请正确输入要获取视频的年月日");
        Log.v("输入年");
        int year = CustomScanner.Int(false);
        Log.v("输入月");
        int month = CustomScanner.Int(false);
        Log.v("输入日");
        int day = CustomScanner.Int(false);
        Utils.videoDownloader(year,month,day,Utils.getUrl(year,month,day));
    }
}