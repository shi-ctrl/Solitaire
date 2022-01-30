import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
	private char suit;
	private int face;
	Card (char suit, int face){
		this.setSuit(suit);
		this.setFace(face);
	}

	public Card() {
	}
	
	void updateCard(Card newCard) {
		this.setSuit(newCard.getSuit());
		this.setFace(newCard.getFace());
	}
	
	public void display() {
		System.out.println(suit+face);
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}
}

class PlayedCard extends Card {
	private boolean isFaceUp;
	
	PlayedCard (Card card, boolean isFaceUp){
		super(card.getSuit(), card.getFace());
		this.isFaceUp=isFaceUp;
	}
	
	public boolean getFaceUp() {
		return isFaceUp;
	}

	public void setFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}
	
	public void display() {
		if (isFaceUp) {
			System.out.print(super.getSuit()+"."+super.getFace());
		} else {
			System.out.print("XXX-");
		}
	}
}

class Deck {
	private List<Card> standard = new ArrayList<Card>();
	char[] suits = {'s', 'd', 'h', 'c'};
	
	Deck() {
		for (int i = 1; i<14; i++) {
			for (int j=0; j<4; j++) {
				Card card = new Card(suits[j], i);
				standard.add(card);
			}
		}
	}
	
	public List<Card> getDeck (){
		return standard;
	}
}

class TableauRow {
	private List<PlayedCard> column = new ArrayList<PlayedCard>();

	public List<PlayedCard> getColumn() {
		return column;
	}

	public void setColumn(List<PlayedCard> column) {
		this.column = column;
	}
	
	public void addCard(PlayedCard card) {
		column.add(card);
	}
}

class Tableau {
	TableauRow[] tableauBoard = new TableauRow[7];
	
	Tableau () {
		for (int i = 0; i<7; i++) tableauBoard[i] = new TableauRow();
	}
	
	public List<Card> makeBoard (List<Card> deck) {
		for (int i = 0; i<7; i++) {
			for (int j = 0; j<7; j++) {
				int lastCard = deck.size()-1;
				//checks the diagonals, and the inner face down cards
				if (i==j) {
					tableauBoard[i].addCard(new PlayedCard(deck.get(lastCard), true));
					deck.remove(lastCard);
				} else if (i>j) {
					tableauBoard[i].addCard(new PlayedCard(deck.get(lastCard), false));
					deck.remove(lastCard);
				} 
			}
		}
		
		return deck;
	}
	
	public void addCard(Card card, int columnPos) {
		int columnSize = tableauBoard[columnPos].getColumn().size();
		
		if (columnSize==0) {
			// if empty, check if king
			if (card.getFace()==13) tableauBoard[columnPos].addCard(new PlayedCard(card, true));
			else System.out.println("Not king");
		} else {
			char lastSuit = tableauBoard[columnPos].getColumn().get(columnSize-1).getSuit();
			char curSuit = card.getSuit();
			// if not empty, check if the last suit was red or black and what the current card is 
			if ((lastSuit=='s'||lastSuit=='c')&&(curSuit=='d'||curSuit=='h')) tableauBoard[columnPos].addCard(new PlayedCard(card, true));
			else if ((lastSuit=='d'||lastSuit=='h')&&(curSuit=='s'||curSuit=='c')) tableauBoard[columnPos].addCard(new PlayedCard(card, true));
			else System.out.println("Invalid");
			
		}
	}
	
	public void display() {
		for (int i = 0; i<7; i++) {
			int columnSize = tableauBoard[i].getColumn().size();
			for (int j = 0; j<columnSize; j++) {
				tableauBoard[i].getColumn().get(j).display();
			}
			System.out.println();
		}
	}
}

public class Solitaire {

	public static void main(String[] args) {
		List<Card> currentDeck = new Deck().getDeck();
		Tableau tableau = new Tableau();		
		Collections.shuffle(currentDeck);
		
		Card kingCard = new Card('d',13);
		Card blackCard = new Card('s',10);
		Card redCard = new Card('h',10);
		
		int proofSwitch = 1;
		
		if (proofSwitch==1) {
			tableau.addCard(redCard, 0);
			tableau.addCard(kingCard, 0);
			tableau.addCard(redCard, 0);
			tableau.addCard(blackCard, 0);
		} else if (proofSwitch==2) {
			currentDeck = tableau.makeBoard(currentDeck);
		}
		
		
		//currentDeck = tableau.makeBoard(currentDeck);
		tableau.display();

	}

}
