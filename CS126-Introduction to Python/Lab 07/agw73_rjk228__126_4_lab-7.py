'''Lab 7 - Game Show
Ryan Kelly, Alenn Wright
Rjk228, Agw73
27 October 2017
Section 4'''

# imptort random to shuffle our questions
import random


# define a function to allow the user to view the highscores
def view_high_scores(current_high_scores):
    # check to see if the hischore is something other than 0,
    # and if it is, print the high scores
    if int(current_high_scores[-1][0]):
        # adds spacing for visual appeal
        print('\n\n\n')
        # next four lines print the highscores
        print("The Current high scores are:")
        print("#1:", current_high_scores[-1])
        print("#2:", current_high_scores[-2])
        print("#3:", current_high_scores[-3])
        # adds spacing for visual appeal
        print('\n\n\n')

    # if there are no highscores, tell the player
    else:
        # adds spacing for visual appeal
        print('\n\n\n')
        print("Their are no high scores")
        print("You can be the first to set one!!")
        # adds spacing for visual appeal
        print('\n\n\n')

    # return to the main menu
    main_menu(current_high_scores)


# define a function to display the credits
def roll_credits(current_high_scores):
    # adds spacing for visual appeal
    print('\n\n\n')
    # next three lines are the amazing credits
    print("This Amazing Jeoprody game was created \
by Ryan Kelly and Alenn Wright!")
    print("So are you enjoying these amazing credits?")
    print("If yes, sorry, because here is the main menu!")
    # adds spacing for visual appeal
    print('\n\n\n')
    # return to main menu
    main_menu(current_high_scores)


# defines our main menu funciton
def main_menu(current_high_scores, name='', score=0,):

    # next two lines are a bit of hish score formatting management
    current_high_scores.append(str(score) + ", " + name)
    current_high_scores.sort()

    # welcome the player to the game
    print("Hello! Welcome to the Jeoprody menu!")

    # Ask the player if they want to play the game
    start = input("Do you want to be a winner?!?!(Yes or No)")
    # normalize the user input
    start = start.lower()

    # if the player is reasdy to play, prompt them for their
    # name so their score can be added to the highscores
    # and then call the game function
    if start == "yes":
        # get name for highscore
        name = input("What is your name?")
        # start game
        main_game(current_high_scores, name)

    # if the player is not ready to play, give them the
    # option to view the credits, the highscores or just return to the menu
    elif start == "no":

        # add a line for visual appeal
        print()
        # reassure the player of their life choice
        # (to not play this amazing game)
        print("Well That's fine")
        # promt the player to view highscores, credits or return to menu
        new_input = input("Would you like to view high scores then?(View) \
\nOr do you want to see the amazing credits?(Credits) \
\nOr just return to the main menu?(menu)\
\nOr do you want to quit?(quit)")
        # check if player's response is valid, if not,
        # ask them again what they want to do
        while(new_input.lower() != "view" and
              new_input.lower() != "credits" and
              new_input.lower() != "menu" and
              new_input.lower() != "quit"):
            # tell the player thier response was invalid
            print("Sorry, I could not understand that.")
            # Ask them again what they want to do
            new_input = input("Would you like to view high scores then?(View) \
\nOr do you want to see the amazing credits?(Credits) \nOr just return to the \
main menu?(menu)")
        # if user wants to view highscores call the highscores function
        if new_input.lower() == "view":
            view_high_scores(current_high_scores)
        # or if they want to see the creddits, call the roll credits function
        elif new_input.lower() == "credits":
            roll_credits(current_high_scores)
        # or if they want to quit, just let em go
        elif new_input.lower() == "quit":
            print("Thanks for playing!!")
            return
        # otherwise, return to the main menu
        else:
            main_menu(current_high_scores)
        # adds spacing for visual appeal
        print()
        print()
        main_menu(current_high_scores)
    else:
        # adds spacing for visual appeal
        print()
        print("That was not an option?")
        print()
        print()
        main_menu(current_high_scores)


# define the actual game function
def main_game(current_high_scores, current_name):

    # initialize the score to 0
    current_score = 0
    # define the list of dictionaries of your question, in the form:
    # [{"Question": "the question", "Answer": ["answer1", "answer2", "etc"],
    # "Correct Answer":"answer1"}]
    game_probs = [{"Question": "Which is the only state to begin with \
the letter 'p'?",
                   "Answer": ["Pennsylvania", "pancreas", "Neverland"],
                   "Correct Answer": "Pennsylvania"},

                  {"Question": "Name the world's biggest island",
                   "Answer": ["Greenland", "Whiteland", "Iceland"],
                   "Correct Answer": "Greenland"},

                  {"Question": "What is the world's longest river?",
                   "Answer": ["Amazon", "Missisipi", "Colorado"],
                   "Correct Answer": "Amazon"},

                  {"Question": "Name the world's largest ocean",
                   "Answer": ["Pacific", "Atlantic"],
                   "Correct Answer": "Pacific"},

                  {"Question": "What is the diameter of Earth",
                   "Answer": ["8,000 miles", "2 feet"],
                   "Correct Answer": "8,000 miles"},

                  {"Question": "Where would you find the world's most \
ancient forest?",
                   "Answer": ["Daintree forest north of cairns",
                              "Your backyard"],
                   "Correct Answer": "Daintree forest north of cairns"},

                  {"Question": "Which four British cities have \
underground rail systems?",
                   "Answer": ["Liverpool", "Glasgow", "Newcastle",
                              "London"],
                   "Correct Answer": "Liverpool"},

                  {"Question": "What is the capital city of Spain?",
                   "Answer": ["Madrid", "Meca"],
                   "Correct Answer": "Madrid"},

                  {"Question": "Which country is Prague in?",
                   "Answer": ["Czech republic", "Moscow"],
                   "Correct Answer": "Czech Republic"},

                  {"Question": "Which English town was a forerunner of \
the parks movement and the first city in Europe to have a street tram system",
                   "Answer": ["Birkenhead", "Lukemia"],
                   "Correct Answer": "Birkenhead"}]

    # shuffle the questions to ensure a random ordering.
    random.shuffle(game_probs)

    # create a for loop that loops through
    # each dictionary in the list of questions
    for question in game_probs:
        # print the question
        print(question["Question"])
        # shuffle the question anaswers
        random.shuffle(question["Answer"])
        # initialize an empty string to use for displaying the possible answers
        disp_Q_string = ""
        # loop through each possible answer for this question
        for answers in question["Answer"]:
            # append a formatted list of the choices to the diplay string
            disp_Q_string = disp_Q_string + "is it: \
" + answers.capitalize() + " or "
        # remove the unneccesary "or"
        disp_Q_string = disp_Q_string[0:-3]
        # print the choices
        print(disp_Q_string, "\n")
        # get the user's answer
        user_answer = input("What is....").capitalize()
        # check to make sure the user's answer
        # is not one of the options
        while(user_answer.capitalize() not in question["Answer"]):
            # print the question and ask the user for another response
            print("Sorry, that is not a valid option, try again: \n")
            print(question["Question"])
            print(disp_Q_string, "\n")
            user_answer = input("What is....").capitalize()
        # check if the player got the question right
        if user_answer.capitalize() == question["Correct Answer"].capitalize():
            # if they got it right, add a point to their score
            current_score += 1
            # compliment the player for their intelligence
            print("Great Job!!")
        else:
            # if they got it wrong, tell them
            print("Unfortunately that is wrong!")
            # and subtract a point from their score
            current_score -= 1
        # print the player's score
        print("Your score is currently ", current_score)

    # now that we've looped through all the qustions,
    # tell the user their score
    # and return to the menu
    print()
    print("That's all folks!")
    print("Wow your final score is ", current_score)
    print("Returning to menu")
    print()
    print()

    # This call saves the highscores
    main_menu(current_high_scores, current_name, current_score)


# defines our main function
def main():
    # initializes high scores to 0
    high_scores = ["0, ", "0, ", "0, "]
    # go to the menu of the game
    main_menu(high_scores)

# call main()
main()
