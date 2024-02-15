package net.heishanrm;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import net.heishanrm.M3u8.DownloadFactory;
import net.heishanrm.M3u8.DownloadListener;
import net.heishanrm.M3u8.utils.Constant;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getUrl(int year, int month, int day) {
        String responseBody = Poster.post(Utils.timeStampGenerator(year, month, day));
        String dateStr = year + "/" + month + "/" + day;
        JSONObject parse = JSON.parseObject(responseBody);
        if (parse.containsKey("code") && parse.getIntValue("code") == 200) {
            JSONArray data = parse.getJSONArray("data");
            for (Object o : data) {
                JSONObject object = (JSONObject) o;
                if (object.getString("title").equals(dateStr)) {
                    return object.getString("url");
                }
            }
        }
        Log.w("获取失败，程序退出");
        return null;
    }

    public static String timeStampGenerator(int year, int month, int day) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            String dateStr = String.format("%04d-%02d-%02d %02d:%02d:%02d:%03d", year, month, ++day, 0, 0, 0, 0);
            Date date = sdf.parse(dateStr);
            return Long.toString(date.getTime());
        } catch (ParseException e) {
            Log.w("时间输入错误，程序退出");
            return null;
        }
    }

    public static void videoDownloader(int year, int month, int day,String url) {
        if (url == null) System.exit(1);
        DownloadFactory.M3u8Download m3u8Download = DownloadFactory.getInstance(url);
        //设置生成目录
        m3u8Download.setDir(System.getProperty("user.dir") + File.separator + "download");
        //设置视频名称
        m3u8Download.setFileName(year + "-" + month + "-" + day);
        //设置线程数
        m3u8Download.setThreadCount(100);
        //设置重试次数
        m3u8Download.setRetryCount(100);
        //设置连接超时时间（单位：毫秒）
        m3u8Download.setTimeoutMillisecond(10000L);
        /*
        设置日志级别
        可选值：NONE INFO DEBUG ERROR
        */
        m3u8Download.setLogLevel(Constant.NONE);
        //设置监听器间隔（单位：毫秒）
        m3u8Download.setInterval(500L);
        //添加额外请求头
        /*Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "text/html;charset=utf-8");
        m3u8Download.addRequestHeaderMap(headersMap);*/
        //如果需要的话设置http代理
        //m3u8Download.setProxy("172.50.60.3",8090);
        //添加监听器
        m3u8Download.addListener(new DownloadListener() {
            @Override
            public void start() {
                Log.s("解析成功，开始下载");
            }

            @Override
            public void process(String downloadUrl, int finished, int sum, float percent) {
                Log.c(
                        Log.p("已下载:"+finished, Log.Color.GREEN),Log.Separator,
                        Log.p("一共:"+sum, Log.Color.YELLOW),Log.Separator,
                        Log.p("已完成:"+percent+"%", Log.Color.BLUE)
                );
            }

            @Override
            public void speed(String speedPerSecond) {
                Log.d("下载速度:" + speedPerSecond);
            }

            @Override
            public void end() {
                Log.s("下载完毕，文件位于:"+System.getProperty("user.dir") + File.separator + "download"+File.separator+year + "-" + month + "-" + day+".mp4");
            }
        });
        //开始下载
        m3u8Download.start();
    }
}
