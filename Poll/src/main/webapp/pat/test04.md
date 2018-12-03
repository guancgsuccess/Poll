#拓展篇(4)
##查验身份证
>1. 题目
>> 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：<br>
>>首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；<br>
>>然后将计算的和对11取模得到值Z；最后按照以下关系对应Z值与校验码M的值：<br>
>>Z：0 1 2 3 4 5 6 7 8 9 10\ M：1 0 X 9 8 7 6 5 4 3 2<br>
>>现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。

>2. 输入格式：
>>输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
>3. 输出格式：
>>按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，则输出“All passed”。
>4. 输入样例1：
>>
~~~
4
320124198808240056
12010X198901011234
110108196711301866
37070419881216001X
~~~
>5. 输出样例1：
>>
~~~
12010X198901011234
110108196711301866
37070419881216001X
~~~
>6. 输入样例2：
>>
~~~
2
320124198808240056
110108196711301862
~~~
>7. 输出样例2：
>>
~~~
All passed
~~~

##Business
>1. 题目
>>As the manager of your company, you have to carefully consider, for each project, the time taken to finish it, the deadline, <br>
>>and the profit you can gain, in order to decide if your group should take this project. For example, given 3 projects as the following: <br>
>>Project[1] takes 3 days, it must be finished in 3 days in order to gain 6 units of profit. <br>
>>Project[2] takes 2 days, it must be finished in 2 days in order to gain 3 units of profit. <br>
>>Project[3] takes 1 day only, it must be finished in 3 days in order to gain 4 units of profit. <br>
>>You may take Project[1] to gain 6 units of profit. But if you take Project[2] first, then you will have 1 day left to complete  <br>
>>Project[3] just in time, and hence gain 7 units of profit in total. Notice that once you decide to work on a project, you have to do it from  <br>
>>beginning to the end without any interruption.

>2. 输入格式：
>>Each input file contains one test case. For each case, the first line gives a positive integer N(<=50), and then followed by N lines of projects, each contains three numbers P, L, and D where P is the profit, L the lasting days of the project, and D the deadline. It is guaranteed that L is never more than D, and all the numbers are non-negative integers.
>3. 输出格式：
>>For each test case, output in a line the maximum profit you can gain.
>4. 输入样例1：
>>
~~~
4
7 1 3
10 2 3
6 1 2
5 1 1
~~~
>5. 输出样例1：
>>
~~~
18
~~~

##Phone Bills
>1. 题目
>>A long-distance telephone company charges its customers by the following rules:<br>
>>Making a long-distance call costs a certain amount per minute, depending on the time<br>
>>of day when the call is made. When a customer starts connecting a long-distance call, <br>
>>the time will be recorded, and so will be the time when the customer hangs up the phone. <br>
>>Every calendar month, a bill is sent to the customer for each minute called (at a rate determined by the time of day). <br>
>>Your job is to prepare the bills for each month, given a set of phone call records.

>2. 输入格式：
>>Each input file contains one test case. Each case has two parts: the rate structure, and the phone call records.<br>
>>The rate structure consists of a line with 24 non-negative integers denoting the toll (cents/minute) from 00:00 - 01:00, the toll from 01:00<br>
>>•02:00, and so on for each hour in the day.<br>
>>The next line contains a positive number N (<= 1000), followed by N lines of records.<br>
>>Each phone call record consists of the name of the customer (string of up to 20 characters without space), <br>
>>the time and date (mm:dd:hh:mm), and the word "on-line" or "off-line".<br>
>>For each test case, all dates will be within a single month. Each "on-line" record is paired with the chronologically <br>
>>next record for the same customer provided it is an "off-line" record. Any "on-line" records that are not paired with an "off-line"<br>
>>record are ignored, as are "off-line" records not paired with an "on-line" record. It is guaranteed that at least one call is well paired <br>
>>in the input. You may assume that no two records for the same customer have the same time. Times are recorded using a 24-hour clock.

>3. 输出格式：
>>For each test case, you must print a phone bill for each customer.<br>
>>Bills must be printed in alphabetical order of customers' names. For each customer, <br>
>>first print in a line the name of the customer and the month of the bill in the format shown by the sample.<br>
>>Then for each time period of a call, print in one line the beginning and ending time and date (dd:hh:mm), <br>
>>the lasting time (in minute) and the charge of the call. The calls must be listed in chronological order. <br>
>>Finally, print the total charge for the month in the format shown by the sample.

>4. 输入样例1：
>>
~~~
10 10 10 10 10 10 20 20 20 15 15 15 15 15 15 15 20 30 20 15 15 10 10 10
10
CYLL 01:01:06:01 on-line
CYLL 01:28:16:05 off-line
CYJJ 01:01:07:00 off-line
CYLL 01:01:08:03 off-line
CYJJ 01:01:05:59 on-line
aaa 01:01:01:03 on-line
aaa 01:02:00:01 on-line
CYLL 01:28:15:41 on-line
aaa 01:05:02:24 on-line
aaa 01:04:23:59 off-line
~~~
>5. 输出样例1：
>>
~~~
CYJJ 01
01:05:59 01:07:00 61 $12.10
Total amount: $12.10
CYLL 01
01:06:01 01:08:03 122 $24.40
28:15:41 28:16:05 24 $3.85
Total amount: $28.25
aaa 01
02:00:01 04:23:59 4318 $638.80
Total amount: $638.80
~~~

##A+B Format 
>1. 题目
>> Calculate a + b and output the sum in standard format -- that is, the digits must be separated into groups of three by commas (unless there are less than four digits).

>2. 输入格式：
>>Each input file contains one test case. Each case contains a pair of integers a and b where -1000000 <= a, b <= 1000000. The numbers are separated by a space.

>3. 输出格式：
>>For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.

>4. 输入样例1：
>>
~~~
-1000000 9
~~~
>5. 输出样例1：
>>
~~~
-999,991
~~~

##Password 
>1. 题目
>> To prepare for PAT, the judge sometimes has to generate random passwords for the users. <br>
>>The problem is that there are always some confusing passwords since it is hard to distinguish 1 (one) <br> 
>>from l (L in lowercase), or 0 (zero) from O (o in uppercase). One solution is to replace 1 (one) by @,  <br>
>>0 (zero) by %, l by L, and O by o. Now it is your job to write a program to check the accounts generated by the judge,  
>>and to help the juge modify the confusing passwords.

>2. 输入格式：
>>Each input file contains one test case. Each case contains a positive integer N (<= 1000), followed by N lines of accounts. Each account consists of a user name and a password, both are strings of no more than 10 characters with no space.

>3. 输出格式：
>>For each test case, first print the number M of accounts that have been modified, then print in the following M lines the modified accounts info, that is, the user names and the corresponding modified passwords. The accounts must be printed in the same order as they are read in. If no account is modified, print in one line "There are N accounts and no account is modified" where N is the total number of accounts. However, if N is one, you must print "There is 1 account and no account is modified" instead.

>4. 输入样例1：
>>
~~~
3
Team000002 Rlsp0dfa
Team000003 perfectpwd
Team000001 R1spOdfa
~~~
>5. 输出样例1：
>>
~~~
2
Team000002 RLsp%dfa
Team000001 R@spodfa
~~~
>6. 输入样例2：
>>
~~~
1
team110 abcdefg332
~~~
>7. 输出样例2：
>>
~~~
There is 1 account and no account is modified
~~~
>8. 输入样例3：
>>
~~~
2
team110 abcdefg222
team220 abcdefg333
~~~
>9. 输出样例3：
>>
~~~
There are 2 accounts and no account is modified
~~~

##Dating 
>1. 题目
>>Sherlock Holmes received a note with some strange strings: "Let's date! 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm". <br>
>>It took him only a minute to figure out that those strange strings are actually referring to the coded time "Thursday 14:04" -- since the <br>
>>first common capital English letter (case sensitive) shared by the first two strings is the 4th capital letter 'D', representing the 4th day in a week; <br>
>>the second common character is the 5th capital letter 'E', representing the 14th hour (hence the hours from 0 to 23 in a day are represented <br>
>>by the numbers from 0 to 9 and the capital letters from A to N, respectively); and the English letter shared by the last two strings is 's' at the 4th position, <br>
>>representing the 4th minute. Now given two pairs of strings, you are supposed to help Sherlock decode the dating time.

>2. 输入格式：
>>Each input file contains one test case. Each case gives 4 non-empty strings of no more than 60 characters without white space in 4 lines.
>3. 输出格式：
>>For each test case, print the decoded time in one line, in the format "DAY HH:MM", where "DAY" is a 3-character abbreviation for the days in a week -- that is, "MON" for Monday, "TUE" for Tuesday, "WED" for Wednesday, "THU" for Thursday, "FRI" for Friday, "SAT" for Saturday, and "SUN" for Sunday. It is guaranteed that the result is unique for each case.
>4. 输入样例1：
>>
~~~
3485djDkxh4hhGE 
2984akDfkkkkggEdsb 
s&hgsfdk 
d&Hyscvnm
~~~
>5. 输出样例1：
>>
~~~
THU 14:04
~~~

##Gas Station 
>1. 题目
>>A gas station has to be built at such a location that the minimum distance between the station and any of the residential housing is as far away as possible.<br>
>>However it must guarantee that all the houses are in its service range.<br>
>>Now given the map of the city and several candidate locations for the gas station, you are supposed to give the best recommendation.<br>
>>If there are more than one solution, output the one with the smallest average distance to all the houses. If such a solution is still not unique, <br>
>>output the one with the smallest index number.

>2. 输入格式：
>>Each input file contains one test case. For each case, the first line contains 4 positive integers: N (<= 10^3^), <br>
>>the total number of houses; M (<= 10), the total number of the candidate locations for the gas stations; K (<= 10^4^), <br>
>>the number of roads connecting the houses and the gas stations; and D~S~, the maximum service range of the gas station. <br>
>>It is hence assumed that all the houses are numbered from 1 to N, and all the candidate locations are numbered from G1 to GM.<br>
>>Then K lines follow, each describes a road in the format\ P1 P2 Dist\ where P1 and P2 are the two ends of a road <br>
>>which can be either house numbers or gas station numbers, and Dist is the integer length of the road.

>3. 输出格式：
>>For each test case, print in the first line the index number of the best location. In the next line,<br>
>>print the minimum and the average distances between the solution and all the houses. <br>
>>The numbers in a line must be separated by a space and be accurate up to 1 decimal place. If the solution does not exist, simply output “No Solution”.

>4. 输入样例1：
>>
~~~
4 3 11 5
1 2 2
1 4 2
1 G1 4
1 G2 3
2 3 2
2 G2 1
3 4 2
3 G3 2
4 G1 3
G2 G1 1
G3 G2 2
~~~
>5. 输出样例1：
>>
~~~
G1
2.0 3.3
~~~
>7. 输入样例2：
>>
~~~
2 1 2 10
1 G1 9
2 G1 20
~~~
>7. 输出样例2：
>>
~~~
No Solution
~~~