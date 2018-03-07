package interaction;

public class UrlAssignator {
	
	Interaction interaction = new Interaction();
	
	public String getUrl() {
		String type = interaction.getType();
		int randomizer = (int) (Math.random()*10);
		if(type=="LONG" && randomizer>5 ) {
			return "/src/resources/25Chars.mp4";
		}else if(type=="LONG" && randomizer<=5) {
			return "/src/resources/25Chars2.mp4";
		}else if(type=="MEDIUM" && randomizer>5) {
			return "/src/resources/20Chars.mp4";
		}else if(type=="MEDIUM" && randomizer<=5) {
			return "/src/resources/20Chars2.mp4";
		}else if(type=="SHORT" && randomizer>5) {
			return "/src/resources/15Chars.mp4";
		}else  
			return "/src/resources/15Chars2.mp4";
	}
}
