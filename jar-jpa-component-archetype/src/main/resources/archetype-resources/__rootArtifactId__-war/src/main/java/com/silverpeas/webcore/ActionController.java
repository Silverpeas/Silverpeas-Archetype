package com.silverpeas.webcore;

import javax.servlet.http.HttpServletRequest;

public interface ActionController {
	public String resolveView(HttpServletRequest request);
}
