package com.swashtech.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.json.JSONObject;

import com.google.gson.JsonObject;

public class ProductDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(execution.getProcessInstance().getVariables());
		Object productlist = execution.getVariable("productlist");
		if(productlist != null) {
			JSONObject json =  new JSONObject(productlist.toString());
			if(json.optInt("status") != 0) {
				throw new BpmnError("error_404");
			}
		}
	}

}
