# word_guessing_game
a word-guessing game you can play from your terminal!

Technologies: Java17, Gradle, JUnit5, Mockito

# How to play

Prerequisites:
Java17
Gradle

Clone this repository
```
git clone https://github.com/s-dousse/word_guessing_game.git
```
Get all the dependencies
```
cd word_guessing_game
gradle build
```

Run all the tests in `./app/src/test/java/game` to ensure the game is working correctly

Run `Game.main()`

You should see the game start in your terminal, have fun!

Here is a preview:
```
> Task :app:Game.main()
Welcome! Here's a little game where you have to guess a given word :)
The word to guess is: D________
Remember you can only guess one letter at a time; it's your turn ( remaining attempts: 10) :
A
Wrong :D________( remaining attempts: 9)
E
Right :DE_E___E_( remaining attempts: 9)
I
Wrong :DE_E___E_( remaining attempts: 8)
O
Right :DE_E_O_E_( remaining attempts: 8)
U
Wrong :DE_E_O_E_( remaining attempts: 7)
7
Please enter a valid letter
R
Right :DE_E_O_ER( remaining attempts: 7)
T
Wrong :DE_E_O_ER( remaining attempts: 6)
N
Wrong :DE_E_O_ER( remaining attempts: 5)
S
Wrong :DE_E_O_ER( remaining attempts: 4)
L
Right :DE_ELO_ER( remaining attempts: 4)
C
Wrong :DE_ELO_ER( remaining attempts: 3)
V
Right :DEVELO_ER( remaining attempts: 3)
P
Yay, the word to guess was: DEVELOPER ٩(^ᗜ^ )و
```

When I have time I would like to implement a multiplayer mode with a scoring system. The more, the merrier :)
