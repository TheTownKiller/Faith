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
		if (((texto.contains("busca") || texto.contains("buscame")) && (texto.contains("en") || texto.contains("por"))  && texto.contains("internet"))) {
			String searched = texto.replace("buscame", "").replace("busca", "").replace("en", "").replace("por", "").replace("internet", "").replaceAll(" ", "");
			Interaccion.webUrl = "https://www.google.es/search?source=hp&ei=h3GNWu2HOYOGU6fgm6gI&q=" + searched + "&oq=" + searched + "&gs_l=psy-ab.3...2029.2286.0.2429.5.4.0.0.0.0.0.0..0.0....0...1.1.64.psy-ab..5.0.0.0...0.KW82B7fMHwk";
			return "busqueda";
		}
		return null;

	}

}
