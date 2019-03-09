package com.hisen.controller;

import com.alibaba.fastjson.JSON;
import com.hisen.entity.Appointment;
import com.hisen.entity.form.AppointmentForm;
import com.hisen.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/appoint/{bookId}/{userNumber}/{holdDay}", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String appoint(@PathVariable("bookId") int bookId, @PathVariable("userNumber") int userNumber, @PathVariable("holdDay") String holdDay){
        AppointmentForm form = new AppointmentForm();
        form.setBookId(bookId);
        form.setUserNumber(userNumber);
        form.setHoldDay(holdDay);
        logger.info("借书入参：" + form.toString());
        int appoint = appointmentService.appoint(form);
        String s = JSON.toJSONString(appoint > 0 ? "借书成功" : "借书失败");
        return s;
    }

    @RequestMapping(value = "/return/{bookId}/{userNumber}", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnBook(@PathVariable("bookId") int bookId, @PathVariable("userNumber") int userNumber){
        Appointment form = new Appointment();
        form.setBookId(bookId);
        form.setUserNumber(userNumber);
        logger.info("还书入参" + form.toString());
        int i = appointmentService.returnBook(form);
        String s = JSON.toJSONString(i > 0 ? "还书成功" : "还书失败");
        return s;
    }
}
