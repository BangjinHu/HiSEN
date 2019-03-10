package com.hisen.service;

import com.hisen.entity.Appointment;
import com.hisen.entity.form.AppointmentForm;

public interface AppointmentService {
    int appoint(AppointmentForm record);

    int returnBook(Appointment record);
}
