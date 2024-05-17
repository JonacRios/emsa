package com.emsa.client.service;

import com.emsa.client.dto.EnergyInfoDTO;
import com.emsa.client.dto.TaskInfo;
import com.emsa.client.model.EnergyRequest;

import java.sql.SQLException;

public interface PersonEnergyService {
    String startProcessInstance(EnergyInfoDTO energyInfoDTO);
    void setAssignee(String taskId, String userId);
    TaskInfo getTaskInfoByProcessId(String processId);
    TaskInfo getTaskInfoByProcessIdWithApi(String processId);
    String updateProcessVariables(String processId, EnergyRequest energyRequest);
    String completeTask(String processId);
    void messageEvent(String processId);
    Long getCountReview(String processId);
    void updateReviewAndStatus(String processId, String status) throws SQLException;

}