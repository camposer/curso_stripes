package action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class InicioActionBean implements ActionBean {
	private final String VIEW = "/WEB-INF/jsp/inicio.jsp";
	private ActionBeanContext ctx;

	@DefaultHandler
	public Resolution inicio() {
		return new ForwardResolution(VIEW);
	}
	
	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.ctx = ctx;
	}

}
