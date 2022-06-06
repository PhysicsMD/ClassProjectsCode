'''Seil oh, Alenn Wright
si95, agw73
lab 6 Banner
10/13/2017
Section 4'''


def main():
    letter_dict = {"a" or "A": [' ## ', '#  #', '#  #', '####', '#  #'],
                   "b" or "B": ['### ', '#  #', '### ', '#  #', '### '],
                   "c" or "C": [' ## ', '#  #', '#   ', '#  #', ' ## '],
                   "d" or "D": ['### ', '#  #', '#  #', '#  #', '### '],
                   "e" or "E": ['####', '#   ', '####', '#   ', '####'],
                   "f" or "F": ['####', '#   ', '####', '#   ', '#   '],
                   "g" or "G": [' ## ', '#   ', '# ##', '#  #', ' ## '],
                   "h" or "H": ['#  #', '#  #', '####', '#  #', '#  #'],
                   "i" or "I": ['#####', '  #  ', '  #  ', '  #  ', '#####'],
                   "j" or "J": ['   #', '   #', '   #', '#  #', ' ## '],
                   "k" or "K": ['#  #', '# # ', '##  ', '# # ', '#  #'],
                   "l" or "L": ['#   ', '#   ', '#   ', '#   ', '####'],
                   "m" or "M": ['#   #', '## ##', '# # #', '#   #', '#   #'],
                   "n" or "N": ['#   #', '##  #', '# # #', '#  ##', '#   #'],
                   "o" or "O": ['####', '#  #', '#  #', '#  #', '####'],
                   "p" or "P": ['####', '#  #', '####', '#   ', '#   '],
                   "q" or "Q": ['###   ', '# #   ', '###   ', '   # #',
                                '    # '],
                   "r" or "R": ['### ', '#  #', '### ', '#  #', '#  #'],
                   "s" or "S": ['####', '#   ', '####', '   #', '####'],
                   "t" or "T": ['#####', '  #  ', '  #  ', '  #  ', '  #  '],
                   "u" or "U": ['#  #', '#  #', '#  #', '#  #', '####'],
                   "v" or "V": ['#  #', '#  #', '#  #', '#  #', ' ## '],
                   "w" or "W": ['#   #', '#   #', '#   #', '# # #', ' # # '],
                   "x" or "X": ['#  #', '#  #', ' ## ', '#  #', '#  #'],
                   "y" or "Y": ['#   #', ' # # ', '  #  ', '  #  ', '  #  '],
                   "z" or "Z": ['#####', '   # ', '  #  ', ' #   ', '#####'],
                   " ": ['   ', '   ', '   ', '   ', '   '],
                   "?": ['####', '#  #', '  # ', '    ', '  # '],
                   "'": ['  # ', '  # ', '  # ', '    ', '    '],
                   ".": ['    ', '    ', '    ', '    ', '  # '],
                   "-": ['    ', '    ', '####', '    ', '    '],
                   "!": ['#', '#', '#', ' ', '#'],
                   ",": ['  ', '  ', '  ', ' #', '# ']}
    x = input("Type a word: ")
    x = x.lower()
    position = input("Verticle or Horizontal: ").lower()

    if position == ("verticle" or "Verticle"):
        for verticle in range(len(x)):
            print(print_banner(letter_dict, x[verticle]), end="")
    elif position == ("horizontal" or "Horizontal"):
        horizontal_line = ""
        for line in range(5):
            for m in x:
                horizontal_line += letter_dict[m][line] + " "
            horizontal_line += "\n"
        print(horizontal_line)
        return ""
    else:
        print("An error")


def print_banner(letter_dict, input1):
    for element in range(len(input1)):
        for string in range(len(letter_dict[input1[element]])):
            print(letter_dict[input1[element]][string])
        print()
        return ""
    return ""


main()
