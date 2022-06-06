'''Alenn Wright and Jace Jenkins
agw73 and jcj248
cs126id = 185 and 139
Casino Night
11/17/17'''

def suit(x):
    if x<=12:
        x = "Spades"
    elif x<=25:
        x = "Hearts"
    elif x<=38:
        x = "Clubs"
    elif x<=51:
        x = "Diamonds"
    else:
        print(" Error:Invalid Card Number")
    return x

def rank(a):
    if a in [0,13, 26, 39]:
        a = "Ace"
    elif a in [10, 23, 36, 49]:
        a = "Jack"
    elif a in [11, 24, 37, 50]:
        a = "Queen"
    elif a in [12, 25, 38, 51]:
        a = "King"
    else:
        if a >38:
            a-= 38
        elif a> 25:
            a-= 25
        elif a>12:
            a-= 12
        else:
            a = a+1
        a = str(a)
    return a

def value(b):
    if b in [10, 23, 36, 49 , 11, 24, 37, 50, 12, 25, 38, 51]:
        b = 10
    if b in [0,13, 26, 39]:
        b = 11
    else:
        b = b
    return b

class Card:
    def __init__(self, card_num):
        self.rank = rank(card_num)
        self.suit = suit(card_num)
        self.value = value(card_num)
        self.face = "Down"

    def get_suit(self):
        return self.suit

    def get_rank(self):
        return self.rank

    def get_value(self):
        return self.value

    def face_down(self):
        self.face = "Down"

    def face_up(self):
        self.face = "up"

    def __str__(self):
        if self.face == "Down":
            z = "<Facedown>"
        else:
            z = self.rank + " of " + self.suit
        return z

class ChipBank:
    def __init__(self, amount):
        self.balance = amount
        self = open("output.txt", "a")
        self.logging = "Enable"

    def withdraw(self, amount):
        if amount > self.balance:
            if self.logging == "Enable":
                write("0 -"+str(self.balance))
            else:
                return ""
            return self.balance
            self.balance = 0
        else:
            self.balance = int(self.balance) - amount
            if self.logging == "Enable":
                write(str(self.balance)+" -"+str(amount))
            else:
                return ""
            return amount

    def deposit(self, amount):
        a = int(self.balance)
        self.balance = a + amount
        if self.logging == "Enable":
            write(str(self.balance) + " " + str(amount))
        else:
            return ""

    def get_balance(self):
        return self.balance
    
    def __str__(self):
        a = int(self.balance)
        if a<1:
            print("You have no chips.")
        else:
            if a >= 100:
                b = a//100
                a-=b*100
            else:
                b = 0
            if a>=25:
                g = a//25
                a-=g*25
            else:
                g = 0
            if a>=5:
                r = a//5
                a-= r*5
            else:
                r = 0
            if a>=1:
                bl = a//1
            else:
                bl = 0
            return (str(b) + " blacks, " + str(g) + " greens, "
                    + str(r) + " reds, " + str(bl) + " blues - totaling $"
                    + str(self.balance))
