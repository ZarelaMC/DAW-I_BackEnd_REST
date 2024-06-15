package com.centroinformacion.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class FunctionUtil {

	private static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

	public static String toSuprimeDigitosDerecha(String num) {
		return num.substring(0, num.indexOf(".")).concat("%");
	}

	public static String toMinusculaYPrimerCaracterMayuscula(String valor) {
		if (valor == null || valor.isEmpty()) {
			return valor;
		} else {
			return valor.trim().toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase();
		}
	}

	public static String toMinusculaYPrimerCaracterMayusculaDeCadaPalabra(String cadena) {
		char[] caracteres = cadena.trim().toLowerCase().toCharArray();
		caracteres[0] = Character.toUpperCase(caracteres[0]);
		for (int i = 0; i < cadena.length() - 2; i++) {
			if (caracteres[i] == ' ') {
				caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
			}
		}
		return new String(caracteres);
	}

	public static int notas(String num, int numAlternativas) {
		return 20 - Integer.parseInt(num) * (20 / numAlternativas);
	}

	public static String toDosDigitos(double num) {
		simbolos.setDecimalSeparator('.');
		DecimalFormat nf1 = new DecimalFormat("##.##", simbolos);
		return nf1.format(num);
	}

	public static String toUnDigito(double num) {
		simbolos.setDecimalSeparator('.');
		DecimalFormat nf1 = new DecimalFormat("##.#", simbolos);
		return nf1.format(num);
	}

	public static String toSinDigito(double num) {
		simbolos.setDecimalSeparator('.');
		DecimalFormat nf1 = new DecimalFormat("##", simbolos);
		return nf1.format(num);
	}

	public static String eliminaEspacios(String cad) {
		StringBuilder sb = new StringBuilder(cad);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.codePointAt(i) == 160) {
				sb.setCharAt(i, ' ');
			}
		}
		return sb.toString().trim().replaceAll("\\s+", " ");
	}

	public static String eliminaCerosIzquierda(String cad) {
		boolean todosCeros = true;
		for (int i = 0; i < cad.length(); i++) {
			if (cad.charAt(i) != '0') {
				todosCeros = false;
			}
		}
		if (todosCeros) {
			return "0";
		} else {
			if (cad.charAt(0) == '0') {
				int posUltimoCero = cad.lastIndexOf('0');
				cad = cad.substring(posUltimoCero + 1);
			} else {
				return cad;
			}
		}
		return cad;
	}

	public static Date getTimeDefault() {
		Date salida = null;
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			salida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static Date getDateDefault() {
		Date salida = null;
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 1900);
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH, 1);
			salida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static Date getDateDefaultInicio() {
		Date salida = null;
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 1900);
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH, 1);
			salida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static Date getDateDefaultFin() {
		Date salida = null;
		try {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 1900);
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH, 2);
			salida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static Date getFechaTime(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date salida = null;
		try {
			salida = sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static Date getFechaTimeExcel(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.parse(str);
	}

	public static Date getFechaDateExcel(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		return sdf.parse(str);
	}

	public static Date getFechaDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date salida = null;
		try {
			salida = sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}

	public static String getFechaStringDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getFechaStringSlash(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	public static String getFechaString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String getTimeHHmmString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(date);
	}

	public static String getTimeHHmmaaString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		return sdf.format(date);
	}

	public static Date getJoinDateAndTime(Date date, Date time) {
		Date dateSalida = null;
		try {
			Calendar ctime = Calendar.getInstance();
			ctime.setTime(time);

			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.set(Calendar.HOUR_OF_DAY, ctime.get(Calendar.HOUR_OF_DAY));
			c.set(Calendar.MINUTE, ctime.get(Calendar.MINUTE));
			c.set(Calendar.SECOND, ctime.get(Calendar.SECOND));
			dateSalida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static Date getDateAddDias(Date sup, int dias) {
		long timeFinal = 0;
		Date date = null;
		try {
			timeFinal = (sup.getTime() / (24 * 60 * 60 * 1000) + dias) * (24 * 60 * 60 * 1000);
			date = new Date(timeFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDateAddMinutes(Date sup, int minutos) {
		long timeFinal = 0;
		Date date = null;
		try {
			timeFinal = (sup.getTime() / (60 * 1000) + minutos) * (60 * 1000);
			date = new Date(timeFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDateDifMinutes(Date sup, int minutos) {
		long timeFinal = 0;
		Date date = null;
		try {
			timeFinal = (sup.getTime() / (60 * 1000) - minutos) * (60 * 1000);
			date = new Date(timeFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int getMinutesDifDate(Date sup, Date inf) {
		int diffMinutes = 0;
		long diff = 0;
		try {
			diff = sup.getTime() - inf.getTime();
			diffMinutes = (int) (diff / (60 * 1000));
			if (diffMinutes < 0) {
				diffMinutes = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffMinutes;
	}

	public static Date getDateAndTimeInicial() {
		Date dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("1900-01-01 00:00:00");
			dateSalida = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static Date getDateAndTimeNow() {
		Date dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateSalida = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static Date getTimeNow() {
		Date dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			dateSalida = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static String getDateNowInString() {
		String dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy__HH_mm_ss");
			dateSalida = sdf.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static String getDateNowInStringSlash() {
		String dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateSalida = sdf.format(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static Date getDateNow() {
		Date dateSalida = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateSalida = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateSalida;
	}

	public static Date getMonday() {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date aux = sdf.parse(sdf.format(new Date()));
			c.setTime(aux);
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	public static Date getSunday() {
		Calendar c = Calendar.getInstance();
		try {
			Date fecActual = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date aux = sdf.parse(sdf.format(fecActual));
			c.setTime(aux);
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			Date fecGenerada = c.getTime();

			if (fecGenerada.before(fecActual)) {
				c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 7);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	public static Date getDayPorDia(int dia) {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date aux = sdf.parse(sdf.format(new Date()));
			c.setTime(aux);
			c.set(Calendar.DAY_OF_WEEK, dia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	public static String getStringDia(int pos) {
		switch (pos) {
		case 1:
			return "Domingo";
		case 2:
			return "Lunes";
		case 3:
			return "Martes";
		case 4:
			return "Miércoles";
		case 5:
			return "Jueves";
		case 6:
			return "Viernes";
		default:
			return "Sábado";
		}
	}

	public static byte getByteDia(String day) {
		switch (day.toString().toLowerCase()) {
		case "domingo":
			return 1;
		case "lunes":
			return 2;
		case "martes":
			return 3;
		case "miércoles":
			return 4;
		case "miercoles":
			return 4;
		case "jueves":
			return 5;
		case "viernes":
			return 6;
		case "sábado":
			return 7;
		case "sabado":
			return 7;
		default:
			return -1;
		}
	}

	public static String borrarEspaciosBlanco(String mensaje) {
		return mensaje.replaceAll("\\s+", "");
	}

	public static String setFormatoEliminaMasDosSpaciosBlanco(String str) {
		str = str.trim().replaceAll("\\s{2,}", " ");
		return str;
	}

	public static String setFormatoTextoEnBaseDatos(String str) {
		str = str.trim().replaceAll("\\s{2,}", " ");
		String[] cadena = str.toLowerCase().split(" ");
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i].length() > 2) {
				cadena[i] = String.valueOf(cadena[i].charAt(0)).toUpperCase() + cadena[i].substring(1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cadena.length; i++) {
			sb.append(cadena[i]);
			if (i != cadena.length - 1)
				sb.append(' ');
		}
		return sb.toString();
	}

	public static String setFormatPrimeraLetraMayuscula(String str) {
		return str.toUpperCase().charAt(0) + str.substring(1, str.length()).toLowerCase();
	}

	public static String toEstado(byte estado) {
		if (estado == 0)
			return "Inactivo";
		else
			return "Activo";
	}

	public static String toSinTildes(String cadena) {
		String aux = cadena.trim();
		StringBuilder sb = new StringBuilder();
		char[] especiales = { 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú' };
		char[] normales = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		externo: for (int i = 0; i < aux.length(); i++) {
			for (int j = 0; j < normales.length; j++) {
				if (aux.charAt(i) == especiales[j]) {
					sb.append(normales[j]);
					continue externo;
				}
			}
			sb.append(aux.charAt(i));
		}
		return sb.toString();
	}

	public static String toSinTildesSinEspacios(String cadena) {
		String aux = cadena.trim();
		StringBuilder sb = new StringBuilder();
		char[] especiales = { 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú' };
		char[] normales = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		externo: for (int i = 0; i < aux.length(); i++) {
			if (aux.charAt(i) != ' ') {
				for (int j = 0; j < normales.length; j++) {
					if (aux.charAt(i) == especiales[j]) {
						sb.append(normales[j]);
						continue externo;
					}
				}
				sb.append(aux.charAt(i));
			}
		}
		return sb.toString();
	}

	public static String alphaNumericString(int len) {
		String AB = "0123456789abcdefghijklmnopqrstuvwxzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public static String getLogin(String correo) {
		return correo.substring(0, correo.indexOf("@"));
	}
	
	public static Date getFechaInicio(int semana, Date fechaInicio) {
		Date salida = null;
		try {
			if (semana == 1) {
				return fechaInicio;
			}else {
				Calendar c = Calendar.getInstance();
				c.setTime(fechaInicio);
				c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 7 * (semana - 1));
				salida = c.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
	
	public static Date getFechaFin(int semana, Date fechaInicio) {
		Date salida = null;
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(fechaInicio);
			c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 7 * (semana - 1) + 6);
			salida = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salida;
	}
	
	public static void main(String[] args) {
		String fec = "22-08-2022";
		Date fecX = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			
			fecX = sdf.parse(fec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 15; i++) {
			System.out.println("Semana " +  i + " >> " + sdf.format(getFechaInicio(i,fecX)) + " >> " + sdf.format(getFechaFin(i,fecX)));
		}	
	}
}
