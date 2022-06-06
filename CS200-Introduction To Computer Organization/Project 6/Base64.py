def expbintodec(binstr):
    inttot = 0
    counter = 7
    for char in binstr:
        if char == "1":
            inttot += pow(2, counter)
        counter -= 1
    return inttot


def binaryDump(stringmsg):
    dump = ""
    counter = 0
    while counter < len(stringmsg):
        placers = "0" * (8-len(bin(ord(stringmsg[counter]))[2:]))
        dump += placers
        dump += bin(ord(stringmsg[counter]))[2:]
        dump += "\t"
        counter += 1
        if counter%4 == 0:
            dump += "\n\t\t\t\t "
    return dump


def binaryDump6(stringmsg):
    dump = ""
    counter = 0
    while counter < len(stringmsg):
        placers = "0" * (8 - len(bin(ord(stringmsg[counter]))[2:]))
        dump += placers
        dump += bin(ord(stringmsg[counter]))[2:]
        counter += 1
    counter = 0
    spaceddump = ""
    fillcounter = -len(dump)
    while fillcounter < 0:
        fillcounter += 24
    while counter < len(dump):
        spaceddump += dump[counter:counter+6]
        if counter < len(dump)-6:
            spaceddump += "\t"
        counter += 6
        if counter%24 == 0:
            spaceddump += "\n\t\t\t\t "
    while fillcounter%6 > 0:
        spaceddump += "x"
        fillcounter -= 1;
    spaceddump += "\t"
    while fillcounter > 0:
        spaceddump += "xxxxxx\t"
        fillcounter -= 6;
    return spaceddump


def AsciiDump(stringmsg):
    total_string = ""
    linecounter = 0
    while(linecounter <= len(stringmsg)-1):
        iterationcounter = 0
        while iterationcounter != 4:
            total_string += stringmsg[(linecounter + iterationcounter)]
            total_string += " = $"
            total_string += (hex(ord(stringmsg[(linecounter + iterationcounter)]))[2:]).upper()
            total_string += "     "
            iterationcounter += 1
            if (linecounter + iterationcounter) > len(stringmsg)-1:
                iterationcounter = 4
        linecounter += 4
        if linecounter < len(stringmsg):
            total_string += "\n\t\t\t\t "
    return total_string


def expbintodec(binstr):
    inttot = 0
    counter = 5
    for char in binstr:
        if char == "1":
            inttot += pow(2, counter)
        counter -= 1
    return inttot


def to_base_10(stringmsg):
    dump = ""
    counter = 0
    zero_counter = 24-(len(stringmsg)*8)%24
    nacounter = zero_counter/6
    while counter < len(stringmsg):
        placers = "0" * (8 - len(bin(ord(stringmsg[counter]))[2:]))
        dump += placers
        dump += bin(ord(stringmsg[counter]))[2:]
        counter += 1
    counter = 0
    decstr = ""
    while counter < len(dump):
        decstr += str(expbintodec(dump[counter:counter+6]))
        decstr += "\t"
        counter += 6
    while nacounter > 1:
        decstr += "N/A\t"
        nacounter -= 1
    return decstr


baselist = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"


def base64_string(stringmsg):
    dump = ""
    counter = 0
    zero_counter = 24-(len(stringmsg)*8)%24
    nacounter = zero_counter/6
    while counter < len(stringmsg):
        placers = "0" * (8 - len(bin(ord(stringmsg[counter]))[2:]))
        dump += placers
        dump += bin(ord(stringmsg[counter]))[2:]
        counter += 1
    counter = 0
    decstr = ""
    while counter < len(dump):
        decstr += baselist[expbintodec(dump[counter:counter+6])]
        counter += 6
    while nacounter > 1:
        decstr += "="
        nacounter -= 1
    return decstr


message = input("Enter Your Message:")
print("")
print("Original data:   " + message)
print("")
print("ASCII codes:     " + AsciiDump(message))
print("In binary:       " + binaryDump(message))
print("")
print("Groups of 8:     " + binaryDump(message))
print("")
print("Groups of 6:     " + binaryDump6(message))
print("")
print("In base 10:      " + to_base_10(message))
print("")
print("Base64 Output:   " + base64_string(message))
