package io.oken1.common.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.util.UriComponentsBuilder;

public class LoginUtils {
    //	配置自己的app_id、app_secret
    private static final String APP_ID = "";
    private static final String APP_SECRET = "";

    public static String getOpenId(String loginCode) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String requestUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("appid", APP_ID)
                .queryParam("secret", APP_SECRET)
                .queryParam("js_code", loginCode)
                .queryParam("grant_type", "authorization_code")
                .toUriString();

        HttpResponse response = HttpUtil.createGet(requestUrl).execute();

        // 获取 session_key 和 openid
        JSONObject parseObj = JSONUtil.parseObj(response.body());

        String openid = (String) parseObj.get("openid");
        return openid;
    }
}