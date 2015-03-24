package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NumerosDaoImpl implements NumerosDao {

	@SuppressWarnings("serial")
	@Override
	public List<String> obtenerNumeros() {
		return new ArrayList<String>() {{
			add("uno");
			add("dos");
			add("tres");
		}};
	}

}
