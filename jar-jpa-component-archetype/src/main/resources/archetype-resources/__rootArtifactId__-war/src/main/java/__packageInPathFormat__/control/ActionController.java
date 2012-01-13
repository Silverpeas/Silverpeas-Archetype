#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.control;

import javax.servlet.http.HttpServletRequest;

public interface ActionController {
	public String resolveView(HttpServletRequest request);
}
