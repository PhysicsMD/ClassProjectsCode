'''Alenn Wright, Mireya Lujan
agw73, msl285
9/22/17
Section 4
Random Math Quiz'''
from random import randint
# Grabbing user input for requirements for the quiz
questions = input("How many Questions do you want to answer?\n")
print("Beginner , Intermediate, Advanced, or Binary Expert")
level = input("What level of questions do you want to solve?\n")
# We set up correct for talling correct answers
correct = 0
# This function below sets up the problem
# This randomly generates numbers for the quiz
# prod is created to make a correct answer
for i in range(int(questions)):
    if level == 'Beginner':
        # This is a begginer tier set of questions
        n1 = randint(1, 10)
        n2 = randint(1, 10)
        timordiv = randint(1, 2)
        if timordiv == 1:
            prod = n1 + n2
        elif timordiv == 2:
            prod = n1 - n2
    elif level == 'Intermediate':
        # This is a Intermediate tier set of questions
        n1 = randint(1, 25)
        n2 = randint(1, 25)
        timordiv = randint(1, 4)
        if timordiv == 1:
            prod = n1 + n2
        elif timordiv == 2:
            prod = n1 - n2
        elif timordiv == 3:
            prod = n1 * n2
        elif timordiv == 4:
            div = float(int(n1 / n2))
            prod = round(div, 2)
    elif level == 'Advanced':
        # This is a Advanced tier set of questions
        n1 = randint(1, 10)
        n2 = randint(1, 10)
        timordiv = randint(5, 9)
        if timordiv == 5:
            prod = n1**n2
        elif timordiv == 6:
            prod = n1 % n2
        elif timordiv == 7:
            prod = n1 * n2**n2
        elif timordiv == 8:
            prod = n1
            n2 = n1 + 7
        elif timordiv == 9:
            prod = n1
            n2 = (n1**3) - 4
    elif level == 'Binary Expert':
        # This is a bordom question
        n1 = randint(0, 1)
        n2 = randint(0, 1)
        n3 = randint(0, 1)
        n4 = randint(0, 1)
        n5 = randint(0, 1)
        n6 = randint(0, 1)
        n7 = randint(0, 1)
        n8 = randint(0, 1)
        prod = (n8*128)+(n7*64)+(n6*32)+(n5*16)+(n4*8)+(n3*4)+(n2*2)+(n1*1)
        timordiv = 10
    else:
        # This code is in place incase the level is witten wrong
        print("Something went wrong")
    if timordiv == 1:
        # This is the addition input and analysis function
        ans = input("What's %d plus %d? " % (n1, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 2:
        # This is the subtraction input and analysis function
        ans = input("What's %d minus %d? " % (n1, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 3:
        # This is the multiplication input and analysis function
        ans = input("What's %d times %d? " % (n1, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 4:
        # This is the division input and analysis function
        ans = round(float(input("What's %d divided by %d? " % (n1, n2))), 2)
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %f.\n" % prod)
    elif timordiv == 5:
        # This is the exponential input and analysis function
        ans = input("What's %d to the %d power? " % (n1, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 6:
        # This is the remainder input and analysis function
        ans = input("What's %d divided by %d 's remainder? " % (n1, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 7:
        # This is the equation input and analysis function
        ans = input("What's %d times %d^%d? " % (n1, n2, n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 8:
        # This is an algerbra question function
        ans = input("What's x equal to if x + 7 = %d? " % (n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 9:
        # This is an Quadratic function question
        ans = input("What's x equal to if x^3-4=%d? " % (n2))
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    elif timordiv == 10:
        # This is a Binary Conversion question
        func = (n8, n7, n6, n5, n4, n3, n2, n1)
        ans = input("Convert %d%d%d%d%d%d%d%d to Decimal? " % func)
        if int(ans) == prod:
            print("That's right -- well done.\n")
            correct = correct + 1
        else:
            print("No, I'm afraid the answer is %d.\n" % prod)
    else:
        print("Woops")
# This part of the code prints the quiz results
print("\nI asked you " + questions + " Questions.")
print("You got %d of them right." % correct)
# This is the response to results module
if int(correct) / int(questions) >= 2/3:
    print ("Well done!")
elif int(correct) / int(questions) >= 1/3:
    print("You need more practice...")
else:
    print("Please ask your teacher for help")
