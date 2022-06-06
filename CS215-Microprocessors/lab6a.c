#include <msp430.h>
// assumes LED1 = P1.0
//lab6a
void main(void)
{
 WDTCTL = WDTPW | WDTHOLD; // stop watchdog timer
 PM5CTL0 = 0xFFBE; // to enable inputs and outputs
 P1DIR|=BIT0; // for LED1 set P1.0 to output
 P1OUT|=BIT0; // turn on LED1
 P9DIR|=BIT7; // for LED1 set P1.0 to output
 P9OUT|=BIT7; // turn on LED1
 P9OUT&=~BIT7;

 P1DIR &=~ BIT1;
 P1REN |= BIT1;
 P1OUT|= BIT1;

 P1DIR &=~ BIT2;
 P1REN |= BIT2;
 P1OUT|= BIT2;

 TA0CTL |= TASSEL_1 | MC_1|TACLR;
  TA0CCR0 = 0x8000;

for( ; ; ){
    if(TA0CTL & TAIFG){
            P1OUT^=BIT0;
            TA0CTL &=~BIT0;
        }
if((P1IN & BIT1) != 0){
    P9OUT&=~BIT7;
}
if((P1IN & BIT1) == 0){
    P9OUT|=BIT7;
}
if((P1IN & BIT2) != 0){
    P9OUT&=~BIT7;
}
if((P1IN & BIT2) == 0){
    P9OUT|=BIT7;
}
}
}