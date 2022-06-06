.data
SCORES: .byte   100, 78, 63, 88, 52, 91, 75, 193, 98, 95, 176, 61, 164, 88, 115, 50, 41, 32, 46, 67

		.text
		clr.w R4; Holds first address of list
		clr.w R5; Holds last address of list
		clr.w R6; Holds current
		clr.w R7; how many swaps
		clr.w R8; how many full loops
		clr.w R9
		clr.w R15
		mov.w #SCORES,R6

Start:
		mov.b @R6, R8
		add.w #1, R6
		mov.b @R6,R9
		cmp.b R9,R8
		jlo noswap

		mov.b R8, 0(R6)
		dec.w R6
		mov.b R9, 0(R6)
		inc.w R6
		inc.w R7
noswap:
		inc.w R15
		cmp.w #19,R15
		jne Start
		jeq completecheck
fresh:
		clr.w R15
		clr.w R7
		jmp Start
completecheck:
		mov.w #SCORES,R6
		cmp.w #0,R7
		jne fresh
exit:
		jmp $