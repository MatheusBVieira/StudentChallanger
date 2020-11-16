package br.com.compasso.studentChallanger.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class IdadeUtil {
	public static int calculaIdade(Date dataNascimento) {
		GregorianCalendar agora = new GregorianCalendar();
		int ano = 0, mes = 0, dia = 0;

		GregorianCalendar nascimento = new GregorianCalendar();
		int anoNasc = 0, mesNasc = 0, diaNasc = 0;

		int idade = 0;

		if (dataNascimento != null) {
			nascimento.setTime(dataNascimento);

			ano = agora.get(Calendar.YEAR);
			mes = agora.get(Calendar.MONTH) + 1;
			dia = agora.get(Calendar.DAY_OF_MONTH);

			anoNasc = nascimento.get(Calendar.YEAR);
			mesNasc = nascimento.get(Calendar.MONTH) + 1;
			diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);

			idade = ano - anoNasc;

			if (mes < mesNasc) {
				idade--;
			} else {
				if (dia < diaNasc) {
					idade--;
				}
			}

			if (idade < 0) {
				idade = 0;
			}

		}

		return (idade);
	}
}
