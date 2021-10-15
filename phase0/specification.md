## Specification

Our goal is to create a program that will allow users to play a game of monopoly locally with other players. When the program runs, each user will be able to assign themselves a character image, a character name and a fixed spot in the turn order. Once the game is started, a monopoly board will be created and players will take turns in the order assigned to them. On each players turn they will do the following:
- Roll/Move if they are still in the game.
- Buy Property - which we will call buyable tiles, and when they buy a whole lot (all properties of the same color), they can also start buying houses or hotels which increase the property value.
- Pay rent when they land on a property tile that is owned by another player.
- Collect 200$ from the bank if they passed the starting tile.
- Abide by tasks or consequences brought up when landing on a chance/community chest tile.
- Go to jail if they land on the “Go to jail” tile.

The program will control which players own each buyable tile. Additionally, the program will keep track of the number of tiles sold and remaining at all points in the game, as well as the funds of each player. The game will end when all players are bankrupt except one, or when all properties are sold and declares the person with the highest net-worth as the winner.