'''Alenn Wright and Holden Dones
hsd32 & agw73
ID# 222 & 185
Lab 12'''

from lab10_Answer_Key_MV import Card, ChipBank
import random


class BlackjackHand():
    def __init__(self):
        # Initializes the list of cards for a hand
        self.cards = []

    def add_card(self, new_card):
        # Adds 1 card to hand list
        self.cards.append(new_card)

    def __str__(self):
        # Creates basic output for cards in hand
        hand_string = ""
        for c in self.cards:
            hand_string += Card(c).get_rank() + " of " + Card(c).get_suit()
            hand_string += ", "
        return hand_string

    def get_value(self):
        # This function returns the had value in a string
        # with reguarts to the ace
        hand_value = 0
        for c in self.cards:
            hand_value += int(Card(c).get_value())

            if hand_value > 21:
                for c in self.cards:
                    if Card(c).get_rank() == "Ace":
                        hand_value = hand_value - 10
        return str(hand_value)


class Blackjack:
    def __init__(self, starting_dollars):
        # Initializes and shuffles the deck
        self.deck = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                     17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                     31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
                     45, 46, 47, 48, 49, 50, 51]
        random.shuffle(self.deck)
        # Setting bank/money instances
        self.bank = ChipBank(starting_dollars)
        self.money_value = starting_dollars

        self.active = True

    def draw(self):
        # This grabs and gives a random card removing it from the deck
        if len(self.deck) == 0:
            self.deck = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                         16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
                         29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
                         42, 43, 44, 45, 46, 47, 48, 49, 50, 51]
            random.shuffle(self.deck)
        self.new_card = self.deck[0]
        del self.deck[0]
        return self.new_card

    def start_hand(self, wager):
        # Game start
        self.wager = wager
        self.bank = ChipBank(self.money_value)
        self.players_hand = BlackjackHand()
        self.dealers_hand = BlackjackHand()
        self.players_hand.add_card(self.draw())
        self.players_hand.add_card(self.draw())
        self.dealers_hand.add_card(self.draw())
        self.dealers_hand.add_card(self.draw())
        self.money_value -= wager
        print("Your starting hand: " + str(self.players_hand))
        print("Dealers starting hand: " + str(self.dealers_hand))
        # Test to see if game has already been won
        if (self.players_hand.get_value() and self.dealers_hand.get_value()) ==
        21:
            self.end_hand("push")
        elif self.players_hand.get_value() == 21:
            self.end_hand("win")
        self.active = True

    def hit(self):
        if self.active() is True:
            self.players_hand.add_card(self.draw())
            if self.players_hand.get_value() > 21:
                self.end_hand("lose")
            elif self.players_hand.get_value() == 21:
                self.stand()

    def stand(self):
        if self.active() is True:
            while self.dealers_hand.get_value() <= 16:
                self.dealers_hand.add_card(self.draw())
                print("Dealer draws a " + str(self.dealers_hand[-1]))
                print("Dealer's is now "+str(self.dealers_hand))
                if self.dealers_hand.get_value > 21:
                    self.end_hand("win")
            else:
                if self.players_hand.get_value() >
                self.dealers_hand.get_value():
                    self.end_hand("win")
                elif self.players_hand.get_value() ==
                self.dealers_hand.get_value():
                        self.end_hand("push")
                else:
                    self.end_hand("lose")

    def end_hand(self, outcome):
        if outcome == "win":
            self.money_value += self.wager*2
            print("Player wins!")
        elif outcome == "push":
            self.money_value += self.wager
            print("It's a push")

        self.players_hand = []
        self.dealers_hand = []
        self.wager = 0
        self.active = False


if __name__ == "__main__":
    blackjack = Blackjack(250)
    while blackjack.bank.get_balance() > 0:
        print ("Your remaining chips : "+str(blackjack.bank))
        wager = int(input("How much would you like to wager? "))
        blackjack.start_hand(wager)
        while blackjack.active():
            choice = input("STAND or HIT: ").upper()
            if choice == "STAND":
                blackjack.stand()
            elif choice == "HIT":
                blackjack.hit()
        print ()
    print ("Out of money! The casino wins!")
