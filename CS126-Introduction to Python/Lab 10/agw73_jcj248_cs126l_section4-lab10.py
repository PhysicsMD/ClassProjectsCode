'''Alenn Wright and Jace Jenkins
agw73 and jcj248
cs126id = 185 and 139
Casino Night
11/17/17'''


# This function defines the cards suit for the initialization
def suit(x):
    if x <= 12:
        x = "Spades"
    elif x <= 25:
        x = "Hearts"
    elif x <= 38:
        x = "Clubs"
    elif x <= 51:
        x = "Diamonds"
    else:
        print(" Error:Invalid Card Number")
    return x


# This function defines the cards face for the initialization
def rank(a):
    if a in [0, 13, 26, 39]:
        a = "Ace"
    elif a in [10, 23, 36, 49]:
        a = "Jack"
    elif a in [11, 24, 37, 50]:
        a = "Queen"
    elif a in [12, 25, 38, 51]:
        a = "King"
    else:
        if a > 38:
            a -= 38
        elif a > 25:
            a -= 25
        elif a > 12:
            a -= 12
        else:
            a = a+1
        a = str(a)
    return a


# Based on a card rating system this function produces a worth of a card
def value(b):
    if b in [10, 23, 36, 49, 11, 24, 37, 50, 12, 25, 38, 51]:
        b = 10
    if b in [0, 13, 26, 39]:
        b = 11
    else:
        b = b
    return b


# This creates the obejct of each card
class Card:
    def __init__(self, card_num):
        # This initializes each object
        self.rank = rank(card_num)
        self.suit = suit(card_num)
        self.value = value(card_num)
        self.face = "Down"

    def get_suit(self):
        # This returns the suit of a card
        return self.suit

    def get_rank(self):
        # The returns the cards rank
        return self.rank

    def get_value(self):
        # This returns the card value
        return self.value

    def face_down(self):
        # This sets a card facedown
        self.face = "Down"

    def face_up(self):
        # This sets a card faceup
        self.face = "up"

    def __str__(self):
        # This prints the data into a legible line
        if self.face == "Down":
            z = "<Facedown>"
        else:
            z = self.rank + " of " + self.suit
        return z


#This makes the ChipBank for a given person
class ChipBank:
    def __init__(self, amount):
        # This initializes each object
        self.balance = amount

    def withdraw(self, amount):
        # This is a function for taking an amount of money
        if amount > self.balance:
            # This part of the if statement limits overwithdrawls
            return (str(self.balance))
            self.balance = 0
        else:
            # This is a normal withdrawl
            self.balance = int(self.balance) - amount
            return (str(amount))

    def deposit(self, amount):
        # This is a money deposite statement
        a = int(self.balance)
        self.balance = a + amount

    def get_balance(self):
        # This returns money in the account
        return self.balance

    def __str__(self):
        # This prints the data into a legible line
        # a is used as a chip calculator arbitrary number
        a = int(self.balance)
        if a < 1:
            print("You have no chips.")
        else:
            if a >= 100:
                b = a//100
                a -= b*100
            else:
                b = 0
            if a >= 25:
                g = a//25
                a -= g*25
            else:
                g = 0
            if a >= 5:
                r = a//5
                a -= r*5
            else:
                r = 0
            if a >= 1:
                bl = a//1
            else:
                bl = 0
            # This returns the account statement
            return (str(b) + " blacks, " + str(g) + " greens, " +
                    str(r) + " reds, " + str(bl) + " blues - totaling $" +
                    str(self.balance))
