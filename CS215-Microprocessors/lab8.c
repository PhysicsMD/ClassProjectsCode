#include <msp430.h>
#include <driverlib.h> // Required for the LCD
#include "myGpio.h" // Required for the LCD
#include "myClocks.h" // Required for the LCD
#include "myLcd.h" // Required for the LCD
#define ADC12_SHT_16 0x0200 //
#define ADC12_ON 0x0010 //
#define ADC12_SHT_SRC_SEL 0x0200 //
#define ADC12_12BIT 0x0020 //
#define ADC12_P92 0x000A //
void main(void)
{
WDTCTL = WDTPW | WDTHOLD; // Watchdog timer stop
TA0CTL |= TASSEL_1 | MC_1 | TACLR;
TA0CCR0 = 0x8000;
// initialize LCD
initGPIO(); // Initializes inputs and outputs for LCD
initClocks(); // Initialize clocks for LCD
myLCD_init(); // Prepares LCD to receive commands
ADC12CTL0 = ADC12_SHT_16 | ADC12_ON ; //
ADC12CTL1 = ADC12_SHT_SRC_SEL; //
ADC12CTL2 = ADC12_12BIT; //
ADC12MCTL0 = ADC12_P92; //
// mode is single source, single conversion
int count = 0;
int num = 0;
while(1){
    ADC12CTL0 = ADC12CTL0 | ADC12ENC; // Enable conversion
    ADC12CTL0 = ADC12CTL0 | ADC12SC; // Start conversion
    while(num == 0){
        if(TA0CTL & TAIFG){
            num += 1;
        }};
    TA0CTL &=~ BIT0;
    num -= 1;
    if(ADC12MEM0<=0x253){
        myLCD_displayNumber(0);
    }
    else if(ADC12MEM0<=0x9CC){
        myLCD_displayNumber(1);
        }
    else if(ADC12MEM0>0x9CC){
        myLCD_displayNumber(2);
        }
    };
}
