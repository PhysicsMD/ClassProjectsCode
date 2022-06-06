'''# Lab 1 Mad Libs
# Alenn Wright, Evan Cuillier
# agw73, ejc323
# Created 9/8/2017
# Section 4'''

'''This is our list of variables created for the mad lib form'''
print("Let's do a Mad Lib")
name = input("Input a Name: ")
firstVerb = input("Input a verb ending in 'ing': ")
firstNoun = input("Input a noun: ")
firstAdjective = input("Input an adjective: ")
secondAdjective = input("Input an adjective: ")
secondNoun = input("Input a noun: ")
secondVerb = input("Input a past-tense verb: ")
thirdVerb = input("Input a past-tense verb: ")
bodyPart = input("Input a body part: ")
thirdAdjective = input("Input an adjective: ")
fourthVerb = input("Input a past-tense verb: ")
fifthVerb = input("Input a verb: ")
fourthAdjective = input("Input an adjective: ")
thirdNoun = input("Input a noun: ")
sixthVerb = input("Input a past-tense verb: ")
fifthAdjective = input("Input an adjective: ")
fourthNoun = input("Input a noun: ")
adverb = input("Input an adverb: ")

'''This is the actual Mad lib we created and the resulting form'''
print("\nThere was a goose named " + name + ".")
print("One day it was " + firstVerb + " through the " + firstNoun + ".")
print("For it was not a normal goose, but a(n) " + firstAdjective + " goose.")
print("The " + secondAdjective + " goose came upon a ")
print(secondNoun + " at the lake.")
print("The goose was minding its own business until the ")
print(secondNoun + " had " + secondVerb + " past the goose.")
print("‘Ouch’, " + thirdVerb + " the goose as its ")
print(bodyPart + " was slammed into.")
print("The goose had become " + thirdAdjective + " and ")
print(fourthVerb + " off.")
print("But as the goose tried to " + fifthVerb + " a(n) ")
print(fourthAdjective + " " + thirdNoun + " blocked its path.")
print("The goose had " + sixthVerb + " the " + thirdNoun + " very closely.")
print("However, its anger was soon forgotten as it found a ")
print(fifthAdjective + " " + fourthNoun + " to eat.")
print("And the goose lived " + adverb + 'ly' + " ever after.")
