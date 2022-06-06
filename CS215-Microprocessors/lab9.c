#include <msp430.h> 


/**
 * main.c
 */
int main(void)
{
	WDTCTL = WDTPW | WDTHOLD;	// stop watchdog timer
	PM5CTL0 = 0xFFFE;
	P1DIR |= BIT0;
	P1OUT |= BIT0;
	P1DIR &=~ BIT1;
	P1REN |= BIT1;
	P1OUT |= BIT1;
	TA0CTL = TASSEL_1|MC_1;
	TA0CCR0=0X8000;
	TA0CCTL0 |= CCIE;
	__enable_interrupt();
	while(1){LPM3;};

}
#pragma vector =  TIMER0_A0_VECTOR
__interrupt void TIMER0_A0_INTERRUPT(void)

{
    if((P1IN&BIT1)==0){
    P1OUT ^= BIT0;
    P1IFG &=~ BIT6;
}else{
P1OUT &=~ BIT0;
}
}