package tictactoe;

public class Player {
	private String name;
	private char symbol;
	public Player(String name, char symbol) {
		super();
		setName(name);
		setSymbol(symbol);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!name.isEmpty()) {
			this.name = name;
		}
		
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		if(symbol!='\0') {
			this.symbol=symbol;
		}
	}
	
}
