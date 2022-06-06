.data
X: .word 0x1234
Y: .word 0xABCD
Z1: .byte 0x12
Z2: .byte 0x0F
Mem: .space 64

	.text
	mov.w X,Mem+0
	mov.b X,Mem+4
	mov.w X,R9
	mov.w Y,R4
	mov.b Z1,R5
	mov.b Z2,R6
	swpb R9
	mov.b R9,Mem+8

	mov.w X,R9
	clr.w R7
	add.w R9,R7
	add.w R4,R7
	mov.w R7,Mem+12

	mov.b R5,R8
	add.b R6,R8
	mov.b R8,Mem+16
	clr.b R8

	add.b R5,R8
	sub.b R6,R8
	mov.b R8,Mem+20
	clr.b R8


	add.b R6,R8
	sub.b R5,R8
	mov.b R8,Mem+24
	clr.b R8

	add.w R4,R7
	sub.w R9,R7
	mov.w R7,Mem+28
	clr.w R7

	add.w R9,R7
	sub.w R4,R7
	mov.w R7,Mem+32
	clr.w R7

	mov.w R4,R7
	inv.w R7
	mov.w R7,Mem+36
	clr.w R7

	mov.b R5,R8
	inv.b R8
	mov.b R8,Mem+40
	clr.b R8

	mov.w X,Mem+44

	add.b R5,R8
	and.b R6,R8
	mov.b R8,Mem+48
	clr.b R8

	add.b R5,R8
	xor.b R6,R8
	mov.b R8,Mem+52
	clr.b R8

	mov.b R5,R8
	dec.b R8
	mov.b R8,Mem+56
	clr.b R8

	mov.b R5,R8
	decd.b R8
	mov.b R8,Mem+60
	clr.b R8

	swpb.w R9
	mov.w R9,Mem+64

	jmp $
	NOP