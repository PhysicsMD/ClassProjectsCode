#include <msp430.h>
// assumes LED1 = P1.0
void main(void)
{
 WDTCTL = WDTPW | WDTHOLD; // stop watchdog timer
 PM5CTL0 = 0xFFFE; // to enable inputs and outputs
 P1DIR|=BIT0; // for LED1 set P1.0 to output
 P1OUT|=BIT0; // turn on LED1
 int i = 0;
for(i; i < 0x12000; i++){
        if(i==0){
            P1OUT^=BIT0; // toggle led
            i = 10;
        }
}
}