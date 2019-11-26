package br.com.crowfunding.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public static Date stringParaDate(String data) {

		Date dataInicioCurso = null;
		try {
			dataInicioCurso = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataInicioCurso;

	}

	public static Date obterDataHoje() {

		Date dataDeHoje = new Date();
		String dataAtual = dataDeHoje.getDay()+"/"+dataDeHoje.getMonth()+"/"+dataDeHoje.getYear();
	
		return stringParaDate(dataAtual);

	}
	
	
	

}
