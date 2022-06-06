.data
#prompts
numPrompt:	.asciiz "Enter a Number 1-10: "
errortolow:	.asciiz "Number to Low\n"
errortobig:	.asciiz "Number to Big\n"
newnum:		.asciiz "\nEnter a Number: "
finalcount:	.asciiz	"\nFinal count was "
startprint:	.asciiz "Number List: "
comma:		.asciiz	", "
newline:	.asciiz	"\n"

Numconstlw:	.word	1
Numconstbg:	.word	10

intIn:	.word	0
StrIn:	.space	256

array: .space 40

.text
.globl	main

main:
	jal ReadNums
	#jal BSort currently does not work, wasted too much time on output
	jal PrintNums
	li $v0, 10
	syscall

ReadNums:
lw $t3, Numconstlw
lw $t4, Numconstbg

prompt:
la        $a0, numPrompt
li        $v0, 4 
syscall
li        $v0, 5
syscall
move $t5, $v0
bgt $t5, $t4, bigcode
blt $t5, $t3, smallcode
la $s0, array
j read

bigcode:
la        $a0, errortobig           
li        $v0, 4                   
syscall
j prompt

smallcode:
la        $a0, errortolow           
li        $v0, 4                   
syscall
j prompt	#jump to top

read:
beq $s1, $t5, endpl
la        $a0, newnum          
li        $v0, 4                   
syscall
li        $v0, 5
syscall
sw $v0, ($s0)
addi $s0, $s0, 4
addi $s1, $s1, 1
j read

endpl:
la        $a0, finalcount          
li        $v0, 4
syscall
move $a0, $s1
li $v0, 1
syscall
la        $a0, newline          
li        $v0, 4
syscall
jr $ra


BSort:
la $s0, array
sort:
lw $t2, ($s0)
lw $t3, 4($s0)
ble $t2, $t3, loop
sw $t2, 4($s0)
sw $t3, 0($s0)
loop:
addi $s0, $s0, 4
addi $t6, $t6, 1
bgt $t6, $t5, sort
addi $t6, $t0, 0
addi $t7, $t7, 1
bgt $t7, $t5, Bsort
jr $ra

PrintNums:
la $s0, array
la        $a0, startprint          
li        $v0, 4
syscall
lw $t3, ($s0)
move $a0, $t3             #arbitrary number place
li $v0, 1
syscall
addi $t2, $t2, 1

dump:
addi $s0, $s0, 4
beq $t2, $s1, endc
lw $t3, ($s0)
la        $a0, comma          
li        $v0, 4
syscall
move $a0, $t3              #arbitrary number place
li $v0, 1
syscall
addi $t2, $t2, 1
j dump

endc:
la        $a0, newline          
li        $v0, 4
syscall
jr $ra