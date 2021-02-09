package cn.hncj.assistant.interceptor;


import cn.hncj.assistant.util.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("token认证");
        try {
            // 获取Headers中的token
            String token = request.getHeader("token");
            DecodedJWT decodedJWT = JWTUtil.verifyToken(token);

            String id = decodedJWT.getClaim("id").asString();
            String type = decodedJWT.getClaim("type").asString();
            System.out.println("请求id：" + id);
            System.out.println("用户类型：" + type);
            System.out.println("认证通过");
            // 验证成功，放行
            return true;
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("status", 401);
            map.put("msg", "权限认证失败");

            // 验证失败，提示信息
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print(json);
            System.out.println("认证失败");
            return false;
        }
    }
}
