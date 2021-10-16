##CSC207 - Progress Report

###Brief summary of your specification

The purpose of our program is to create a Monopoly game that is somewhat simplified. As part of the primary Monopoly objective, players are tasked with moving around the Monopoly board, purchasing properties, abiding by tasks/consequences placed on them and finishing the game with the most worth (in properties and money).

###CRC model

When observing our CRC models, you will find 8 entity classes, 3 use case classes, 2 controller classes and a main command line interface. The entity tiles are either players in the game, playable tiles or the bank. They all hold information, specific to the purposes of the tiles and players. The three use case classes all take information from entity classes and return information. The Property Checker class takes a look at whether a property is buyable and whether a player can buy it. The Player Status class checks to see if players can continue playing and their net worth. Lastly, the Game Status class checks whether the game has ended or not. Our two controllers, Move Controller and Tile Controller will be controlling the player movement or the ability to purchase a certain tile (applies to properties, community chance, jail, etc.).

###Scenario walk-through

The gameplay is modelled after the multiplayer board game of the original, classic Monopoly. Players will start from GO and the game will begin by rolling dice. Players can buy properties, get community chest cards, go to prison and pay rent to other players. The game will go on until all players are bankrupt or all properties have been sold. Classes written will keep track of player’s net worth, their position, the ability for them to purchase and what tasks they have completed (community chest, buying properties, jail, taxing, etc.). The goal of the game is to finish with the highest worth in money and/or properties in order to declare the winner.

###Skeleton program

We developed a basic program structure in IntelliJ so far which has a few of the classes we intend to work with. We intend to add more classes and interfaces in Phase 1 to build on the skeleton program. All the classes added thus far are the ones mentioned in our CRC cards.

###Group Struggles

Our group has worked very well together! Considering that most of us don’t know each other, everyone works well and has the knowledge and skills for implementing this project. Our main struggle at the moment would be scheduling. We are all in different years, different programs with different schedules - setting a tentative time for 6 people to work together has been quite difficult. However, to maneuver this issue, we’ve taken on the responsibilities to work on certain parts of our projects at later times and update the group of work they may have missed out on.


###What has worked so far

So far, our design has many parts in it. Monopoly, being quite a complex game, requires many classes that need to be able to work together. Our design has been simple and descriptive enough such that anyone who would read our code would be able to understand what is going on, what the classes are doing and how they are implemented. The best part of our design is the organization of it. Everything is very clear and each class has a specific requirement that it will implement and return. We were worried that with a game like monopoly, we would have too many classes and not be able to properly organize our information. However, after writing our CRC cards, it was much easier to put everything together and organize our game into a systematic order to allow us to program the game.

###Work Breakup and Next Steps

Before putting together Phase 0, our team came together and agreed upon doing Monopoly.

Giancarlo took the initiative to start us off and started the specifications and CRC cards, as many of us had scheduling issues. He took the lead in starting our Phase 0 and without him, we would probably have been rushing to get started much later.

Later on in the week, Yusra, Dennis and Rubaina met up in person and elaborated more on the CRC cards, specifications and how we would program the structure. They ultimately finished the CRC cards together and finished most of the specifications. They also took that time to plan out how the structure of the game would look like and update the group regarding the progress done so far.

Afterwards, Dennis took the lead in constructing the main parts of the structure, with assistance from everyone on the team regarding implementing methods and other parts. Yusra took on the role of writing up the specification and Dravin took the initiative to complete the scenario walkthrough. Rubaina and Shivanshi later made sure the portions of Phase 0 were pushed and completed, and wrote the progress report with the team's input.

As for next steps, we hope to be splitting the work amongst ourselves within categories of the game based on our classes. The overall theme of our classes consist of players, property tiles and other playable tiles. The goal is to have at least two members in charge of each section, with team members helping out in the other sections when needed. We have yet to decide who is taking which area; however, we have discussed our program breakdown and hope to be working on our respective areas very soon.

Overall, the team is very happy with the work being done so far and is looking forward to successfully programming the Monopoly game. 
