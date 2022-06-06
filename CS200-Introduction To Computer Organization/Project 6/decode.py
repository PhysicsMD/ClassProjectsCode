message = input("Enter Your Message:")
baselist = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

endmessage = message.index('=')
message = message[:endmessage]


def expbintodec(binstr):
    inttot = 0
    counter = 7
    for char in binstr:
        if char == "1":
            inttot += pow(2, counter)
        counter -= 1
    return inttot


def messagetoDec(messagestr):
    string = ""
    counter = 0
    while counter < len(messagestr):
        string += '{0:06b}'.format(baselist.index(message[counter]))
        counter += 1
    newstring = ""
    counter = 0
    while counter < int(len(string) / 8):
        newstring += chr(expbintodec(string[counter * 8:counter * 8 + 8]))
        counter += 1
    return newstring


print(messagetoDec(message))
