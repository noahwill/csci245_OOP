

/* OK I have this idea for more work on this project...
   I want to do the experiments multiple times and collect 
   the averages, then print the averages on the screen.
   This would make it possible to find significance and all
   that fun statistical stuff.
*/

int arrayAvg(int array[], int i, int avg)
{
	int avg = array[i];

	if (i - 1 > 0)
	{
		avg = (array[i]+array[i-1])/2
	}
	return avg;
}
