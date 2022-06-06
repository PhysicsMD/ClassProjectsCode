;-------------------------------------------------------------------------------
; MSP430 Assembler Code Template for use with TI Code Composer Studio
;
;
;-------------------------------------------------------------------------------
            .cdecls C,LIST,"msp430.h"       ; Include device header file
            
;-------------------------------------------------------------------------------
            .def    RESET                   ; Export program entry-point to
                                            ; make it known to linker.
;-------------------------------------------------------------------------------
            .text                           ; Assemble into program memory.
            .retain                         ; Override ELF conditional linking
                                            ; and retain current section.
            .retainrefs                     ; And retain any sections that have
                                            ; references to current section.

;-------------------------------------------------------------------------------
RESET       mov.w   #__STACK_END,SP         ; Initialize stackpointer
StopWDT     mov.w   #WDTPW|WDTHOLD,&WDTCTL  ; Stop watchdog timer


;-------------------------------------------------------------------------------
; Main loop here
;-------------------------------------------------------------------------------

	.data
values: .byte 1,3,4,7,9,10,12,17,19,21,26
lastv: .byte 1
search: .byte 26
index: .space 1

	.text
main:
	clr.w R7
	mov.b search,R7;search value
	clr.w R5;low address
	clr.w R6;high address
	mov.w #0, R5
	mov.w #10,R6
	call #sub
	jmp $
sub:
	rra.b R6
	add.w #0x1c00, R6
	cmp.b 0(R6),R7
	jeq equal
	jl less
	mov.w R6,R5
	jge greater
less:
	sub.w #0x1c00, R6
	jmp sub
equal:
	sub.w #0x1c00, R6
	mov.w #index,R5
	mov.b R6,0(R5)
	ret
greater:
	mov.w R5,R6
	cmp.b 0(R5),R7
	jeq equal
	inc.w R5
	jmp greater
	NOP


;-------------------------------------------------------------------------------
; Stack Pointer definition
;-------------------------------------------------------------------------------
            .global __STACK_END
            .sect   .stack
            
;-------------------------------------------------------------------------------
; Interrupt Vectors
;-------------------------------------------------------------------------------
            .sect   ".reset"                ; MSP430 RESET Vector
            .short  RESET
}