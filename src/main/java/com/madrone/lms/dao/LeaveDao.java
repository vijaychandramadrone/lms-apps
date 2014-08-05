package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Leave;

public interface LeaveDao extends AbstractDao<Leave, String> {


public List<Leave> getLeaveTypes();

}
