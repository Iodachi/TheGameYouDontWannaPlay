package character;

public class NPC {
	private String name;
	private String talkContent;
	
	public String getTalkContent() {return talkContent;}
	public NPC(String name) {
		this.name=name;
	}
	public void talk() {
		switch (name) {
		case "N1":
			talkContent="111111";
			break;
		case "N2":
			talkContent="2222222";
			break;
		case "N3":
			talkContent="333333";
			break;
		case "N4":
			talkContent="44444";
			break;
		case "N5":
			talkContent="55555";
			break;

		}
	}
	
}
	