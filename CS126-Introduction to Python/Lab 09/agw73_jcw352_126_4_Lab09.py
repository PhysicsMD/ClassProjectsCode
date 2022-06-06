'''
Alenn Wright
Jeffrey Williamson
agw73 & jcw352
CSID 185 & 283
Lab 9 - Draw Stars
'''
import turtle

def read_coords(file):
    # make lists to store data
    # respectivly star cordanites, sizes and labels
    coords = {}
    magnitudes = {}
    names = {}
    # looks at all lines
    for line in file:
        splitline = line.strip().split(" ", maxsplit=6)
        henrynum = float(splitline[3])
        coords[henrynum] = (float(splitline[0]), float(splitline[1]))
        magnitudes[henrynum] = float(splitline[4])
        if len(splitline) == 7:
            line_names = splitline[6].split(";")
            for name in line_names:
                name = name.strip()
                names[name] = henrynum
    return (coords, magnitudes, names)
# This is the return of the data so that they can be used in the other
# Functions below


def plot_plain_stars(size, coords):
    turtle.setup(size, size)
    # sets the backgroud as black
    turtle.bgcolor("BLACK")
    turtle.tracer(0)            # Makes image alooooot faster
    for star in coords.keys():
        x, y = coords[star]
        x *= size/2
        y *= size/2
        turtle.pu() # This is so that we dont have the lines from when
        # Th turtle was tracing a path to go to the choordanites
        turtle.goto(x, y)
        turtle.pd()
        turtle.dot(2, "WHITE")
    turtle.exitonclick()   # This is a way to keep the map up


def plot_by_magnitude(size, coords, magnitudes):
    turtle.setup(size, size)
    turtle.bgcolor("BLACK")
    turtle.tracer(0)            # Makes image alooooot faster
    for star in coords.keys():
        x, y = coords[star]
        x *= size/2
        y *= size/2
        star_size = min(round(10 / (magnitudes[star] + 2)), 8)
        turtle.pu() # This is so that we dont have the lines from when
        # Th turtle was tracing a path to go to the choordanites
        turtle.goto(x, y)
        turtle.pd()
        turtle.dot(star_size, "WHITE")
    turtle.exitonclick()   # This is a way to keep the map up


def main():
    # These are the calls to our various and specific way of plotting
    # The star choordanites that we need to out put the desired answered
    file = open("stars.txt", "r")
    coords, magnitudes, names = read_coords(file)
    plot_by_magnitude(500, coords, magnitudes)
main()
