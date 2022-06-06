#include <iostream>
using std::cin;

int Q = 81;
unsigned char a;
unsigned char b;

int main()
{
    printf("Input an Integer A:");
    cin >> a;
    printf("Input an Integer B:");
    cin >> b;
    a -= 48;
    b -= 48;
    // The result is 00000001
    printf("a = %d, b = %d\n", a, b);
    printf("a&b = %d\n", a & b);

    // The result is 00001101
    printf("a|b = %d\n", a | b);

    // The result is 00001100
    printf("a^b = %d\n", a ^ b);

    // The result is 11111010
    printf("~a = %d\n", a = ~a);
    printf("a >> b = \n");
    printf("a << b = \n");
    return 0;
}
