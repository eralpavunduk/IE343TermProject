# IE343TermProject

Q1

For question one, ıt has been asked for filling the 30 minutes of album. 
The question looked like an knapsack problem. To solve a knapsack problem we choosed bottom up algorithm
which can iterate all durations of songs and fit in the album. 
We optimized the durations and found their values. On the code we didn't delete codes by Berk because of the important content.
This codes can be written in one class so we didn't create another classes.
Also, who run the will see that console shows the data. We let them for checking easier than opening excel files. 



Our solution gives us the songs which chosen by algorithm:

50 49 48 47 46 45 44 43 42 41 40 38 36 
497.23654

In the first row gives us the songs and the second is the value which we found.
There is a 34,76 point difference with Berk's solution.

Q2

For this question, there was only two songs was important for consultant. Firstly, we determined the most valuable and second valuble songs from song sheet.

46 0 
44 1

First song has 46 value and it is in the first queue of the songs. Second has 44 value and this song is after the first song.
After that, we organized an array which has the first is 46 and the last song has value of 44.
For solution, we tried to find most valueable transitions to pick which song has to be the next song. In the code, we tried to search the array of values of a specific songs transitions to other songs.
 We found the highest values and lifting up this song to chosen songs for searching rest of the songs. 
Our solution path is:

0 18 36 4 15 49 45 49 46 15 34 46 36 18 25 46 41 20 23 40 37 33 38 40 40 31 44 33 42 44 41 43 36 36 36 44 45 38 41 48 42 46 49 45 49 46 49 49 49 1 




