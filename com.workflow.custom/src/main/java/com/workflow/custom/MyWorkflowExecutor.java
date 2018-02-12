package com.workflow.custom;

import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.api.WorkflowResponse;
import org.wso2.carbon.apimgt.impl.APIConstants;
import org.wso2.carbon.apimgt.impl.dao.ApiMgtDAO;
import org.wso2.carbon.apimgt.impl.dto.SubscriptionWorkflowDTO;
import org.wso2.carbon.apimgt.impl.dto.WorkflowDTO;
import org.wso2.carbon.apimgt.impl.workflow.*;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.service.RealmService;

public class MyWorkflowExecutor extends APIStateChangeWSWorkflowExecutor{

    private static final Log log = LogFactory.getLog(MyWorkflowExecutor.class);

    public String getDefaultEmail() {
        return defaultEmail;
    }

    public void setDefaultEmail(String defaultEmail) {
        this.defaultEmail = defaultEmail;
    }

    private String defaultEmail;


    private RealmService getRealmService(){

        RealmService rs = null;

        rs = IdentityTenantUtil.getRealmService();

        return rs;
    }



    public MyWorkflowExecutor() {
        super();
    }

    @Override
    public String getStateList() {
        return super.getStateList();
    }

    @Override
    public void setStateList(String stateList) {
        super.setStateList(stateList);
    }

    @Override
    public String getClientId() {
        return super.getClientId();
    }

    @Override
    public void setClientId(String clientId) {
        super.setClientId(clientId);
    }

    @Override
    public String getClientSecret() {
        return super.getClientSecret();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getProcessDefinitionKey() {
        return super.getProcessDefinitionKey();
    }

    @Override
    public void setProcessDefinitionKey(String processDefinitionKey) {
        super.setProcessDefinitionKey(processDefinitionKey);
    }

    @Override
    public void setClientSecret(String clientSecret) {
        super.setClientSecret(clientSecret);
    }

    @Override
    public String getTokenAPI() {
        return super.getTokenAPI();
    }

    @Override
    public void setTokenAPI(String tokenAPI) {
        super.setTokenAPI(tokenAPI);
    }

    @Override
    public String getServiceEndpoint() {
        return super.getServiceEndpoint();
    }

    @Override
    public void setServiceEndpoint(String serviceEndpoint) {
        super.setServiceEndpoint(serviceEndpoint);
    }

    @Override
    public String getWorkflowType() {
        return super.getWorkflowType();
    }

    @Override
    public List<WorkflowDTO> getWorkflowDetails(String workflowStatus) throws WorkflowException {
        return super.getWorkflowDetails(workflowStatus);
    }

    @Override
    public WorkflowResponse execute(WorkflowDTO workflowDTO) throws WorkflowException {

        log.info("EMAIL = " + defaultEmail);

        RealmService rs = getRealmService();

        try {
            UserStoreManager us = (UserStoreManager) rs.getTenantUserRealm(workflowDTO.getTenantId()).getUserStoreManager();
            APIStateWorkflowDTO apiStateWorkflowDTO = (APIStateWorkflowDTO) workflowDTO;
            String username = apiStateWorkflowDTO.getInvoker();
            String emailAddress = us.getUserClaimValue(username, "http://wso2.org/claims/emailaddress", "default");

            log.info("email address = " + emailAddress);

        } catch (UserStoreException e) {
            e.printStackTrace();
        }

        return super.execute(workflowDTO);
    }

    @Override
    public WorkflowResponse complete(WorkflowDTO workflowDTO) throws WorkflowException {
        log.info("complete");
        return super.complete(workflowDTO);
    }

    @Override
    public void cleanUpPendingTask(String workflowExtRef) throws WorkflowException {
        super.cleanUpPendingTask(workflowExtRef);
    }

    @Override
    public void persistWorkflow(WorkflowDTO workflowDTO) throws WorkflowException {

        super.persistWorkflow(workflowDTO);
    }



}
