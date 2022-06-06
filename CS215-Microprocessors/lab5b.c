#include <msp430.h>
// assumes LED1 = P1.0
void main(void)
{
 WDTCTL = WDTPW | WDTHOLD; // stop watchdog timer
 PM5CTL0 = 0xFFFE; // to enable inputs and outputs
 P1DIR|=BIT0; // for LED1 set P1.0 to output
 P1OUT|=BIT0; // turn on LED1

 P1DIR &=~ BIT1;
 P1REN |= BIT1;
 P1OUT|= BIT1;

for( ; ; ){
if((P1IN & BIT1) == 0){
    P1OUT&=~BIT0;
}
if((P1IN & BIT1) != 0){
    P1OUT|=BIT0;
}}
}

lab5c
#include <msp430.h>
// assumes LED1 = P1.0
void main(void)
{
 WDTCTL = WDTPW | WDTHOLD; // stop watchdog timer
 PM5CTL0 = 0xFFFE; // to enable inputs and outputs
 P1DIR|=BIT0; // for LED1 set P1.0 to output
 P1OUT|=BIT0;

 P1OUT &=~ BIT0;
 P1DIR |= BIT0;
 TA0CTL |= TASSEL_1 | MC_1|TACLR;
 TA0CCR0 = 0x8000;
 for(;;){
    if(TA0CTL & TAIFG){
        P1OUT^=BIT0;
        TA0CTL &=~BIT0;
    }
 }
}