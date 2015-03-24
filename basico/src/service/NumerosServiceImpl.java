package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NumerosDao;

@Service // Spring creará una instancia con id = numerosServiceImpl
public class NumerosServiceImpl implements NumerosService {
	@Autowired
	private NumerosDao numerosDao;

	@Override
	public List<String> obtenerNumeros() {
		return numerosDao.obtenerNumeros();
	}

}
