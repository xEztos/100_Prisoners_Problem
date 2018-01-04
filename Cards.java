public class Cards{
	int[] cardStack;
	int top;

	/**
	 *	Creates a deck of cards from 0 to the size of the deck-1
	 */
	public Cards(int deckSize){
		cardStack = new int[deckSize];
		top = 0;

		for(int i = 0; i < deckSize; i++){
			cardStack[i] = i;
		}
	}

	public void shuffle(){
		top = 0;

		double amount = Math.random() * 100;
		for(int i = 0; i < amount; i++){
			cut();
			if(Math.random()*2 > 1){
				perfect_in_riffle();
			} else{
				perfect_out_riffle();
			}
		}
	}

	private void perfect_in_riffle(){
		int[] temp = new int[cardStack.length];
		// System.out.println(temp.length);
		for(int i = 0; i < temp.length; i++){
			// System.out.println(i);
			if(i*2+1 < temp.length){
				temp[i*2+1] = cardStack[i];
			}
			else{
				temp[2*(i - temp.length/2)] = cardStack[i];
			}
		}

		cardStack = temp;
	}

	private void perfect_out_riffle(){

		int[] temp = new int[cardStack.length];
		// System.out.println(temp.length);
		for(int i = 0; i < temp.length; i++){
			// System.out.println(i);
			if(i*2 < temp.length){
				temp[i*2] = cardStack[i];
			}
			else{
				temp[(int)(2*(i - Math.round(temp.length/2.0))+1)] = cardStack[i];
			}
		}

		cardStack = temp;
	}

	private void cut(){
		int[] temp = new int[cardStack.length];
		int card = (int)(Math.random()*temp.length);

		for(int i = 0; i < temp.length; i++){
			if(card >= temp.length)
				card = 0;
			temp[i] = cardStack[card++];
		}

		cardStack = temp;
	}

	/**
	 *	Returns the top card of the card stack
	 * 	@return the top card of the card stack
	 */
	public int pop(){
		int ret = cardStack[top];
		top++;
		return ret;
	}


	/**
	 *	Returns a string version of the deck of cards
	 *	@return a string version of the deck of cards
	 */
	public String toString(){
		String ret = "" + cardStack[0];
		for(int i = 1; i < cardStack.length; i++){
			ret = ret + ", " + cardStack[i];
		}
		return ret;
	}
}