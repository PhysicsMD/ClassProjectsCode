#include <msp430.h>
#include <msp430fr6989.h>
#define UART_CLK_SEL 0x0080 // Specifies accurate SMCLK clock for UART
#define BR0_FOR_9600 0x34 // Value required to use 9600 baud
#define BR1_FOR_9600 0x00 // Value required to use 9600 baud
#define CLK_MOD 0x4911 // Microcontroller will "clean-up" clock signal
void select_clock_signals(void); // Assigns microcontroller clock signals
void assign_pins_to_uart(void); // P4.2 is for TXD, P4.3 is for RXD
void use_9600_baud(void); // UART operates at 9600 bits/second


int main(void){
    WDTCTL = WDTPW | WDTHOLD;// stop watchdog timer
    PM5CTL0 = 0xFFFC; //password
    select_clock_signals(); // Assigns microcontroller clock signals
     assign_pins_to_uart(); // P4.2 is for TXD, P4.3 is for RXD
     use_9600_baud(); // UART operates at 9600 bits/second
     P9OUT &=~BIT7; // turn off LED2
     P9DIR |=BIT7; // set LED2 as output
     UCA0TXBUF = 0x56; // Send the UART message 0x56 out pin P4.2
    P1DIR |= BIT0; //port 1 directed to bit 0
    P1OUT |= BIT0; //port 1 out to bit 1
    P1DIR &=~ BIT1; //set up switch
    P1REN |= BIT1; //enable pull up resistor
    P1OUT |= BIT1;//pullup resistor
    P1DIR &=~ BIT2; //set up switch
    P1REN |= BIT2; //enable pull up resistor
    P1OUT |= BIT2;//pullup resistor
    TA0CTL = TASSEL_1|MC_1; // timer a with ACLK and in up mode
    TA0CCR0=0X2000; //1Hz timer
    TA0CCTL0 |= CCIE; //timer a interrupt enable
    __enable_interrupt(); //GIE inabled
    while(1){};}
#pragma vector =  TIMER0_A0_VECTOR //name vector
__interrupt void TIMER0_A0_INTERRUPT(void) //start ISR
{    if((P1IN&BIT1)==0){
    UCA0TXBUF = 0x56;
    }else{
        UCA0TXBUF = 0x00;
        }
    if((P1IN&BIT2)==0){
    UCA0TXBUF = 0xA3;
    }else{
        UCA0TXBUF = 0x00;
        }

    if(UCA0RXBUF == 0x56){
        //led 1 on
        P1OUT = BIT0;
        }else{
            //led1 off
            P1OUT = 0x00;
            }
        if(UCA0RXBUF == 0xA3){
            //led2 on
            P9OUT = BIT7;
        }else{
            //led2 off
            P9OUT = 0x00;
            }
        UCA0IFG = UCA0IFG & (~UCRXIFG);
}




void select_clock_signals(void)
{
CSCTL0 = 0xA500; // "Password" to access clock calibration registers
CSCTL1 = 0x0046; // Specifies frequency of main clock
CSCTL2 = 0x0133; // Assigns additional clock signals
CSCTL3 = 0x0000; // Use clocks at intended frequency, do not slow them down
}
void assign_pins_to_uart(void)
{
P4SEL1 = 0x00; // 0000 0000
P4SEL0 = BIT3 | BIT2; // 0000 1100
 // ^^
 // ||
// |+---- 01 assigns P4.2 to UART Transmit (TXD)
 // |
// +----- 01 assigns P4.3 to UART Receive (RXD)
}
void use_9600_baud(void)
{
UCA0CTLW0 = UCSWRST; // Put UART into SoftWare ReSeT
UCA0CTLW0 = UCA0CTLW0 | UART_CLK_SEL; // Specifies clock source for UART
UCA0BR0 = BR0_FOR_9600; // Specifies baud rate of 9600
UCA0BR1 = BR1_FOR_9600; // Specifies baud rate of 9600
UCA0MCTLW = CLK_MOD; // "Cleans" clock signal
UCA0CTLW0 = UCA0CTLW0 & (~UCSWRST); // Takes UART out of SoftWare ReSeT
}