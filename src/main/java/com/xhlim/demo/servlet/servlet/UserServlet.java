package com.xhlim.demo.servlet.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xhlim.demo.servlet.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 用户
 *
 * @author xhlim@outlook.com
 * @version 1.0
 * @date 2018-11-28
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型 json
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        // 构造数据
        List<UserEntity> users = new ArrayList<UserEntity>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            UserEntity user = new UserEntity();
            user.setId((long) i);
            user.setName("张".concat(String.valueOf(getRandomCn())));
            user.setPassword(UUID.randomUUID().toString().replace("-", ""));
            // 随机 0~2 的随机数
            user.setSex((byte) (random.nextInt(3)));
            // 随机 20~49 的数
            user.setAge(random.nextInt(30) + 20);
            if (random.nextInt(3) == 0) {
                user.setAge(0);
            }
            users.add(user);
        }
        // 输出数据 任意格式
        out.println(beanToJson(users));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }


    /**
     * 随机中文汉字
     *
     * @return
     */
    private char getRandomCn() {
        Random ran = new Random();
        int delta = 0x9fa5 - 0x4e00 + 1;
        return (char) (0x4e00 + ran.nextInt(delta));
    }

    /**
     * java 对象转 json
     *
     * @param obj
     * @return
     */
    private String beanToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
