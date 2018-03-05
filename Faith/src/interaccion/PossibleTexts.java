package interaccion;

public class PossibleTexts {

	public String getTextoLibre(String texto) {
		if ((texto.contains("cual") && texto.contains("tu") && texto.contains("nombre"))
				|| (texto.contains("como") && texto.contains("te") && texto.contains("llamas"))) {
			return "nombre";
		}
		if ((texto.contains("como") && texto.contains("puedo") && texto.contains("llamarte"))) {
			return "nombre2";
		}
		if ((texto.contains("no") && texto.contains("me") && texto.contains("llamo"))
				|| (texto.contains("cambiar") && (texto.contains("de") || texto.contains("el"))
						&& texto.contains("nombre"))
				|| (texto.contains("cambiame") && (texto.contains("de") || texto.contains("el"))
						&& texto.contains("nombre"))) {
			return "nameChange";
		}
		if ((texto.contains("como") && texto.contains("me") && texto.contains("llamo"))
				|| (texto.contains("cual") && texto.contains("mi") && texto.contains("nombre"))) {
			return "nombreUsuario";
		}
		if ((texto.contains("que") && texto.contains("puedo") && (texto.contains("preguntarte"))
				|| (texto.contains("decirte")))) {
			return "quePuedoDecirte";
		}
		if ((texto.contains("soy") && texto.contains("una") && texto.contains("mujer"))
				|| (texto.contains("soy") && texto.contains("mujer"))) {
			return "soyMujer";
		}
		if ((texto.contains("que") && texto.contains("eres") || texto.contains("quien")) && (texto.contains("eres"))) {
			return "presentation";
		}
		if ((texto.contains("que es"))) {
			String[] busqueda = texto.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < busqueda.length; i++) {
				if (busqueda[i].startsWith("�") || busqueda[i].equals("que")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (busqueda[i].startsWith("�")) {
						busqueda[i] = busqueda[i].substring(1);
					}
					busqueda[i].replace("//?", "");
					if (busqueda[i].equals("que") || busqueda[i].equals("es") || busqueda[i].equals("un")
							|| busqueda[i].equals("una") || busqueda[i].equals("la") || busqueda[i].equals("el")) {
						busqueda[i] = "";
					}
					if (busqueda[i] != "") {
						searched += busqueda[i] + " ";
					}
				}
			}

			Interaccion.webUrl = "https://es.wikipedia.org/wiki/" + searched;
			return "queEs";
		}
		if ((texto.contains("busca")) && (texto.contains("en internet") || texto.contains("por internet"))) {
			String[] busqueda = texto.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < busqueda.length; i++) {
				if (busqueda[i].startsWith("busca")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (busqueda[i].startsWith("busca")) {
						busqueda[i] = "";
					}
					if (busqueda[i] != "") {
						searched += busqueda[i] + " ";
					}
				}
			}
			searched = searched.replaceFirst("en internet", "").replaceFirst("por internet", "");
			Interaccion.webUrl = "https://www.google.es/search?source=hp&ei=h3GNWu2HOYOGU6fgm6gI&q=" 
			+ searched + "&oq="+ searched;
			return "busqueda";
		}
		if ((texto.contains("busca"))) {
			String[] busqueda = texto.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < busqueda.length; i++) {
				if (busqueda[i].startsWith("busca")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (busqueda[i].startsWith("busca")) {
						busqueda[i] = "";
					}
					if (busqueda[i] != "") {
						searched += busqueda[i] + " ";
					}
				}
			}
			Interaccion.webUrl = "https://www.google.es/search?source=hp&ei=h3GNWu2HOYOGU6fgm6gI&q="
			+ searched + "&oq="+ searched;
			return "busqueda";
		}
		if ((texto.contains("no") && texto.contains("me") && texto.contains("llames")
				&& (texto.contains("maestro") || texto.contains("maestra")))
				|| (texto.contains("llamame") && texto.contains("por") && texto.contains("mi")
						&& texto.contains("nombre"))) {
			return "designatorChange";
		}
		if ((texto.contains("gracias") || (texto.contains("estoy") && texto.contains("agradecido")))) {
			return "gracias";
		}
		if ((texto.contains("besame") || (texto.contains("casate") && texto.contains("conmigo"))
				|| (texto.contains("dame") && texto.contains("un beso")))) {
			return "loveattempt";
		}
		if ((texto.contains("te quiero") || (texto.contains("te amo")))) {
			return "loveattempt2";
		}
		if ((texto.contains("di") && texto.contains("mi") && texto.contains("nombre"))) {
			return "sayMyName";
		}
		if ((texto.contains("como llegar a"))) {
			String[] busqueda = texto.split(" ");
			String searched = "";
			boolean startCollecting = false;
			for (int i = 0; i < busqueda.length; i++) {
				if (busqueda[i].startsWith("llegar")) {
					startCollecting = true;
				}
				if (startCollecting) {
					if (busqueda[i].startsWith("llegar") || busqueda[i].equals("a")) {
						busqueda[i] = "";
					}
					if (busqueda[i] != "") {
						searched += busqueda[i] + " ";
					}
				}
			}
			Interaccion.webUrl = "https://www.google.es/maps/dir/mi ubicaci�n/" + searched;
			return "comoLlegar";
		}
		return null;
		
	}

}
