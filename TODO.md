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
|   61  | Move coordinate ORTHOGONAL - DOWN                                          | Move coordinate on board                                    |
|   62  | Move coordinate ORTHOGONAL - LEFT                                          | Move coordinate on board                                    |
|   63  | Move coordinate ORTHOGONAL - RIGHT                                         | Move coordinate on board                                    |
|   64  | Move coordinate ORTHOGONAL - UPRIGHT                                       | Move coordinate on board                                    |
|   65  | Move coordinate ORTHOGONAL - UPLEFT                                        | Move coordinate on board                                    |
|   66  | Move coordinate ORTHOGONAL - DOWNRIGHT                                     | Move coordinate on board                                    |
|   67  | Move coordinate ORTHOGONAL - DOWNLEFT                                      | Move coordinate on board                                    |
|   68  | Move coordinate ORTHOGONAL - UPUPRIGHT                                     | Move coordinate on board                                    |
|   69  | Move coordinate ORTHOGONAL - UPUPLEFT                                      | Move coordinate on board                                    |
|   70  | Move coordinate ORTHOGONAL - DOWNDOWNRIGHT                                 | Move coordinate on board                                    |
|   71  | Move coordinate ORTHOGONAL - DOWNDOWNLEFT                                  | Move coordinate on board                                    |
|**---**| **--------------- TESTS FOR ORTHOGONAL (Obstacles) ---------------**       |**---------------------------------------------------------**|
|   72  | Move coordinate ORTHOGONAL - UP (BLOCK)                                    | Move coordinate on board                                    |
|   73  | Move coordinate ORTHOGONAL - DOWN (BLOCK)                                  | Move coordinate on board                                    |
|   74  | Move coordinate ORTHOGONAL - RIGHT (BLOCK)                                 | Move coordinate on board                                    |
|   75  | Move coordinate ORTHOGONAL - LEFT (BLOCK)                                  | Move coordinate on board                                    |
|   76  | Move coordinate ORTHOGONAL - UPRIGHT (BLOCK)                               | Move coordinate on board                                    |
|   77  | Move coordinate ORTHOGONAL - UPLEFT (BLOCK)                                | Move coordinate on board                                    |
|   78  | Move coordinate ORTHOGONAL - DOWNRIGHT (BLOCK)                             | Move coordinate on board                                    |
|   79  | Move coordinate ORTHOGONAL - DOWNLEFT (BLOCK)                              | Move coordinate on board                                    |
|   80  | Move coordinate ORTHOGONAL - UP (PIECE)                                    | Move coordinate on board                                    |
|   81  | Move coordinate ORTHOGONAL - DOWN (PIECE)                                  | Move coordinate on board                                    |
|   82  | Move coordinate ORTHOGONAL - RIGHT (PIECE)                                 | Move coordinate on board                                    |
|   83  | Move coordinate ORTHOGONAL - LEFT (PIECE)                                  | Move coordinate on board                                    |
|   84  | Move coordinate ORTHOGONAL - Move Too Far                                  | Move coordinate on board                                    |
|   85  | Move coordinate ORTHOGONAL - Move Off Board                                | Move coordinate on board                                    |
|   86  | Move coordinate ORTHOGONAL - Move Off Board2                               | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR OMNI SQUARE --------------------**        |**---------------------------------------------------------**|
|   87  | Move coordinate OMNI - UP                                                  | Move coordinate on board                                    |
|   88  | Move coordinate OMNI - DOWN                                                | Move coordinate on board                                    |
|   89  | Move coordinate OMNI - LEFT                                                | Move coordinate on board                                    |
|   90  | Move coordinate OMNI - RIGHT                                               | Move coordinate on board                                    |
|   91  | Move coordinate OMNI - UPRIGHT                                             | Move coordinate on board                                    |
|   92  | Move coordinate OMNI - UPLEFT                                              | Move coordinate on board                                    |
|   93  | Move coordinate OMNI - DOWNRIGHT                                           | Move coordinate on board                                    |
|   94  | Move coordinate OMNI - DOWNLEFT                                            | Move coordinate on board                                    |
|   95  | Move coordinate OMNI - UPUPRIGHT                                           | Move coordinate on board                                    |
|   96  | Move coordinate OMNI - UPUPLEFT                                            | Move coordinate on board                                    |
|   97  | Move coordinate OMNI - DOWNDOWNRIGHT                                       | Move coordinate on board                                    |
|   98  | Move coordinate OMNI - DOWNDOWNLEFT                                        | Move coordinate on board                                    |
|**---**| **--------------- TESTS FOR OMNI SQUARE (Obstacles) ---------------**      |**---------------------------------------------------------**|
|   99  | Move coordinate OMNI - UP (BLOCK)                                          | Move coordinate on board                                    |
|  100  | Move coordinate OMNI - DOWN (BLOCK)                                        | Move coordinate on board                                    |
|  101  | Move coordinate OMNI - LEFT (BLOCK)                                        | Move coordinate on board                                    |
|  102  | Move coordinate OMNI - RIGHT (BLOCK)                                       | Move coordinate on board                                    |
|  103  | Move coordinate OMNI - UPRIGHT (BLOCK)                                     | Move coordinate on board                                    |
|  104  | Move coordinate OMNI - UPLEFT (BLOCK)                                      | Move coordinate on board                                    |
|  105  | Move coordinate OMNI - DOWNRIGHT (BLOCK)                                   | Move coordinate on board                                    |
|  106  | Move coordinate OMNI - DOWNLEFT (BLOCK)                                    | Move coordinate on board                                    |
|  107  | Move coordinate OMNI - UP (PIECE)                                          | Move coordinate on board                                    |
|  108  | Move coordinate OMNI - DOWN (PIECE)                                        | Move coordinate on board                                    |
|  109  | Move coordinate OMNI - LEFT (PIECE)                                        | Move coordinate on board                                    |
|  110  | Move coordinate OMNI - RIGHT (PIECE)                                       | Move coordinate on board                                    |
|  111  | Move coordinate OMNI - UPRIGHT (PIECE)                                     | Move coordinate on board                                    |
|  112  | Move coordinate OMNI - UPLEFT (PIECE)                                      | Move coordinate on board                                    |
|  113  | Move coordinate OMNI - DOWNRIGHT (PIECE)                                   | Move coordinate on board                                    |
|  114  | Move coordinate OMNI - DOWNLEFT (PIECE)                                    | Move coordinate on board                                    |
|  115  | Move coordinate OMNI - UPUPRIGHT                                           | Move coordinate on board                                    |
|  116  | Move coordinate OMNI - UPUPLEFT                                            | Move coordinate on board                                    |
|  117  | Move coordinate OMNI - DOWNDOWNRIGHT                                       | Move coordinate on board                                    |
|  118  | Move coordinate OMNI - DOWNDOWNLEFT                                        | Move coordinate on board                                    |
|  119  | Move coordinate OMNI - Move Too Far                                        | Move coordinate on board                                    |
|  120  | Move coordinate OMNI - Move Off Board                                      | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR EXIT --------------------**               |**---------------------------------------------------------**|
|  121  | Move ORTHOGONAL to Exit                                                    | Move coordinate on board                                    |
|  122  | Move LINEAR to Exit                                                        | Move coordinate on board                                    |
|  123  | Move OMNI to Exit                                                          | Move coordinate on board                                    |
|  124  | Move DIAGONAL to Exit                                                      | Move coordinate on board                                    |
|**---**| **-------------------- TESTS FOR FLY --------------------**                |**---------------------------------------------------------**|
|   00  | Move coordinate FLY - UP                                                   | Move coordinate on board                                    |
|   00  | Move coordinate FLY - DOWN                                                 | Move coordinate on board                                    |
|   00  | Move coordinate FLY - LEFT                                                 | Move coordinate on board                                    |
|   00  | Move coordinate FLY - RIGHT                                                | Move coordinate on board                                    |
|   00  | Move coordinate FLY - UPRIGHT                                              | Move coordinate on board                                    |
|   00  | Move coordinate FLY - UPLEFT                                               | Move coordinate on board                                    |
|   00  | Move coordinate FLY - DOWNRIGHT                                            | Move coordinate on board                                    |
|   00  | Move coordinate FLY - DOWNLEFT                                             | Move coordinate on board                                    |
|   00  | Move coordinate FLY - UPUPRIGHT                                            | Move coordinate on board                                    |
|   00  | Move coordinate FLY - UPUPLEFT                                             | Move coordinate on board                                    |
|   00  | Move coordinate FLY - DOWNDOWNRIGHT                                        | Move coordinate on board                                    |
|   00  | Move coordinate FLY - DOWNDOWNLEFT                                         | Move coordinate on board                                    |
|   00  | Move coordinate FLY - INVALID                                              | Move coordinate on board                                    |
