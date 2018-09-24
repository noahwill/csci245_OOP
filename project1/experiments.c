#include <stdio.h>

#include "array_util.h"
#include "sorts.h"

/* 
1) Will running time be accuarately predicted by how many comparisons an
algorithm makes?

2) Does the experimental running time match the theoretical running time 
for selection, bubble, quick, and merge sorts?
*/

int
main()
{
	int i;
	long fore, aft;
	int comparisons;

	int master[500000];
	int copy[500000];

	int sizes[] = { 10, 50, 100, 150, 500, 10000, 15000, 20000, 25000,
		30000, 35000, 40000, 45000, 50000
	};
	
	/*
	The first part of the experiment prints the number of comparisons for 
	each sorting algorithm for arrays ranging from sizes[0] to sizes[4].
	*/
	printf("\tslection\tinsertion\tbubble\tquick\tshell\tmerge\n");
	printf("comparisons\n");
	for (i = 0; i < 4; i++) {
		printf("%d:", sizes[i]);
		random_array(master, sizes[i]);

		copy_array(master, copy, sizes[i]);
		comparisons = selectionSort(copy, sizes[i]);

		printf("\t%d", comparisons);

		copy_array(master, copy, sizes[i]);
		comparisons = insertionSort(copy, sizes[i]);

		printf("\t\t%d", comparisons);

		copy_array(master, copy, sizes[i]);
		comparisons = bubbleSort(copy, sizes[i]);

		printf("\t\t%d", comparisons);

		copy_array(master, copy, sizes[i]);
		comparisons = quickSort(copy, sizes[i]);

		printf("\t%d", comparisons);

		copy_array(master, copy, sizes[i]);
		comparisons = shellSort(copy, sizes[i]);

		printf("\t%d", comparisons);

		copy_array(master, copy, sizes[i]);
		comparisons = mergeSort(copy, sizes[i]);

		printf("\t%d\n", comparisons);
	}

	/*
	The second part of the experiment prints the running times for 
	each sorting algorithm for arrays ranging from sizes[4] to sizes[14].
	*/
	printf("running times\n");
	for (i = 4; i < 14; i++) {
		random_array(master, sizes[i]);
		printf("%d:", sizes[i]);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		selectionSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t%ld", aft - fore);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		insertionSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t\t%ld", aft - fore);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		bubbleSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t\t%ld", aft - fore);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		quickSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t%ld", aft - fore);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		shellSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t%ld", aft - fore);

		copy_array(master, copy, sizes[i]);
		fore = get_time_millis();
		mergeSort(copy, sizes[i]);
		aft = get_time_millis();

		printf("\t%ld\n", aft - fore);

	}

	return 0;
}
