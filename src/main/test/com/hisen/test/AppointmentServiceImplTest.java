package com.hisen.test;

import com.hisen.entity.form.AppointmentForm;
import com.hisen.service.AppointmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentServiceImplTest extends BaseTest {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 测试预约功能
     */
    @Test
    public void insertApponit() {
        AppointmentForm form = new AppointmentForm();
        form.setHoldDay("10");
        form.setBookId(103);
        form.setUserNumber(20080808);
        form.setStatus(1);
        int appoint = appointmentService.appoint(form);
        System.out.println(appoint);
    }
}
