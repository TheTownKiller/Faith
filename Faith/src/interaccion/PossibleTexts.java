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
		if ((texto.contains("como") && texto.contains("me") && texto.contains("llamo"))
				|| (texto.contains("cual") && texto.contains("mi") && texto.contains("nombre"))) {
			return "nombreUsuario";
		}
		if ((texto.contains("que") && texto.contains("puedo") && (texto.contains("preguntarte"))
				|| (texto.contains("decirte")))) {
			return "quePuedoDecirte";
		}
		if ((texto.contains("soy") && texto.contains("una") && texto.contains("mujer")) || 
				(texto.contains("soy") && texto.contains("mujer"))) {
			return "soyMujer";
		}
		if ((texto.contains("no") && texto.contains("me") && texto.contains("llames") && (texto.contains("maestro") || 
				texto.contains("maestra"))) || (texto.contains("llamame") && texto.contains("por") && texto.contains("mi") && 
				texto.contains("nombre"))) {
			return "designatorChange";
		}
		if ((texto.contains("que") && texto.contains("eres") || texto.contains("quien")) && (texto.contains("eres"))) {
			return "presentation";
		}
		return null;

	}

}
