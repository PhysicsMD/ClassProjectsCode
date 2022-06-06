.data

startprint:	.asciiz "Number List: "
comma:		.asciiz	", "

array: .space 40

.text
.globl	main

main:
la $s0, array
li $s1, 5


la        $a0, startprint          
li        $v0, 4
syscall
lw $t3, 0($s0)
move $a0, $t3              #arbitrary number place
li $v0, 1
syscall
addi $t2, $t2, 1

dump:
addi $s0, $s0, 4
beq $t2, $s1, endc
lw $t3, 0($s0)
la        $a0, comma          
li        $v0, 4
syscall
move $a0, $t3              #arbitrary number place
li $v0, 1
syscall
addi $t2, $t2, 1
j dump

endc:
li        $v0, 10                   
syscall