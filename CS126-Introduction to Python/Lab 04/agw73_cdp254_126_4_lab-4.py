'''Alenn Wright, Colton Putnam
agw73, cdp254
Lab 4 Grade Calculator
9/29/17
Section 4'''


def main():
    #This is our main function and variable database
    hw = .2
    qw = .2
    tw = .6
    homework_max = [40, 40, 40, 40, 40, 5]
    quizzes_max = (10, 10, 10, 10, 10, 10, 10)
    test_max = (300, 300, 300)
    homework_score = [39, 40, 29, 40, 0, 5]
    quizzes_score = (10, 10, 9, 2, 10, 10, 10)
    test_score = (293, 284, 300)
    #The reason these are shortened is for pep8 compliance later in the code
    hm = [40, 40, 40, 40, 40, 5]
    qm = (10, 10, 10, 10, 10, 10, 10)
    tm = (300, 300, 300)
    hs = [39, 40, 29, 40, 0, 5]
    qs = (10, 10, 9, 2, 10, 10, 10)
    ts = (293, 284, 300)
    #this set of variables help the code realize the difference in data sets
    typeh = 'homework'
    typeq = 'quizzes'
    typet = 'test'
    typef = 'final'
    #Below are the calls to the different functions
    average(homework_score, homework_max, typeh)
    average(quizzes_score, quizzes_max, typeq)
    average(test_score, test_max, typet)

    average_weighted(homework_score, homework_max, hw, typeh)
    average_weighted(quizzes_score, quizzes_max, qw, typeq)
    average_weighted(test_score, test_max, tw, typet)
    average_total(hm, hs, qm, qs, tm, ts, hw, qw, tw, typef)
    return 0


def average(score_list, max_list, typeg):
    #This calculates the average score of a grade
    earned = sum(score_list)
    maximum = sum(max_list)
    average = round(float(earned / maximum), 2)*100
    #This send the code to the next function for a letter assignment
    letter_grade(average, typeg)
    return 0


def letter_grade(percent, typeg):
    #This function produces an output grade baised on percent range
    if percent >= 90:
        print("Your", typeg, "grade is an %d (A)." % (int(percent)))
    elif percent >= 80:
        print("Your", typeg, "grade is a %d (B)." % (int(percent)))
    elif percent >= 70:
        print("Your", typeg, "grade is a %d (C)." % (int(percent)))
    elif percent >= 60:
        print("Your", typeg, "grade is a %d (D)." % (int(percent)))
    elif percent < 60:
        print("Your", typeg, "grade is a %d (F)." % (int(percent)))
    else:
        print("You didn't even get a letter")
    return 0


def average_weighted(score_list, max_list, weight, typeg):
    #Calculated the points a grade is worth out of 100
    weighted_score = round(((sum(score_list) / sum(max_list)) * weight*100), 2)
    print("Your", typeg, " weighted score of 100 is", weighted_score)
    return 0


def average_total(hm, hs, qm, qs, tm, ts, hw, qw, tw, typeg):
    #Finds and outputs final score
    ascore = sum(hs)/sum(hm)*hw
    bscore = sum(qs)/sum(qm)*qw
    cscore = sum(ts)/sum(tm)*tw
    final = round((ascore+bscore+cscore), 2)*100
    letter_grade(final, typeg)
    return 0
#call to main function
main()
