import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args){
        HttpURLConnection conn = null;
        BufferedReader in = null;
        String userPassword = "user:password";
        String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
        while (true){
            try {
                String url = "http://101.132.97.130:8081/gateway/sendall/7.860/88.00/7.87/59.5/8.0";
                URL realUrl = new URL(url);
                URLConnection urlConnection = realUrl.openConnection();
                urlConnection.setRequestProperty("Authorization","Basic"+encoding);
                in = new BufferedReader(new InputStreamReader(realUrl.openStream(), "UTF-8"));

//                //设置post方法
//                conn.setRequestMethod("POST");
//                //不使用缓存
//                conn.setUseCaches(false);
//                // 发送POST请求必须设置如下两行
//                conn.setDoOutput(true);
//                conn.setDoInput(true);
//                //读取超时时间
//                conn.setReadTimeout(8000);
//                //连接超时时间
//                conn.setConnectTimeout(8000);
//                //这一句很重要，设置不要302自动跳转，后面会讲解到
//                conn.setInstanceFollowRedirects(false);

                Thread.sleep(1000);
                System.out.println("sleep");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
