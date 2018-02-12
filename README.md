# wso2-apim-custom-apistatechange-workflow-executor


In the /_system/governance/apimgt/applicationdata/workflow-extensions.xml registry path, add following to engate this workflow executor. 
Comment out the other APIStateChange workfow executors.

    <APIStateChange executor="com.workflow.custom.MyWorkflowExecutor">
        <Property name="processDefinitionKey">APIStateChangeApprovalProcess</Property>
        <Property name="stateList">Created:Publish,Published:Block</Property> 
        <Property name="setDefaultEmail">abc@vonage.com</Property>       
    </APIStateChange>


[1] https://docs.wso2.com/display/AM210/Customizing+a+Workflow+Extension
