package com.cobble.huasheng.action;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.log4j.Logger;

import com.cobble.huasheng.dto.UserDTOSearch;



public class LoginAction extends BaseAction {
	private final static Logger logger = Logger.getLogger(LoginAction.class);
	private UserDTOSearch userDTOSearch = new UserDTOSearch();

	public String login() throws Exception {
		logger.debug("进入login");
		ScriptEngineManager mgr = new ScriptEngineManager();  
		ScriptEngine engine = mgr.getEngineByExtension("js");
		engine.eval("function test(){return 'test js in java.';}");   
		Invocable inv = (Invocable) engine;   
		inv.invokeFunction("test");
		logger.debug("js value=");
		logger.debug(request.getHeader("X-Requested-With"));
		if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			response.getWriter().print("{\"status\":false}");
			return null;
		}
		   
		//response.sendRedirect(request.getContextPath() + "/manage/login.jsp");
		return this.LOGIN;
	}
	public String execute() {
		logger.debug("进入login execute");
		return this.SUCCESS;
	}
	public UserDTOSearch getUserDTOSearch() {
		return userDTOSearch;
	}
	public void setUserDTOSearch(UserDTOSearch userDtoSearch) {
		this.userDTOSearch = userDtoSearch;
	}

}
