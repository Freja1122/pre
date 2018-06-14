package com.huhu.webserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huhu.webserver.domain.Base64;
import com.huhu.webserver.domain.Password;
import com.huhu.webserver.repository.Base64Repository;
import com.huhu.webserver.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @program: webserver
 * @description:
 * @author: Annntn
 * @create: 2018-06-10 17:41
 **/
@RestController
@CrossOrigin
public class BaseController {
    @Autowired
    Base64Repository base64Repository;
    @Autowired
    PasswordRepository passwordRepository;
    int passwordLen=12;
    @PostMapping("/image")
    public JSONObject uploadImage(@RequestBody JSONObject request){
        JSONObject res = new JSONObject();
        //get parameters
        Base64 base64 = JSON.parseObject(request.toJSONString(), Base64.class);
        Password password = passwordRepository.findByFromName(base64.getFromName());
        System.out.println(password);
        if (password==null){
            password=new Password();
            password.setFromName(base64.getFromName());
        }
        password.setAllNumber(password.getAllNumber()+1);
        if (!base64.getToName().equals("")){
            password.setToName(base64.getToName());
        }
        passwordRepository.save(password);
        //store information
        try{
            base64Repository.saveAndFlush(base64);
            res.put("result","ok");
            res.put("data",JSON.toJSON(base64));
        }catch (Exception e){
            res.put("result","error");
            res.put("data","null");
        }
        return res;
    }
    @PostMapping("/allPictures")
    public JSONObject getPictures(@RequestBody JSONObject request){
        //如果已经存在密码，就返回对象；
        //如果不存在就返回error
        JSONObject res = new JSONObject();
        String fromName = request.getString("fromName");
        Password password = passwordRepository.findByFromName(fromName);
        if (password==null){
            res.put("result","error");
            res.put("data","null");
            return res;
        }
        //获取所有相片
        List<Base64> allPictures = base64Repository.findAllByFromName(fromName);
        res.put("result","ok");
        res.put("data",JSON.toJSON(password));
        res.put("pictures",JSON.toJSON(allPictures));
        return res;
    }

    @GetMapping("/password")
    public JSONObject getPassword(){
        JSONObject res = new JSONObject();
        res.put("password",createPassWord(passwordLen));
        return res;
    }

    @PostMapping("/allNumber")
    public JSONObject getNumber(@RequestBody JSONObject request){
        //如果已经存在密码，就返回对象；
        //如果不存在就返回error
        JSONObject res = new JSONObject();
        String fromName = request.getString("fromName");
        Password password = passwordRepository.findByFromName(fromName);
        if (password==null){
            res.put("result","error");
            res.put("data","null");
            return res;
        }
        res.put("result","ok");
        res.put("data",JSON.toJSON(password));
        return res;
    }

    @PostMapping("/okNumber")
    public JSONObject okNumber(@RequestBody JSONObject request){
        //如果已经存在密码，就返回对象；
        //如果不存在就返回error
        JSONObject res = new JSONObject();
        String fromName = request.getString("fromName");
        Password password = passwordRepository.findByFromName(fromName);
        if (password==null){
            res.put("result","error");
            res.put("data","null");
            return res;
        }
        int okNumber = request.getInteger("okNumber");
        if (okNumber!=0){
            password.setOkNumber(Math.max(okNumber,password.getAllNumber()));
            passwordRepository.save(password);
        }
        res.put("result","ok");
        res.put("data",JSON.toJSON(password));
        return res;
    }


    public String createPassWord(int len){
        int random = this.createRandomInt();
        return this.createPassWord(random, len);
    }

    public String createPassWord(int random,int len){
        Random rd = new Random(random);
        final int  maxNum = 62;
        StringBuffer sb = new StringBuffer();
        int rdGet;//取得随机数
        char[] str = { 'A','B','C','D','E','F','G','H','I','J','K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y' ,'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        int count=0;
        while(count < len){
            rdGet = Math.abs(rd.nextInt(maxNum));//生成的数最大为62-1
            if (rdGet >= 0 && rdGet < str.length) {
                sb.append(str[rdGet]);
                count ++;
            }
        }
        return sb.toString();
    }

    public int createRandomInt(){
        //得到0.0到1.0之间的数字，并扩大100000倍
        double temp = Math.random()*100000;
        //如果数据等于100000，则减少1
        if(temp>=100000){
            temp = 99999;
        }
        int tempint = (int)Math.ceil(temp);
        return tempint;
    }
}
