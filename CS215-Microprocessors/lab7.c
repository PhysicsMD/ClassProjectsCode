#include <msp430.h>
#include <driverlib.h> // Required for the LCD
#include "myGpio.h" // Required for the LCD
#include "myClocks.h" // Required for the LCD
#include "myLcd.h" // Required for the LCD
void main(void)
{
WDTCTL = WDTPW | WDTHOLD; // Watchdog timer stop
TA0CTL |= TASSEL_1 | MC_1 | TACLR;
TA0CCR0 = 0x8000;
// initialize LCD
initGPIO(); // Initializes inputs and outputs for LCD
initClocks(); // Initialize clocks for LCD
myLCD_init(); // Prepares LCD to receive commands
// display
//myLCD_showChar( 'E', 1 ); // Display "E" in space 1
//myLCD_displayNumber(354); // Display the number 354 right justified
int count = 0;
int num = 0;
while(1){
    while(num == 0){
        if(TA0CTL & TAIFG){
            count+=1;
            num += 1;
        }};
    TA0CTL &=~ BIT0;
    num -= 1;
    if(count == 1){
        myLCD_showChar( 'E', 1 );
        myLCD_showChar( 'T', 2 );
        myLCD_showChar( 'H', 3 );
        myLCD_showChar( 'A', 4 );
        myLCD_showChar( 'N', 5 );
       //delay
        while(num == 0){
        if(TA0CTL & TAIFG){
            num += 1;
            myLCD_showChar( ' ', 1 );
            myLCD_showChar( ' ', 2 );
            myLCD_showChar( ' ', 3 );
            myLCD_showChar( ' ', 4 );
            myLCD_showChar( ' ', 5 );
        }};
        TA0CTL &=~ BIT0;
        num -= 1;

    }
    if(count == 2){
        num = 0;
        while(num<7){
            count = 0;
            while(count == 0){
                    if(TA0CTL & TAIFG){
                        count = 1;
                        num += 1;
                    }};
                TA0CTL &=~ BIT0;
                myLCD_displayNumber(num);
        }
        myLCD_showChar( ' ', 6 );
        count = 2;
        num = 0;
        }
    if(count == 3){
        myLCD_showSymbol(LCD_UPDATE, LCD_BATT, 0);
        myLCD_showSymbol(LCD_UPDATE, LCD_BRACKETS, 0);
        count = 0;
        while(num<8){
        while(count == 0){
                if(TA0CTL & TAIFG){
                    count+=1;
                    num += 1;
                }};
            count = 0;
            TA0CTL &=~ BIT0;
            if(num == 1){
                myLCD_showSymbol(LCD_UPDATE, LCD_B1, 0);
            }
            if(num == 2){
                myLCD_showSymbol(LCD_UPDATE, LCD_B2, 0);
            }
            if(num == 3){
                myLCD_showSymbol(LCD_UPDATE, LCD_B3, 0);
            }
            if(num == 4){
                myLCD_showSymbol(LCD_UPDATE, LCD_B4, 0);
            }
            if(num == 5){
                myLCD_showSymbol(LCD_UPDATE, LCD_B5, 0);
            }
            if(num == 6){
                myLCD_showSymbol(LCD_UPDATE, LCD_B6, 0);
            }
            if(num == 7){
                myLCD_showSymbol(LCD_CLEAR, LCD_B1, 0);
                myLCD_showSymbol(LCD_CLEAR, LCD_B2, 0);
                myLCD_showSymbol(LCD_CLEAR, LCD_B3, 0);
                myLCD_showSymbol(LCD_CLEAR, LCD_B4, 0);
                myLCD_showSymbol(LCD_CLEAR, LCD_B5, 0);
                myLCD_showSymbol(LCD_CLEAR, LCD_B6, 0);
                        }}
        myLCD_showSymbol(LCD_CLEAR, LCD_BATT, 0);
        myLCD_showSymbol(LCD_CLEAR, LCD_BRACKETS, 0);
            num = 0;
            count = 0;
        }
    };
}
}