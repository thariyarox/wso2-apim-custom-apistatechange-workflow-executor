package com.workflow.custom.internal;


import com.workflow.custom.MyWorkflowExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.apimgt.impl.workflow.WorkflowExecutor;
import org.wso2.carbon.user.core.service.RealmService;


//@scr.component name="com.workflow.custom.internal.ServiceComponent" immediate="true"

public class ServiceComponent {

    private static final Log log = LogFactory.getLog(ServiceComponent.class);


    protected void activate(ComponentContext ctxt) {

        //ctxt.getBundleContext().registerService(WorkflowExecutor.class.getName(), new MyWorkflowExecutor(), null);

            log.info("MyWorkflowExecutor bundle is activated");

    }

    protected void deactivate(ComponentContext ctxt) {
        if (log.isDebugEnabled()) {
            log.info("MyWorkflowExecutor bundle is deactivated");
        }
    }

    protected void setRealmService(RealmService realmService) {
        log.debug("Setting the Realm Service");
    }

    protected void unsetRealmService(RealmService realmService) {
        log.debug("UnSetting the Realm Service");
    }

    public static RealmService getRealmService() {
        return null;

    }

}
