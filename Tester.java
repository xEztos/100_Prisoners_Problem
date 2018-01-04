public class Tester{
	public static void main(String[] args){

		int successful_tests = 0;
		int test_runs = 100;
		for(int i = 0; i < test_runs; i++){

			// Runs the prisoner problem with 100 prisoners
			Prisoner_Execution test = new Prisoner_Execution(100);

			if(test.isSuccessful()){
				successful_tests++;
			}
			else{
				System.out.println(test.failedChainString());
			}
		}

		System.out.println("Successful Runs: " + (((double)successful_tests)) / test_runs);
	}
}