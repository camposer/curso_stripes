package formatter;

import java.util.Locale;

import model.CorreoElectronico;
import net.sourceforge.stripes.format.Formatter;

public class CorreoElectronicoFormatter implements Formatter<CorreoElectronico> {
	private String tipo;

	@Override
	public void setFormatType(String formatType) {
		this.tipo = formatType;
	}

	@Override
	public void setFormatPattern(String formatPattern) {
	}

	@Override
	public void setLocale(Locale locale) {
	}

	@Override
	public void init() {
	}

	@Override
	public String format(CorreoElectronico input) {
		if (tipo == null)
			return input.getUsuario() + "@" + input.getDominio();
		else
			return input.getUsuario() + " at " + input.getDominio();
	}

}
