
# A Text-Based Version of the Classic Game, Mastermind

Developed by Andi Motas

Figure out the passcode in as few tries as possible!
The player loses if they take more than 20 tries.

![alt text](Mastermind.jpg "Mastermind")

## How to Play

### Selecting Difficulty

Player selects a **difficulty level** when prompted by inputting:

| Input      | Difficulty | Passcode Length |
| ----------- | ----------- | ----------- |
| "e"      | Easy       | 3 characters |
| "n"   | Normal        | 4 characters |
| "h"   | Hard        | 5 characters |
| "m"   | Master        | 6 characters |

The program will generate a passcode consisting of any assortment of the characters: **'q', 'w', 'e', 'r', 't', or 'y'**. The passcode length will correspond to the difficulty levels listed above.

### Making Guesses

During each "Guess", the player can either **input a guess for the passcode or quit** the game early. The following shows valid input:

* "z" = Quit Early
* Any guess that meets all 3 of the following:
    1. Consists only of the characters: 'q', 'w', 'e', 'r', 't', or 'y'.
    2. Is the same length as the passcode.
    3. Has NO separators (spaces, commas, etc.)

### Checker Responses

Once the player makes a guess, a *"checker response"* will be printed, which gives information on whether the guess contains characters with (1) **the correct letter AND position**, and/or (2) **the correct letter only**. This is symbolized by the following:

	"B" = Correct Letter AND Position
	"b" = Correct Letter Only

The **order of the checker response DOES NOT correspond to the positions** of the characters in the passcode itself. It only serves to quantify the above information. The player should logically base their next guess on the checker response from previous guesses. *See Section "EXAMPLE PLAY" below.*

### Winning
Once the player makes a guess that matches the passcode without taking more than 20 tries, the player wins. The player loses if they still have not guessed the passcode correctly after they use their 20th guess.

## Example Gameplay

**Passcode = qwe**

### Guess #1: 
    <player input:>		twq
    <checker response:>	Bb	
The 'B' symbolizes that 'w' is the right letter and in the right position.
The 'b' symbolizes that 'q' is the right letter but in the wrong position.

If the player infers that the 'B' corresponds to the 'q' in the guess and that the 'b' corresponds to the 'w' in the guess (which is incorrect), then they might guess...

### Guess #2:
    <player input:>		weq
    <checker response:>	bbb
Each 'b' represents each character being the right letter but not in the right position.

Now the player knows what letters to use and can infer that 'q' is not in the last position according to Guess #2. Based on Guess #1, 'w' must be in the middle position.

### Guess #3:
    <player input:>		qwe
    <checker response:>	BBB
			You Win! Guesses used: 3

Happy code-cracking!