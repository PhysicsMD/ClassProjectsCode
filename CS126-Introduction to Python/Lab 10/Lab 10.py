class Card:
    '''
    This is the header for the class Card.
    Any new card objects created will use the Card(card_num) method, which will be used
    to create card objects with a suit, rank, and value. Cards start facing down.
    '''
    # class member variables - shared by all objects.
    suits = ["Spades", "Hearts", "Clubs", "Diamonds"]
    ranks = ["Jack", "Queen", "King"]
    
    def __init__(self, card_num):
        '''
            __init__ will be run whenever a new card object is created
            ie: Card() is executed.
            Takes in 2 parameters, card_num(any number between 0 and 51)
                                 , self(giving the object the ability to call it's own methods)
        '''
        # Sets the Card's instance variables:
        # Cards start facing down
        self._facing_up = False
        
        # Sets its "suit" using the shared suits list. 
        # Integer division of the initial card num determines the suit.
        # 1-13 spades, 14-26 hearts, 27-39 clubs, 40-52 diamonds
        self._suit = Card.suits[card_num // 13]
        
        # Use modules 13 to determine the card's "rank" (e.g., Ace, King, Queen, Jack, 1, 2, ...)
        #  and point "value" (2-10,11)
        num = card_num % 13
        # If num%13 == 0, its an Ace.
        if num == 0:
            self._rank = "Ace"
            self._value = 11
        # Jack if 10, Queen if 11, King if 12
        elif num in [10, 11, 12]:
            self._rank = Card.ranks[num-10] #access shared rank list to set ranks of J, Q, and K
            self._value = 10
        # Else rank and value is it's number +1 (card 1, refers to 2 of spades worth 2 points)
        else:
            self._rank = str(num + 1)
            self._value = num + 1

    # a "getter" for the suit type. Returns the string value of the suit
    def get_suit(self):
        return self._suit

    # a "getter" for the rank, returns string of rank
    def get_rank(self):
        return self._rank

    # value getter, returns int value
    def get_value(self):
        return self._value
        
    # facing_up getter, return boolean
    def get_face_up(self):
    	return self._facing_up
        
    # setters for rank, value, and suit are not implemented since card suits, values and ranks cannot be changed. 
    # two setters are implements for "facing up " attribute, face_down() and face_up()
    
	# turns card face down
    def face_down(self):
        self._facing_up = False
        
    # turns card face_up
    def face_up(self):
        self._facing_up = True
        
    # Overwrites the built-in str() function for the Card class
    # Without it the print method would simply print the "memory address" of the object
    # With it, if the card is facing up it prints its rank and suit, else it prints "<facedown>"
    def __str__(self):
        # If the card is facing up, print rank of suit
        if self._facing_up:
            return self._rank + " of " + self._suit
        # If face down print <facedown>
        else:
            return "<facedown>"


class ChipBank():
    '''
    Header for class ChipBank
    Used to store a dollar amount
    '''
    # Initializes the chipbank with a dollar value
    def __init__(self, value):
        self._value = value

    # Tries to withdraw the amount from the current saved value.
    # If one tries to with draw more than they have, they will only get as much as they have.
    # Returns the total amount withdrawn (the amount asked for, or the total amount they had)
    def withdraw(self, amount):
        total = self._value
        self._value -= amount
        if self._value < 0:
            self._value = 0
            return total  # returns original balance
        return amount   # only return amount if they had enough to take it all

    # adds amount to total value and saves it
    def deposit(self, amount):
        self._value += amount

    # returns the total value of bank
    def get_balance(self):
        return self._value

    # Overwrites the built in str() function for the ChipBank class.
    # Prints the amount and types of chips stored in bank
    def __str__(self):
        return "%d blacks, %d greens, %d reds, %d blues - totaling $%d" % (self._value // 100,
                                                                           self._value % 100 // 25,
                                                                           self._value % 25 // 5,
                                                                           self._value % 5,
                                                                           self._value)


# Main method to run tests
def main():
    # Creates one of each card and prints it in order
    for i in range(52):
        card = Card(i)
        card.face_up()
        print(card)
    print("")

    # Tests card 37 is stored correct
    card = Card(37)
    print(card)
    # <facedown>
    print(card.get_value())
    # 10
    print(card.get_suit())
    # Clubs
    print(card.get_rank())
    # Queen
    card.face_down()
    print(card)
    # <facedown>
    card.face_up()
    print(card)
    # QueenofClubs

    # Creates Chip Bank and tests
    cs = ChipBank(149)
    print(cs)
    # 1blacks,1greens,4reds,4blues totaling$149
    cs.deposit(7)
    print(cs.get_balance())
    # 156
    print(cs)
    # 1blacks,2greens,1reds,1blues totaling$156
    print(cs.withdraw(84))
    # 84
    print(cs)
    # 0blacks,2greens,4reds,2blues totaling$72
    cs.deposit(120)
    print(cs)
    # 1blacks,3greens,3reds,2blues totaling$192
    print(cs.withdraw(300))
    # 192


if __name__ == "__main__":
    '''
    This line of code checks to see if this file is being run directly.
    If it is, it executes the main method.
    
    If this file is being inherited by another, it will instead
    allow each class to be used by the other file but will not 
    run the main method of this file.
    '''
    main()
