package com.revature.data;

import java.util.List;

import com.revature.beans.ServiceRequest;

public interface ServicesDOA {
	public boolean addService(ServiceRequest req);

	public List<ServiceRequest> getMyRequest(Integer userId);
}
