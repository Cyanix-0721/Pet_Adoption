package com.pet_adoption.util;

import javax.servlet.http.HttpServletRequest;

public class verifyCodeUtil {

    /**
     * 将获取到的前端参数转为string类型
     *
     * @param request
     * @param key 用户输入验证码
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证码校验
     *
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
        String verifyCodeActual = verifyCodeUtil.getString(request, "verifyCodeActual");
        return verifyCodeActual != null && verifyCodeActual.equals(verifyCodeExpected);
    }
}