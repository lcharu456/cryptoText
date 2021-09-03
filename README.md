# cryptoText
This project implements the process of encryption and decryption 
for the user-provided plain text.

## Overview ##

### Introduction ###
Encryption and decryption is one of the key elements of the network communication,
as information security is very important. Anything that is transmitted over the wired or wireless
connection between devices is not sent as the normal text. The information goes through the algorithm block
which has a key and plain text is converted to cipher text. 
The cipher text cannot be decrypted by everyone in the communication channel. The device that will have the 
correct key to decipher the message can only reconstruct the message.

### Why KEY? ###
It is an example of symmetric key cryptography as the same key generated while encryption is being used 
for decrypting the cipher text. It is the most basic method in cryptography. Although it is a fundamental 
method, the text message has a greater odd not being attacked by brute force. 

### Algorithm ###
The project has the algorithm to take the string input from user and it is then converted to hexadecimal 
number followed by binary to perform the bit wise operation. After this, new text message string is generated
as the encrypted text. The significant part is that for every byte a new key is generated to perform the XOR 
operation. Similarly, for the decryption of the encoded text message string is converted to hexadecimal to 
binary and again undergoes XOR operation with bitstream arrays. Thereafter, it is again converted to decimal
followed by hexadecimal and finally back to string format in its original form.
 

### Example ###
Here is the console output for a encipher-decipher implementation done in eclipse IDE. As you 
can see, below is the plain text, cipher text and deciphered text displayed for the user input.

-----------------------------------------------------------------------------------------------
Hello User!
Enter your message which you want to encrypt:\
hey There! Have a great day ahead, look here?\
Original Message as plain text  : hey There! Have a great day ahead, look here?\
Encrypted Message as cipher text: ½¸¯Í¿ÂÚ¤ÔìëÙ­¤àð¤Ë¿òÓ¥³¸ºþèÐóûÙáñîÀ³÷\
The message is decrypted as     : hey There! Have a great day ahead, look here?

-----------------------------------------------------------------------------------------------

## Installation ##
This is a simple java project, with junit library. It could be easily implemented after 
importing in any IDE.

JDK 11
junit4 library in .p2 folder


### Contact ###
Charulata- lcharu456@gmail.com
Project Link:https://www.dropbox.com/sh/4q6loqc1y9grf40/AACPGDEeYIlngxs9F6jcyh_ya?dl=0


