package converter;

import java.util.Collection;
import java.util.Locale;
import java.util.StringTokenizer;

import model.CorreoElectronico;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;

public class CorreoElectronicoTypeConverter implements
		TypeConverter<CorreoElectronico> {

	@Override
	public void setLocale(Locale locale) {
	}

	@Override
	public CorreoElectronico convert(String input,
			Class<? extends CorreoElectronico> targetType,
			Collection<ValidationError> errors) {
		
		StringTokenizer st = new StringTokenizer(input, "@");
		CorreoElectronico correoElectronico = new CorreoElectronico();
		
		correoElectronico.setUsuario((st.hasMoreElements())? st.nextToken() : null);
		correoElectronico.setDominio((st.hasMoreElements())? st.nextToken() : null);
		
		return correoElectronico;
	}

}
