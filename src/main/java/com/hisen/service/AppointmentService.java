package com.hisen.service;

import com.hisen.entity.form.AppointmentForm;
import com.hisen.entity.Appointment;

public interface AppointmentService {
    int appoint(AppointmentForm record);

    int returnBook(Appointment record);
}
