##Name: Brandon Scanlon

##TDD TODO/Task list

##Tests

###I tested with different .egc files to thoroughly various configurations that are attached with my submission

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
|   14  | Create coordinate, check not equal                                         | Create coordinate                                           |
|**---**| **-- TESTS FOR ESCAPE GAME MANAGER METHOD EXCEPTIONS --**                  |**---------------------------------------------------------**|
|   15  | Build game manager requests to move from (1,4) to (32,11)                  | Game manager method request, exception (Removed for implementation)                  |
|   16  | Build game manager requests to get a piece at (1,4)                        | Game manager method request, exception                      |
|**---**| **-------------------- TESTS FOR GAME BOARDS --------------------**        |**---------------------------------------------------------**|
|   17  | Build a SQUARE game board                                                  | Create game board object                                    |
|   18  | Build a HEX game board                                                     | Create game board object                                    |
|   19  | Build SQUARE board with all CLEAR location                                 | Create game board object                                    |
|   20  | Build HEX board with all CLEAR location                                    | Create game board object                                    |
|   21  | Two SQUARE coordinates are equal                                           | Create and compare coordinate objects                       |
|   22  | Two HEX coordinates are equal                                              | Create and compare coordinate objects                       |
|   23  | Locations populate from config.ecg                                         | Create game board object                                    |
|   24  | Create Board with infinite bounds (0,0)                                    | Create game board                                           |
|   25  |                                                   |                                     |
|   26  |                                                   |                                     |
|   27  |                                                   |                                     |
|   28  |                                                   |                                     |
|   29  |                                                   |                                     |

|   2  | Move piece LINEAR on SQUARE board                                          | Create game status object                                   |
|   2  |                                                   |                                     |
|   2  |                                                   |                                     |
|   2  |                                                   |                                     |
|   2  |                                                   |                                     |
|   2  |                                                   |                                     |
|   30  |                                                   |                                     |