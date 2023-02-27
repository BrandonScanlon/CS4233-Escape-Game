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
|   24  | Create Board with infinite bounds (0,0)  (limited for outOfMemory)         | Create game board                                           |
|   25  | Move null coordinate                                                       | Move coordinate on board                                    |
|   26  | Move coordinate to same coordinate                                         | Move coordinate on board                                    |
|   27  | Move coordinate with no player                                             | Move coordinate on board                                    |
|   28  | Move coordinate off the board                                              | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR LINEAR --------------------**             |**---------------------------------------------------------**|
|   29  | Move coordinate LINEAR - UP                                                | Move coordinate on board                                    |
|   30  | Move coordinate LINEAR - DOWN                                              | Move coordinate on board                                    |
|   31  | Move coordinate LINEAR - LEFT                                              | Move coordinate on board                                    |
|   32  | Move coordinate LINEAR - RIGHT                                             | Move coordinate on board                                    |
|   33  | Move coordinate LINEAR - UPRIGHT                                           | Move coordinate on board                                    |
|   34  | Move coordinate LINEAR - UPLEFT                                            | Move coordinate on board                                    |
|   35  | Move coordinate LINEAR - DOWNRIGHT                                         | Move coordinate on board                                    |
|   36  | Move coordinate LINEAR - DOWNLEFT                                          | Move coordinate on board                                    |
|**---**| **---------------- TESTS FOR LINEAR FAILS (Obstacles)  ----------------**  |**---------------------------------------------------------**|
|   37  | Move coordinate LINEAR - UP (BLOCK)                                        | Move coordinate on board                                    |
|   38  | Move coordinate LINEAR - DOWN (BLOCK)                                      | Move coordinate on board                                    |
|   39  | Move coordinate LINEAR - LEFT (BLOCK)                                      | Move coordinate on board                                    |
|   40  | Move coordinate LINEAR - RIGHT (BLOCK)                                     | Move coordinate on board                                    |
|   41  | Move coordinate LINEAR - UPRIGHT (BLOCK)                                   | Move coordinate on board                                    |
|   42  | Move coordinate LINEAR - UPLEFT (BLOCK)                                    | Move coordinate on board                                    |
|   43  | Move coordinate LINEAR - DOWNRIGHT (BLOCK)                                 | Move coordinate on board                                    |
|   44  | Move coordinate LINEAR - DOWNLEFT (BLOCK)                                  | Move coordinate on board                                    |
|   45  | Move coordinate LINEAR - UP (PIECE)                                        | Move coordinate on board                                    |
|   46  | Move coordinate LINEAR - DOWN (PIECE)                                      | Move coordinate on board                                    |
|   47  | Move coordinate LINEAR - LEFT (PIECE)                                      | Move coordinate on board                                    |
|   48  | Move coordinate LINEAR - RIGHT (PIECE)                                     | Move coordinate on board                                    |
|   49  | Move coordinate LINEAR - UPRIGHT (PIECE)                                   | Move coordinate on board                                    |
|   50  | Move coordinate LINEAR - UPLEFT (PIECE)                                    | Move coordinate on board                                    |
|   51  | Move coordinate LINEAR - DOWNRIGHT (PIECE)                                 | Move coordinate on board                                    |
|   52  | Move coordinate LINEAR - DOWNLEFT (PIECE)                                  | Move coordinate on board                                    |
|   53  | Move coordinate LINEAR - UPUPRIGHT                                         | Move coordinate on board                                    |
|   54  | Move coordinate LINEAR - UPUPLEFT                                          | Move coordinate on board                                    |
|   55  | Move coordinate LINEAR - DOWNDOWNRIGHT                                     | Move coordinate on board                                    |
|   56  | Move coordinate LINEAR - DOWNDOWNLEFT                                      | Move coordinate on board                                    |
|   57  | Move coordinate LINEAR - Move Too Far                                      | Move coordinate on board                                    |
|   58  | Move coordinate LINEAR - Move Off Board                                    | Move coordinate on board                                    |
|   59  | Move coordinate LINEAR - Move Off Board2                                   | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR ORTHOGONAL --------------------**         |**---------------------------------------------------------**|
|   60  | Move coordinate ORTHOGONAL - UP                                            | Move coordinate on board                                    |






|   30  | Move coordinate ORTHOGONAL - DOWN                                          | Move coordinate on board                                    |
|   31  | Move coordinate ORTHOGONAL - LEFT                                          | Move coordinate on board                                    |
|   32  | Move coordinate ORTHOGONAL - RIGHT                                         | Move coordinate on board                                    |
|   33  | Move coordinate ORTHOGONAL - UPRIGHT                                       | Move coordinate on board                                    |
|   34  | Move coordinate ORTHOGONAL - UPLEFT                                        | Move coordinate on board                                    |
|   35  | Move coordinate ORTHOGONAL - DOWNRIGHT                                     | Move coordinate on board                                    |
|   36  | Move coordinate ORTHOGONAL - DOWNLEFT                                      | Move coordinate on board                                    |
|   37  | Move coordinate ORTHOGONAL - UPUPRIGHT                                     | Move coordinate on board                                    |
|   38  | Move coordinate ORTHOGONAL - UPUPLEFT                                      | Move coordinate on board                                    |
|   39  | Move coordinate ORTHOGONAL - DOWNDOWNRIGHT                                 | Move coordinate on board                                    |
|   40  | Move coordinate ORTHOGONAL - DOWNDOWNLEFT                                  | Move coordinate on board                                    |
|   41  | Move coordinate ORTHOGONAL - INVALID (Too Far)                             | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR OMNI --------------------**               |**---------------------------------------------------------**|
|   55  | Move coordinate OMNI - UP                                                  | Move coordinate on board                                    |
|   56  | Move coordinate OMNI - DOWN                                                | Move coordinate on board                                    |
|   57  | Move coordinate OMNI - LEFT                                                | Move coordinate on board                                    |
|   58  | Move coordinate OMNI - RIGHT                                               | Move coordinate on board                                    |
|   59  | Move coordinate OMNI - UPRIGHT                                             | Move coordinate on board                                    |
|   60  | Move coordinate OMNI - UPLEFT                                              | Move coordinate on board                                    |
|   61  | Move coordinate OMNI - DOWNRIGHT                                           | Move coordinate on board                                    |
|   62  | Move coordinate OMNI - DOWNLEFT                                            | Move coordinate on board                                    |
|   63  | Move coordinate OMNI - UPUPRIGHT                                           | Move coordinate on board                                    |
|   64  | Move coordinate OMNI - UPUPLEFT                                            | Move coordinate on board                                    |
|   65  | Move coordinate OMNI - DOWNDOWNRIGHT                                       | Move coordinate on board                                    |
|   66  | Move coordinate OMNI - DOWNDOWNLEFT                                        | Move coordinate on board                                    |
|   67  | Move coordinate OMNI - INVALID (Too Far)                                   | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR FLY --------------------**                |**---------------------------------------------------------**|
|   68  | Move coordinate FLY - UP                                                   | Move coordinate on board                                    |
|   69  | Move coordinate FLY - DOWN                                                 | Move coordinate on board                                    |
|   70  | Move coordinate FLY - LEFT                                                 | Move coordinate on board                                    |
|   71  | Move coordinate FLY - RIGHT                                                | Move coordinate on board                                    |
|   72  | Move coordinate FLY - UPRIGHT                                              | Move coordinate on board                                    |
|   73  | Move coordinate FLY - UPLEFT                                               | Move coordinate on board                                    |
|   74  | Move coordinate FLY - DOWNRIGHT                                            | Move coordinate on board                                    |
|   75  | Move coordinate FLY - DOWNLEFT                                             | Move coordinate on board                                    |
|   76  | Move coordinate FLY - UPUPRIGHT                                            | Move coordinate on board                                    |
|   77  | Move coordinate FLY - UPUPLEFT                                             | Move coordinate on board                                    |
|   78  | Move coordinate FLY - DOWNDOWNRIGHT                                        | Move coordinate on board                                    |
|   79  | Move coordinate FLY - DOWNDOWNLEFT                                         | Move coordinate on board                                    |
|   80  | Move coordinate FLY - INVALID                                              | Move coordinate on board                                    |
