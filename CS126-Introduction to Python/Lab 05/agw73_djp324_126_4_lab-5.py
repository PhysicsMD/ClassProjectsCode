'''Alenn Wright,  Deepkumar Patel
   agw73, djp324
   Section 4
   CSID= 185 AND 154
   10/6/2017
   Lab 5 Contacts
'''
def main():
    contacts = []
    '''contacts, "Alenn", "Wright", "age73@nau.edu", 18, "9876543210"'''
    return 0


def create_contact(contacts, first, last, email, age, phone):
    f_l = first + " " + last
    contacts[f_l] = [ email, age,  phone]

def update_contact_number(contacts, first, last, phone):
    f_l = first + " " + last
    contacts[f_l] = phone


def update_contact_email(contacts, first, last, email):
    f_l = first + " " + last
    contacts[f_l] = email

def update_contact_age(contacts, first, last, age):
    f_l = first + " " + last
    contacts[f_l] = age


def get_contact_email(contacts, first, last):
    f_l = first + " " + last


def get_contact_age(contacts, first, last):
    return 0

def get_contact_number(contacts, first, last):
    return 0

def contains_contact(contacts, first, last):
    if first in contacts:
        return True
    else:
        return False

def display(contacts, first, last):
    print(first +" "+ last)
    print("Email:" + email)
    print("Phone:" + phone)
    print("Age:" + age)
    return 0
main()
