package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.OpeningHours;

import java.util.List;

public interface DoctorService {
    Doctor createDoctor(DoctorPostReq doctorInfo);
    Doctor setOpeningHours(String userId, List<OpeningHours> hours);

}
