Nathaneal Wattier - JDD2VZ

The Problem:
Create a program which allows a user to practice memorizing
a sonnet by prompting for user input on the next word, stopping
randomly before this word. The program will exit when the user
has guessed either correctly or incorrectly 3 times.

Solution:
My program interprets the problem as continuously reading the
sonnet after a guess or incorrect guess. After each time a user
gives an input, the program will determine if it is correct then
move onto another of the remaining words.

Issues with this implementation:
Since the random function has a uniform distribution, the program
selecting from words that are left unread in the current run
will cause a bias towards words in the second half of the sonnet.

