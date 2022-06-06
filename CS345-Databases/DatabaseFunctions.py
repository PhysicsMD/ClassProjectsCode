import os
import sqlite3


def createdatabase():
    if dbexists():
        print("Table exits")
    else:
        open("pokemon.db", "x")
        initializetables()


def restartdatabase():
    open("pokemon.db", "x")
    initializetables()


def dbexists():
    return os.path.exists('pokemon.db')


def initializetables():
    DB.execute('''CREATE TABLE Pokedex (Pokedex_No int, Name text, Type text)''')
    DB.execute('''CREATE TABLE Weakness (Type text, Weaknesses text)''')
    DB.execute(
        '''CREATE TABLE Stats (Name text, Total int, HP int, Attack int, Defense int, Sp_Atk int, Sp_Def int, Speed int)''')


def addpokemon():
    print('What is the pokemon name: ')
    name = input()
    statsvalues = "'" + name + "',"
    print('What is the pokemon entry number: ')
    num = int(input())
    pokedexvalues = "'" + str(num) + "',"
    pokedexvalues += "'" + name + "',"
    print('What is the Total Stat: ')
    total = int(input())
    statsvalues += "" + str(total) + ","
    print('What is the HP Stat: ')
    hp = int(input())
    statsvalues += "" + str(hp) + ","
    print('What is the Attack Stat: ')
    atk = int(input())
    statsvalues += "" + str(atk) + ","
    print('What is the Defense Stat: ')
    defe = int(input())
    statsvalues += "" + str(defe) + ","
    print('What is the Sp.Atk Stat: ')
    satk = int(input())
    statsvalues += "" + str(satk) + ","
    print('What is the Sp.Def Stat: ')
    sdef = int(input())
    statsvalues += "" + str(sdef) + ","
    print('What is the Speed Stat: ')
    spd = int(input())
    statsvalues += "" + str(spd)
    print('Do they have "1" or "2" Types: ')
    types = int(input())
    typelist = ['Normal', 'Fire', 'Water', 'Grass', 'Electric', 'Ice', 'Fighting', 'Poison', 'Ground', 'Flying',
                'Psychic', 'Bug', 'Rock', 'Ghost', 'Dark', 'Dragon', 'Steel', 'Fairy']
    print(
        'The types are "Normal","Fire","Water","Grass","Electric","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dark","Dragon","Steel", or "Fairy"')
    if types == 1:
        print('What is the pokemon type :')
        newtype1 = input()
        if newtype1 in typelist:
            typestring = newtype1 + " " + "null"
        else:
            print('Invalid Selection')
    elif types == 2:
        print('What is the pokemons first type :')
        newtype1 = input()
        if newtype1 in typelist:
            print('What is the pokemons second type :')
            newtype2 = input()
            if newtype2 in typelist:
                typestring = newtype1 + " " + newtype2
            else:
                print('Invalid Selection')
        else:
            print('Invalid Selection')
    else:
        typestring = "null null"
        print('Invalid Selection')
    pokedexvalues += "'" + typestring + "'"
    DB.execute("INSERT INTO Pokedex VALUES (" + pokedexvalues + ")")
    DB.execute("INSERT INTO Stats VALUES (" + statsvalues + ")")


def removepokemon():
    print('Would you like to remove a pokemon based on Name or Pokedex Number (Answer "Name" or "Num"): ')
    selection = input()
    if selection == "Num":
        print('Enter the Number: ')
        Num = int(input())
        if checkifnumexists(Num):
            Name = DB.execute("SELECT Name FROM Pokemon WHERE Pokedex_No = '" + str(Num) + "'")
            DB.execute("DELETE FROM Pokemon WHERE Name = '" + Name + "'")
            DB.execute("DELETE FROM Stats WHERE Name = '" + Name + "'")
            print('Entry Removed')
        else:
            print('Invalid Selection')
    elif selection == "Name":
        print('Enter the Name: ')
        Name = input()
        if checkifnameexists(Name):
            DB.execute("DELETE FROM Pokemon WHERE Name = '" + Name + "'")
            DB.execute("DELETE FROM Stats WHERE Name = '" + Name + "'")
            print('Entry Removed')
        else:
            print('Invalid Selection')
    else:
        print('Invalid nSelectio')


def updatepokemon():
    print('Would you like to update a pokemon based on Name or Pokedex Number (Answer "Name" or "Num"): ')
    selection = input()
    if selection == "Num":
        print('Enter the Number: ')
        Num = int(input())
        if checkifnumexists(Num):
            Name = DB.execute("SELECT Name FROM Pokemon WHERE Pokedex_No = '" + str(Num) + "'")
            updatepokemonbyname(Name)
        else:
            print('Pokemon does not exist')
    elif selection == "Name":
        print('Enter the Name: ')
        Name = input()
        if checkifnameexists(Name):
            updatepokemonbyname(Name)
        else:
            print('Pokemon does not exist')
    else:
        print('Pokemon does not exist')


def updatepokemonbyname(Pokemon_Name):
    print('Do you want to update "Stats" or Name, No or Types (enter "Entry"): ')
    selection = input()
    if selection == "Stats":
        print('Do you want to update Total, HP, Attack, Defense, Sp_Atk, Sp_Def, or Speed: ')
        selection = input()
        if selection in ['Total', 'HP', 'Attack', 'Defense', 'Sp_Atk', 'Sp_Def', 'Speed']:
            print('What would you like the new value to be: ')
            newValue = int(input())
            DB.execute(
                "UPDATE Stats Set " + selection + " = '" + str(newValue) + "' WHERE Name = '" + Pokemon_Name + "'")
        else:
            print('Invalid Selection')
    elif selection == "Entry":
        print('Do you want to update Name, Pokedex_No, or Types: ')
        selection = input()
        if selection == 'Name':
            print('What would you like the new Name to be: ')
            newName = input()
            DB.execute(
                "UPDATE Pokedex Set " + selection + " = '" + newName + "' WHERE Name = '" + Pokemon_Name + "'")
            DB.execute(
                "UPDATE Stats Set " + selection + " = '" + newName + "' WHERE Name = '" + Pokemon_Name + "'")
        elif selection == 'Pokedex_No':
            print('What would you like the new Number to be: ')
            newIndex = int(input())
            DB.execute(
                "UPDATE Pokedex Set " + selection + " = '" + str(newIndex) + "' WHERE Name = '" + Pokemon_Name + "'")
        elif selection == 'Types':
            print('Do they have "1" or "2" Types: ')
            types = int(input())
            typelist = ['Normal', 'Fire', 'Water', 'Grass', 'Electric', 'Ice', 'Fighting', 'Poison', 'Ground', 'Flying',
                        'Psychic', 'Bug', 'Rock', 'Ghost', 'Dark', 'Dragon', 'Steel', 'Fairy']
            print(
                'The types are "Normal","Fire","Water","Grass","Electric","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dark","Dragon","Steel", or "Fairy"')
            if types == 1:
                print('What is the pokemon type :')
                newtype1 = input()
                if newtype1 in typelist:
                    typestring = newtype1 + " " + "null"
                    DB.execute(
                        "UPDATE Pokedex Set " + selection + " = '" + typestring + "' WHERE Name = '" + Pokemon_Name + "'")
                else:
                    print('Invalid Selection')
            elif types == 2:
                print('What is the pokemons first type :')
                newtype1 = input()
                if newtype1 in typelist:
                    print('What is the pokemons second type :')
                    newtype2 = input()
                    if newtype2 in typelist:
                        typestring = newtype1 + " " + newtype2
                        DB.execute(
                            "UPDATE Pokedex Set " + selection + " = '" + typestring + "' WHERE Name = '" + Pokemon_Name + "'")
                    else:
                        print('Invalid Selection')
                else:
                    print('Invalid Selection')
            else:
                print('Invalid Selection')

        else:
            print('Invalid Selection')
    else:
        print('Invalid Selection')


def checkifnumexists(Number):
    instances = DB.execute("SELECT COUNT(*) FROM Pokemon WHERE Pokedex_No = '" + str(Number) + "'")
    return instances > 0


def checkifnameexists(Nameof):
    instances = DB.execute("SELECT COUNT(*) FROM Pokemon WHERE Pokedex_No = '" + Nameof + "'")
    return instances > 0


def getname(Number):
    return DB.execute("SELECT Name FROM Pokemon WHERE Pokedex_No = '" + str(Number) + "'")


def pokemonweaknesses():
    print('Do you want to search by "Name" or "Num": ')
    selection = input()
    if selection == "Name":
        print('Enter a pokemon name: ')
        name = input()
        if checkifnameexists(name):
            types = DB.execute("SELECT Types FROM Pokedex WHERE Name = '" + name + "'")
            type1 = types.split()[0]
            type2 = types.split()[1]
            if type1 != 'null':
                print('The pokemon is weak to ')
                print(DB.execute("SELECT Weaknesses FROM Weakness WHERE Type = '" + type1 + "'"))
                if type2 != 'null':
                    print('The pokemon is also weak to ')
                    print(DB.execute("SELECT Weaknesses FROM Weakness WHERE Type = '" + type2 + "'"))
            else:
                print('This pokemon has invalid types')
        else:
            print('Invalid Selection')
    elif selection == "Num":
        print('Enter a pokemon number: ')
        number = int(input())
        if checkifnumexists(number):
            name = getname(number)
            types = DB.execute("SELECT Type FROM Pokedex WHERE Name = '" + name + "'")
            type1 = types.split()[0]
            type2 = types.split()[1]
            if type1 != 'null':
                print('The pokemon is weak to ')
                print(DB.execute("SELECT Weaknesses FROM Weakness WHERE Type = '" + type1 + "'"))
                if type2 != 'null':
                    print('The pokemon is also weak to ')
                    print(DB.execute("SELECT Weaknesses FROM Weakness WHERE Type = '" + type2 + "'"))
            else:
                print('This pokemon has invalid types')
        else:
            print('Invalid Selection')
    else:
        print('Invalid Selection')


def getStatHelper():
    print('Do you want to search by "Name" or "Num": ')
    selection = input()
    if selection == "Name":
        print('Enter a pokemon name: ')
        name = input()
    elif selection == "Num":
        print('Enter a pokemon number: ')
        number = int(input())
        if checkifnumexists(number):
            name = getname(number)
    else:
        print('Invalid Selection')
    if checkifnameexists(name):
        print("What Stat do you want 'Total', 'HP', 'Attack', 'Defense', 'Sp_Atk', 'Sp_Def', 'Speed': ")
        selectioninput = input()
        print('The value is ')
        if selectioninput == 'Total':
            print(getTotal(name))
        if selectioninput == 'HP':
            print(getHP(name))
        if selectioninput == 'Attack':
            print(getAttack(name))
        if selectioninput == 'Defense':
            print(getDefense(name))
        if selectioninput == 'Sp_Atk':
            print(getSp_Atk(name))
        if selectioninput == 'Sp_Def':
            print(getSp_Def(name))
        if selectioninput == 'Speed':
            print(getSpeed(name))

    else:
        print('Invalid Selection')


def getTotal(Name):
    return DB.execute("SELECT Total FROM Stats WHERE Name = '" + Name + "'")


def getHP(Name):
    return DB.execute("SELECT HP FROM Stats WHERE Name = '" + Name + "'")


def getAttack(Name):
    return DB.execute("SELECT Attack FROM Stats WHERE Name = '" + Name + "'")


def getDefense(Name):
    return DB.execute("SELECT Defense FROM Stats WHERE Name = '" + Name + "'")


def getSp_Atk(Name):
    return DB.execute("SELECT Sp_Atk FROM Stats WHERE Name = '" + Name + "'")


def getSp_Def(Name):
    return DB.execute("SELECT Sp_Def FROM Stats WHERE Name = '" + Name + "'")


def getSpeed(Name):
    return DB.execute("SELECT Speed FROM Stats WHERE Name = '" + Name + "'")

def getType(Name):
    return DB.execute("SELECT Type FROM Pokedex WHERE Name = '" + Name + "'")


def main():
    print('Do you want to "add", "remove", "Update" or "exit":')
    userdecision = input()
    if userdecision == 'add':
        addpokemon()
    if userdecision == 'remove':
        removepokemon()
    if userdecision == 'Update':
        updatepokemon()
    if userdecision != 'exit':
        main()
    print("Done")


if dbexists():
    main()
else:
    open("pokemon.db", "x")
    initializetables()
    set = sqlite3.connect("pokemon.db")
    DB = set.cursor()
    main()
