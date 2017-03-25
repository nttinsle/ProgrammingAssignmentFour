# ProgrammingAssignmentFour

Nick Tinsley
Programming Assignment 4
Spellchecker
March 25, 2017

Abstract
In assignment four, we face the problem of reading in a file, oliver.txt, and comparing words in this file with a 
dictionary sorted into 26 linked lists. First, we must create 26 linked lists, one for each letter of the alphabet, 
that will hold all the words starting with the same letter in one linked list. Then, we must read in the 
random_dictionary.txt file to give us something to compare words from the oliver.txt file to. We need everything to 
be lowercase in the dictionary, so we lowercase everything. To access a specific list to store a word, we look at the 
first character of the word and using ASCII values we can get the offset for each word from ‘a’. Since ‘a’ has an ASCII 
value of 97 we use this as our base and when we call the list we will take the first character of each word’s ASCII 
value and subtract 97 from it (list[word.charAt(0)-97]). This gives us the linked list the word will be stored in and we 
add it to the list. After we have the linked lists loaded with all the words we can start comparing words from the 
oliver.txt file to see if they are spelled correctly or contained in the dictionary. We must read the oliver.txt file 
word by word by lowercasing every word and by removing every special character. Removing the special characters uses a 
regex of replaceAll(“[^a-z]”). This will remove all special characters. If we hit a null reference throughout the file, 
we skip over to the next word so an exception is not thrown. We will be using the contains method from our linked list 
to see if each word is contained in the dictionary, but we will need to create an overloaded contains method to check 
the comparisons found and not found. This method is the same as the previous contains method, but we add an integer 
array variable(count) that allows us to increment each comparison in the client. We call the list[word.charAt(0)-97] 
now in the readOliver() method, but instead of add we call the overloaded contains method. If this method returns true 
it means the word was found so we increment the wordsFound counter, and we also increment comparisonsFound counter by 
one and add the value of ‘i’. If the word is not found, returns false, we increment the wordsNotFound counter and we 
increment the comparisonsNotFound counter by one and add ‘i’. After finding all these counts we can get the averages 
for comparisons for words found and comparisons for words not found. These will be approximately half the number of 
elements in each linked list and the total number of elements in each linked list, respectively.

run:
Words found 914054
Words not found 64537
Comparisons found 2963071159
Comparisons not found 479381586
Average number of comparisons per word found 3241
Average number of comparisons per word not found 7428
BUILD SUCCESSFUL (total time: 42 seconds)
