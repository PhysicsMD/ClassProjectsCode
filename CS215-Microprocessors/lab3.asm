.data
Scores: .byte 18,20,6,10,16,16,18,19,13,0,14,16,14,17,16
histo: 	.space 21
mode: 	.space 1
max: 	.space 1

		.text
main:	mov.w #Scores, R13; List first address
		clr.w R15; Maximum
		clr.w R10; Mode
		clr.w R6; List Counter
		clr.w R7; Place holder
		clr.w R12
		clr.w R14;
		add.w #14,R14;
		call #maxi
		call #histos
		call #mode_
		jmp $
maxi:
		cmp #0,R7
		jeq setter
		inc.w R6
		inc.w R7
		mov.b @R7, R8
		mov.b @R15,R9
		cmp.b R8,R9
		jlo swap
		cmp #14,R6
		jne maxi
		call #maxsave
		ret
setter:
		mov.w R13,R7
		mov.w R13,R15
		jmp maxi
swap:
		mov.w R7, R15
		jmp maxi
maxsave:
		mov.b @R15,max
		ret
histos:
		clr.w R15 ; number of occurences is zero
again:
		mov.b @R13,R11 ; move data to temporary R11
		cmp.b R11,R12 ; is R11 same as value?
		jne skip ; if not same, then skip
		add.b #1,R15 ; found a score same as value!
skip:
		add.w #1,R13 ; next address
		cmp.w R13,R14 ; R14-R13: info to SR
		jl done2 ; done with list, go to return
		jmp again
		add.w R12,R13
		mov.b R15,@R13
done2:
		ret
mode_:
		jmp $


exit:
		jmp $