public class Prisoner_Execution{
	private Cupboard prisoner_cupboard;
	private boolean successful;
	private int prisoner_failed;

	public Prisoner_Execution(int prisoner_number){
		prisoner_cupboard = new Cupboard(prisoner_number);
		// System.out.println(prisoner_cupboard);
		successful = true;
		prisoner_failed = -1;

		for(int i = 0; i < prisoner_number && successful; i++){
			int nextNumber = prisoner_cupboard.peek(i);
			// this will check "51" times, but the 51st time will be the prisoner picking the box the 50th box told him to without peeking
			for(int j = 0; j < 50; j++){
				if(nextNumber != i){
					nextNumber = prisoner_cupboard.peek(nextNumber);
				}
				else
					break;
			}

			if(nextNumber != i){
				successful = false;
				prisoner_failed = i;
			}
		}
	}

	/**
	 *	Returns the chain of cupboard numbers that the failed prisoner took
	 *	@return a string representing the chain of cupboard numbers that the failed prisoner took
	 */
	public String failedChainString(){
		String ret = "" + prisoner_failed + " | " + prisoner_cupboard.peek(prisoner_failed);
		int nextCupboard = prisoner_cupboard.peek(prisoner_failed);
		// this will check "51" times, but the 51st time will be the prisoner picking the box the 50th box told him to without peeking
		for(int i = 0; i < 50; i++){
			ret = ret + ", " + prisoner_cupboard.peek(nextCupboard);
			nextCupboard = prisoner_cupboard.peek(nextCupboard);
		}

		return ret;
	}

	/**
	 *	Returns the cupboard that contains the prisoner IDs
	 *	@return the cupboard
	 */
	public Cupboard getCupboard(){
		return prisoner_cupboard;
	}

	/**
	 *	Returns if the prisoners were sucessfully released
	 *	@return whether the prisoners were able to be released
	 */
	public boolean isSuccessful(){
		return successful;
	}
}