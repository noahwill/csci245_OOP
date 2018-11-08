#include <stdlib.h>

#include "bitvector.h"

/* Returns the number of bytes for a given number of bits. */
int
numBytes(int bits)
{
	int bytes = (bits + 8 -1)/8;
	return bytes;
}

/* Creates and returns a new bit_vector struct of the given number of bits. 
Allocates memory for the struct, it's pointer to the array (with everything set to 0). */
struct bit_vector *
bv_create(int size)
{
	bit_vector_t *newBV = malloc(sizeof(bit_vector_t));
	newBV->size = size;
	newBV->vector = calloc(numBytes(size), sizeof(unsigned char));
	return newBV;
}

 /* Destroys the given bit_vector by freeing it's pointer to the array and the struct itself. */
void
bv_destroy(struct bit_vector *v)
{
	free(v->vector);
	v->vector = NULL;
	free(v);
}

/* Checks to see if a bit_vector contains the integer given .*/
int
bv_contains(struct bit_vector *v, int i)
{
	if ((((v->vector)[i/8] >> (i%8)) & 1) != 0)
		return 1;
	return 0;
}

/* Inserts a given integer into the bit_vector. */
void
bv_insert(struct bit_vector *v, int i)
{
	(v->vector)[i/8] = ((v->vector)[i/8] | (1 << (i%8)));
}

/* Removes a given integer from the bit_vector. */
void
bv_remove(struct bit_vector *v, int i)
{
	if (bv_contains(v, i)) { (v->vector)[i/8] = ((v->vector)[i/8] & ~(1 << (i%8))); }
}

/* Produces the complement of a bit_vector */
struct
bit_vector *
bv_complement(struct bit_vector *v)
{
	struct bit_vector *bv = bv_create(v->size);
	for(int i = 0; i < numBytes(v->size); i++){ (bv->vector)[i] = ~(v->vector)[i]; }
	return bv;
}

/* Produces the union of two bit_vectors. */
struct bit_vector *
bv_union(struct bit_vector *v1, struct bit_vector *v2)
{
	struct bit_vector *u = bv_create(v1->size);
	for (int i = 0; i < numBytes(v1->size); i++) { (u->vector)[i] = (v1->vector)[i] | (v2->vector)[i]; }
	return u;
}

/* Produces the intersection of two bit_vectors. */
struct bit_vector *
bv_intersection(struct bit_vector *v1, struct bit_vector *v2)
{
	struct bit_vector *u = bv_create(v1->size);
	for (int i = 0; i < numBytes(v1->size); i++) { (u->vector)[i] = (v1->vector)[i] & (v2->vector)[i]; }
	return u;
}

/* Produces the difference of two bit_vectors. */
struct bit_vector *
bv_difference(struct bit_vector *v1, struct bit_vector *v2)
{
	struct bit_vector *u = bv_create(v1->size);
	for (int i = 0; i < numBytes(v1->size); i++) { (u->vector)[i] = (v1->vector)[i] ^ (v2->vector)[i]; }
	return u;
}
