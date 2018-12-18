	MOVI 180 r1 	// initial a
	MOVI 18 r2 		// initial i
	MOVI 1 r3 		// useful 1 

loop:
	MOVI 25 r4 		// Compare for loop end
 
	PUSH r2 		// r2 = b
	PUSH r1 		// r1 = a
	MOVI gcd r5 	// save gcd address 
	JAL r5 			// call gcd with a and b
	POP r6 			// clear stack x2
	POP r6
	OUT r7 			// print result 

	ADD r3 r2 		// i++
	SUB r2 r4 		// compare i to 25

	MOVI loop r8 	// save loop address
	JNZ r4 r8 		// jump back to loop if i < 25

HALT
	
gcd:
	PUSH r30		// save old FP
	MOV r31 r30 	// move FP to where SP is
	PUSH r29		// save (old) RP
	ADD r3 r31      // make space for 1 loval on stack
	
	LDLO -2 r7 		// read formal parameter b
	LDLO -3 r9      // read formal parameter a
	STLO 1 r7       // save as local x2
	STLO 2 r9

	MOVI mod r10    // save mod address
	JNZ r9 r10      // call mod if b != 0

	SUB r3 r31   	// remove 1 space from stack
	POP r29			// restore saved RP
	POP r30			// restore saved FP
	RET			    // return
	
mod:

	MOV r7 r11		// compute a % b
	IDIV r9 r11		// r11 = (r7 / r9) * r9
	MUL r9 r11	
	SUB r11 r7		// r7 -= r11

	PUSH r7			// add the new a to the stack
	PUSH r9         // add the new b to the stack
	
	JAL r5          // recursive call to gcd

	POP r6			// clear stack x2
	POP r6

	SUB r3 r31		// remove 1 space from the stace
	POP r29			// restore saved RP
	POP r30			// restore saved RP

	RET			    // return
