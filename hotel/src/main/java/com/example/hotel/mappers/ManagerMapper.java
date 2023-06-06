package com.example.hotel.mappers;

import com.example.hotel.models.request.ManagerRequest;
import com.example.hotel.models.response.ManagerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerMapper {

    public int count(ManagerRequest request);

    public List<ManagerResponse> get(ManagerRequest request);

    public ManagerResponse checkManager(String request);

    public ManagerResponse create(ManagerRequest request);

    public ManagerResponse update(ManagerRequest request);
}
