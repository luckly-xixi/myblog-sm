package com.example.demo.common;

import com.example.demo.model.Userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session 工具类
 */
public class SessionUtils {

    /**
     * 获取当前登录用户信息cxsdzvcx
     * @param request
     * @return
     */
    public static Userinfo getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null
                && session.getAttribute(AppVariable.SESSION_USERINFO_KEY) != null) {
            return (Userinfo) session.getAttribute(AppVariable.SESSION_USERINFO_KEY);
        }

        return null;
    }
}
