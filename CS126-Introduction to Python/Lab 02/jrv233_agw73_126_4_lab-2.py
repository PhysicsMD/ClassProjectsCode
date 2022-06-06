""" Lab 2 Gamebook I
Joseph Vargovich, Alenn Wright
09/15/2017
Section 4 """
# Here we print the title and exposition to the console.
print("Pikachu's bizarre adventure, on Mars.-Sponsored by Mars Bars")
print("You take the role of Pikachu,")
# This is our first choice for the user, seperated into two statements.
print("Your Pokemon trainer is guiding you to the Pokemon daycare on Mars.")
first = input("Do you enter the daycare EXCITED or SCARED?")
# Here we have the begininng of several conditionals to process the input
if first == 'EXCITED':
    # This code runs if the user chooses the EXCITED option
    print("You run into the daycare, realizing there is a Mars tree outside!")
    second = input("However, do you go out to the tree? YES or NO?")
    # This code runs if the user chooses YES, notice the nested format.
    if second == 'YES':
        print('You see majestic Mars Bars fruit growing from the tree.')
        third = input("Do you TAKE them or LEAVE them?")
        # This code runs if the user selects TAKE
        if third == 'TAKE':
            fourth = int(input("How many Mars Bars did you really take?"))
            # If the user's input is greater than or equal to 9, run this.
            if fourth >= 9:
                print("You are stoned outta your mind ")
                print("until your trainer comes back.")
            # If the user's input is less than 9, run this.
            elif fourth < 9:
                print("You see funny colors and tell weird stories,")
                print("You seem ok...")
            # A catch all for invalid values.
            else:
                print("I know you want a Mars Bar,")
                print("But you will never quite get one...")
    # Indentation is vital here, as this is still tied with second.
    elif second == ('NO'):
        print("You sit in the corner of the day care,")
        print("someone offers you a Mars Bar.")
        third = input("Do you TAKE it or LEAVE it?")
        # This code runs if the user chooses TAKE
        if third == 'TAKE':
            print("You succumb to peer pressure and eat the Mars Bar")
            print("You then evolve into a flying goat")
            print("and await your trainer's return.")
        # This code runs if the user inputs anything other than TAKE
        else:
            print("Let's be honest, your gonna take it and eat it")
            print("You evolve into a flying goat until you trainer's return.")
    # This is our catch all for the conditional on variable second.
    else:
        print('You are already high on Mars Bars')

elif first == 'SCARED':
    #The following code runs if SCARED is entered
    print("You hide in a corner underneath a shelf.")
    print("A trainer finds you and offers you a bizzare object.")
    second = input("Do you INVESTIGATE or ATTACK the trainer?")
    #We created an input for the next string leading to other events
    if second == 'INVESTIGATE':
        #This code below is if INVESTIGATE is selected leading to var third
        print("You reach out and see in the trainer's hand, a Mars Bar.")
        print("Will you SAVE it for your trainer,")
        third = input("or DISTRIBUTE it to your fellow Pokemon?")
        #This variable creates the last option for this section of the tree
        if third == 'SAVE':
            #This is a possible end string
            print("Upon the arrival of your trainer, you give him a Mars Bar.")
            print("He eats it, and transforms into a minature narwhal.")
        elif third == "DISTRIBUTE":
            #This is a possible end string
            print("Congratulations, you have sucessfully jumpstarted your-")
            print("career in Mars Bars dealing.")
            print("Enjoy making everyone happy... very happy.")
        else:
            #This is a possible end string if no option was selected
            print("The trainer ate you.")
    elif second == 'ATTACK':
        #This is the resulting tree if ATTACK was selected
        print("You bite the trainer, causing you to evolve into a flying goat")
        print("Will you EVOLVE or REJECT the")
        third = input("transformation into goatkind?")
        if third == 'EVOLVE':
            #This is a possible end string
            print("You now teleport to the world of Goat Simulator")
            print("Where you live the rest of your days eating grass")
        elif third == 'REJECT':
            #This is a possible end string
            print("Your Trainer figured out you could evolve to a Goat")
            print("then sued the daycare for not providing expected results")
        else:
            #This is a possible end string if no option was selected
            print("You have now become the worst meme ever, The Nyan Cat")
else:
    #WOT
    #This is a commical all else fails response
    print("Wot")
