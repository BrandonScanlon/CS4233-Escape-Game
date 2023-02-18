##Name: Brandon Scanlon

##TDD TODO/Task list

##Build Tests

###*These are for implementing the EscapeGameBuilder's `makeGameManager()` method.*
###I tested with two different .egc files (config1 & config2) to thoroughly test the builder.
###Since only the first config file will be tested, tests 7 through 12 should fail naturally.

| **#** | Test                                                                                          | Comments                                                    |
|:-----:|:---------------------------------------------------------------------------|:------------------------------------------------------------|
|**---**|           **-------------------- TESTS FOR CONFIG 1 --------------------** |**---------------------------------------------------------**|
|   1   | Build game manager 1, check not null                                       | Create game object                                          |
|   2   | Build game manager 2 X 2, 2 players, and coordinate type SQUARE            | Create game object                                          |
|   3   | Build game manager 2 X 2, individual test 1                                | Create game object                                          |
|   4   | Build game manager 2 X 2, individual test 1 - fail                         | Create game object                                          |
|   5   | Build game manager coordinate type SQUARE, individual test 1               | Create game object                                          |
|   6   | Build game manager coordinate type SQUARE, individual test 1 - fail        | Create game object                                          |
|**---**|           **-------------------- TESTS FOR CONFIG 2 --------------------** |**---------------------------------------------------------**|
|   7   | Build game manager 2, check not null                                       | Create game object                                          |
|   8   | Build game manager 2 X 2, 2 players, and coordinate type HEX               | Create game object                                          |
|   9   | Build game manager 2 X 2, individual test 2                                | Create game object                                          |
|   10  | Build game manager 2 X 2, individual test 2 - fail                         | Create game object                                          |
|   11  | Build game manager coordinate type HEX, individual test 2                  | Create game object                                          |
|   12  | Build game manager coordinate type HEX, individual test 2 - fail           | Create game object                                          |
|**---**| **-------------------- TESTS FOR COORDINATES --------------------**        |**---------------------------------------------------------**|
|   13  | Create coordinate, check not null                                          | Create coordinate                                           |
|   14  | Create coordinate with infinite bounds (0,0)                               | Create coordinate                                           |
|**---**| **-- TESTS FOR ESCAPE GAME MANAGER METHOD EXCEPTIONS --**                  |**---------------------------------------------------------**|
|   15  | Build game manager requests to move from (1,4) to (32,11)                  | Game manager method request, exception                      |
|   16  | Build game manager requests to get a piece at (1,4)                        | Game manager method request, exception                      |
|**---**| **-------------------- TESTS FOR GAME BOARDS --------------------**        |**---------------------------------------------------------**|
|   17  | Build a SQUARE game board                                                  | Create game board object                                    |
|   18  | Build a HEX game board                                                     | Create game board object                                    |
|   19  | Build SQUARE board with all CLEAR location                                 | Create game board object                                    |
|   20  | Build HEX board with all CLEAR location                                    | Create game board object                                    |
|   21  |                                                   |                                     |
|   22  |                                                   |                                     |
|   23  |                                                   |                                     |
|   24  |                                                   |                                     |
|   25  |                                                   |                                     |
|   26  |                                                   |                                     |
|   27  |                                                   |                                     |
|   28  |                                                   |                                     |
|   29  |                                                   |                                     |
|   30  |                                                   |                                     |

|     | Build game with one CLEAR [default] location                               | Create game object                                          |