.text

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

jr $ra