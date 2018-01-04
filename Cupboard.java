public class Cupboard{
	private int[] container;

	/**
	 *	constructor for the cupboard filled with random numbers
	 */
	public Cupboard(int cupboard_size){
		container = new int[cupboard_size];

		for(int i = 0; i < container.length; i++){
			//impliment a way where the cupboard is populated with numbers 0 to cupboard_size with each number appearing only once
		}
	}

	/**
	 *	Allows the prisoner to peek into a specific cupboard drawer
	 *	@return a number that is in the drawer
	 */
	public int peek(int container_number){
		return container[container_number];
	}

	/**
	 *	Returns a string representation of the cupboard and its contents
	 *	@return a string representation of the cupboard and its contents
	 */
	public String toString(){
		String ret = String.format("Cupboard | ID%n");
		for(int i = 0; i < container.length; i++){
			ret = ret + String.format("%9d|%3d%n", i, container[i]);
		}
		return ret;
	}
}