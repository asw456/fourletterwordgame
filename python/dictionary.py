#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      alan.williams
#
# Created:     07/12/2012
# Copyright:   (c) alan.williams 2012
# Licence:     <your licence>
#-------------------------------------------------------------------------------
#!/usr/bin/env python

import UserString

def readData(file_name):
    f = open(file_name)
    dictionary = []
    for line in f:
        line = line.strip().split(" ")
        for x in line:
          dictionary.append(x)
    return dictionary


def duplicatelettersets():
    a = set()
    for word in dictionary:
        vector = ""
        for letter in alphabet:

            lettersum = 0
            if word[0] == letter:
                lettersum += 1
            if word[1] == letter:
                lettersum += 1
            if word[2] == letter:
                lettersum += 1
            if word[3] == letter:
                lettersum += 1
            vector += str(lettersum)

        a.add(vector)
    print len(a)

#wrong!! use 2 factor replacement like JAVA
def howmanylettersmatch(word1,word2):
    word2 = UserString.MutableString(word2)
    sum = 0
    for char in word1:
        for i in range(0,4):
            if word2[i] == char:
                sum += 1
                word2[i] = '1'
    return sum

def probabilityofgettingnumber(word,number,dictionary):
    sum = 0.0
    for eachword in dictionary:
        if howmanylettersmatch(word,eachword) == number:
            sum += 1
    return sum/len(dictionary)

def newdictionary(word,number,dictionary):
    list = []
    for eachword in dictionary:
        if (howmanylettersmatch(word,eachword) == number):
            list.append(eachword)
    return list


def expectedwordseliminated(guess,dictionary):
    expectednumber = 0
    for each in [0,1,2,3,4]:
        print each
        print probabilityofgettingnumber(guess, each, dictionary)
        expectednumber += probabilityofgettingnumber(guess, each, dictionary)*len(newdictionary(guess,each,dictionary))
    return expectednumber



def test():

    print howmanylettersmatch('AABA','BBBB')

    #dictionary = readData('I:\\dictionary\\python\\4letterdictionary.csv')
    #print expectedwordseliminated('TEST',dictionary)




def main(inputWord):



    alphabet = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    frequency = dict(a=0.08167,b=0.01492,c=2.782,d=0.04253,e=0.12702,f=0.02228,g=0.02015,h=0.06094,i=0.06966,j=0.00153,k=0.00772,l=0.04025,m=0.02406,n=0.06749,o=0.07507,p=0.01929,q=0.00095,r=0.05987,s=0.06327,t=0.09056,u=0.02758,v=0.00978,w=0.02360,x=0.00150,y=0.01974,z=0.00074)

    answers = dict()
    for eachword in dictionary:
        print eachword
        answers[eachword] = expectedwordseliminated(eachword,dictionary)

    import operator
    sortedanswers = sorted(answers.iteritems(), key=operator.itemgetter(1))



if __name__ == '__main__':
    #main()
    test()






#dictionary.sort(key=lambda x: (x[1],-x[0]))
