#include <stdio.h>

#include "bitvector.h"

/* Modified printVec: takes bit vector and the max number in the sieve */
void
printSieve(struct bit_vector *sieve, int n)
{
	int isFirst, i;
	printf("{");
	isFirst = 1;
	for (i = 2; i <= n; i++)
		if (bv_contains(sieve, i)) 
		{
			if (!isFirst)
				printf(", ");
			printf("%d", i);
			isFirst = 0;
		}
	printf("} \n");
}

/* Sieve of Eratosthenes algorithm */
int
main(void)
{
	int n, i, j;
	struct bit_vector *sieve;

	printf("Wanna make a big 'ol sieve? How big? -> ");
	scanf("%d", &n);

	sieve = bv_create(n + 1);
	
	for (i = 0; i <= n; i++) { bv_insert(sieve, i); }

	for (j = 2; j*j <= n; j++) 
	{
		if(bv_contains(sieve, j))
		{
			for (i = j*2; i <= n; i += j) 
			{ 
				bv_remove(sieve, i); 
			}
		}
	}
	
	printSieve(sieve, n);

	bv_destroy(sieve);

	return 0;
}
