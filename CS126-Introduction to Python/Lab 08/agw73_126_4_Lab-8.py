'''Grade Calculator 2
Alenn Wright
agw73 CS126ID =185
11/3/17
section 4'''

'''This opens the input file for analysis'''
inputfile = open('input.txt', 'r')
'''This dictionary holds the original data from the input file'''
state_dict = {}
'''This dictionary holds the altered data for
putting into the second function'''
important_dict = {}


def read_grade_data(inputfile):
    '''this iteration sets the dictionary for an easier way of reading it'''
    for line in inputfile:
        strippedline = line.strip()
        splitline = strippedline.split(' ')
        addresses = ' '.join(splitline[2:])
        state_dict[splitline[0]] = [splitline[1].strip("%"), addresses]

    '''This makes a for loop for every key in the dictionary'''
    for d in state_dict.keys():
        weight = float(state_dict[d][0])
        '''the following x's set up the scores for altering'''
        x = state_dict[d][1]
        x = x.replace(",", "/")
        x = x.replace(" ", "/")
        x = x.replace("//", ",")
        x = x.replace("/", ",")
        x = x.split(",")
        '''this set of loops seperate the actual score and max score'''
        z = 0
        y = 0
        for i in (x[0::2]):
            z += int(i)
        for b in (x[1::2]):
            y += int(b)
        average = round(z/y, 2)
        '''this if statement tells me according to an average'''
        '''the letter representation'''
        lttr = ""
        if average >= .9:
            lttr = "A"
        elif average >= .8:
            lttr = "B"
        elif average >= .7:
            lttr = "C"
        elif average >= .6:
            lttr = "D"
        else:
            lttr = "F"
        contribution = 0
        contribution = round((average * int(weight)/100), 3)
        '''the next line of code sets up the data structure
        that i wanted to use'''
        important_dict[d] = (weight, average, lttr, contribution)
        inputfile.close()
    print(important_dict)
    return ""
'''this is the original call to the data interpretation function'''
read_grade_data(inputfile)

outputfile = open("output.html", "w")


def write_grade_report(file, data):
    total_average = 0
    letter = ""
    '''this loop is for outputting the data into html'''
    for d in data.keys():
        file.write("<html><head><title>Alenn's Lab NO.8</title></head><body>")
        file.write("<h1>" + d + " Statistics (" + str(data[d][0]) + ")</h1>")
        file.write("<ul><li><b>Average: </b>" + str(data[d][1]) + "</li>")
        file.write("<li><b>Letter Grade: </b>" + data[d][2] + "</li>")
        file.write("<li><b>Overall Grade Contribution: </b>")
        file.write(str(data[d][3]) + "</li></ul>")
        total_average += data[d][3]
    '''this functions analyzes the cumulative grade and gives it a letter'''
    if total_average >= .9:
        letter = "A"
    elif total_average >= .8:
        letter = "B"
    elif total_average >= .7:
        letter = "C"
    elif total_average >= .6:
        letter = "D"
    else:
        letter = "F"
    '''This outputs the cumulative data into html'''
    file.write("<h1>Cumulative Statistics</h1>")
    file.write("<ul><li><b>Average:</b>")
    file.write(str(round(total_average, 2)) + "</li>")
    file.write("<li><b>Letter Grade: </b>" + letter + "</li>")
    file.close()
    return ""
'''This is the call function to write in the html file'''
write_grade_report(outputfile, important_dict)
