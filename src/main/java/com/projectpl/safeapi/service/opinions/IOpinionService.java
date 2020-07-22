package com.projectpl.safeapi.service.opinions;

import com.projectpl.safeapi.entity.Location;

public interface IOpinionService {
    Location findById(int id);
}
