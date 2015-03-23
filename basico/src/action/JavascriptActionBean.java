package action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;

public class JavascriptActionBean implements ActionBean {
	private ActionBeanContext ctx;
	
	@DefaultHandler
	public Resolution inicio() {
		return new JavaScriptResolution(new Datos("uno", "123"));
	}
	
	@Override
	public void setContext(ActionBeanContext context) {
		this.ctx = context;
	}

	@Override
	public ActionBeanContext getContext() {
		return ctx;
	}
	
	public class Datos {
		private String nombre;
		private String serial;
		
		public Datos(String nombre, String serial) {
			this.nombre = nombre;
			this.serial = serial;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getSerial() {
			return serial;
		}

		public void setSerial(String serial) {
			this.serial = serial;
		}
	}

}
