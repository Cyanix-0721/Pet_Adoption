package com.pet_adoption.util;

import com.pet_adoption.entity.Admin;
import com.pet_adoption.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void createSession(HttpServletRequest request, HttpServletResponse response) {
        // 创建一个新的会话
        HttpSession session = request.getSession(true);
        if (session == null) {
            throw new IllegalStateException("无法创建会话");
        }
    }

    public static void createAdminSession(HttpServletRequest request, HttpServletResponse response, Admin admin) {
        createSession(request, response);
        // 在会话中存储管理员信息
        request.getSession().setAttribute("admin", admin);
    }

    public static void createUserSession(HttpServletRequest request, HttpServletResponse response, User user) {
        createSession(request, response);
        // 在会话中存储用户信息
        request.getSession().setAttribute("user", user);
    }

    public static void createPersistentCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        // 创建一个持久性Cookie
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24); // 设置Cookie的有效期为1天
        cookie.setPath("/"); // 设置Cookie的作用路径为根路径
        cookie.setSecure(true); // 设置是否通过安全连接传输Cookie
        response.addCookie(cookie);
    }

    public static void createPersistentAdminCookie(HttpServletRequest request, HttpServletResponse response, String adminName) {
        createPersistentCookie(request, response, "admin", adminName);
    }

    public static void clearSession(HttpServletRequest request) {
        // 从会话中移除所有属性
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public static void clearAdminSession(HttpServletRequest request, HttpServletResponse response) {
        clearSession(request);
        // 移除管理员对象
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        request.getSession().removeAttribute("admin");
        // 移除Cookie
        Cookie cookie = new Cookie("admin", "");
        cookie.setMaxAge(0); // 设置有效期为0秒，立即删除Cookie
        cookie.setPath("/admin"); // 设置Cookie的作用路径
        response.addCookie(cookie);
    }

    public static void clearUserSession(HttpServletRequest request, HttpServletResponse response) {
        clearSession(request);
        // 移除用户对象
        User user = (User) request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        // 移除Cookie
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // 设置有效期为0秒，立即删除Cookie
        cookie.setPath("/user"); // 设置Cookie的作用路径
        response.addCookie(cookie);
    }
}
