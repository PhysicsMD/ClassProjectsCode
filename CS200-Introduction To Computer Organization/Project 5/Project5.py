import struct
signflag = ""
input1 = float(input("Enter a real number: "))


def testsign(instr): 
    if instr == "0":
        return "(positive)"
    else:
        return "(negative)"


def floatstring(fltstr):
    finstr = ""
    counter = 1
    for char in fltstr:
        counter *= 2
        if char == "1":
            finstr += " + (1/" + str(counter) + ")" 
    return finstr


def expbintodec (binstr):
    inttot = 0
    counter = 7
    for char in binstr:
        if char == "1":
            inttot += pow(2, counter) 
        counter -= 1 
    return inttot


def binary(num):
    return ''.join('{:0>8b}'.format(c) for c in struct.pack('!f', num))


print("") 
print("Float Analysis") 
print("  " + "Bit Pattern:" + "   " + binary(input1)[0] + " " + binary(input1)[1:9] + " " + binary(input1)[9:])
print("                 "+ "S" +" "+ "Exponent" +" "+ "Significand/Mantissa")


if input1 == 0:
    print(" "+"This is the special pattern for " + testsign(binary(input1)[0])[1:9])
else:
    print("")
    print("  "+"Sign:"+"          "+binary(input1)[0]+" "+testsign(binary(input1)[0]))
    print("  "+"Exponent:"+"      "+binary(input1)[1:9]+" = "+str(expbintodec(binary(input1)[1:9]))+"; w/bias 127 -> (" +
          str(expbintodec(binary(input1)[1:9])) + "-127) = " + str(expbintodec(binary(input1)[1:9])-127))
    print("  "+"Significand:"+"   "+ binary(input1)[9:])
    print("    "+"w/implied 1:"+" "+"1."+binary(input1)[9:])
    print("")
    print("  "+"Combined:"+"      "+"+ [1."+binary(input1)[9:]+"] * 2^"+str(expbintodec(binary(input1)[1:9])-127))
    print("    "+"or:"+"          "+"+ [1"+floatstring(binary(input1)[9:])+"] * 2^"+str(expbintodec(binary(input1)[1:9])-127))
