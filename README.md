# MarsRover

The main() is in Mars.java.  Run the main() to start the program.

The constructor of Mars take one string argument in form of "x y".  Then program will create a grid accordingly.
It is hardcoded to create two rovers, one martian and one rock on Mars.  Their positions are randomly set.
Information and the grid will be displayed in console.

**Example:**

<br>
--------------------------------<br>
Rock position : 5 5<br>
Rover A position :3 4 N<br>
Rover B position :1 5 N<br>
Martian position :0 1 S<br>
+-+-+-+-+-+-+<br>
&nbsp;&nbsp;5| &nbsp;|B| &nbsp;| &nbsp;| &nbsp;|R|<br>
+-+-+-+-+-+-+<br>
4| | | |A| | |<br>
+-+-+-+-+-+-+<br>
3| | | | | | |<br>
+-+-+-+-+-+-+<br>
2| | | | | | |<br>
+-+-+-+-+-+-+<br>
1|M| | | | | |<br>
+-+-+-+-+-+-+<br>
0| | | | | | |<br>
+-+-+-+-+-+-+<br>
 |0|1|2|3|4|5|<br>
 
 --------------------------------<br>
 
 
 
 "A" - rover A<br>
 "B" - rover B<br>
 "M" - martian<br>
 "R" - rock<br>
 0-5 are row numbers and column numbers<br>
 
 Every round all movable object will move or spin once.  Rock does not extend movable so it cannot move.
 Each round the rover may spin ("L", "R") or move ("m").  Martian does not spin but it moves diagonally and randomly. 
 In the example below, the martian moved from (0,1) to (1,2).
 
 
 
 **Example**<br>
--------------------------------<br>
Round : 1<br>
A action : M<br>
B action : M<br>
M action : L<br>
M action : M<br>
M action : L<br>
M action : M<br>
+-+-+-+-+-+-+<br>
5| | | |A| |R|<br>
+-+-+-+-+-+-+<br>
4| | | | | | |<br>
+-+-+-+-+-+-+<br>
3| | | | | | |<br>
+-+-+-+-+-+-+<br>
2| |M| | | | |<br>
+-+-+-+-+-+-+<br>
1| | | | | | |<br>
+-+-+-+-+-+-+<br>
0| |B| | | | |<br>
+-+-+-+-+-+-+<br>
 |0|1|2|3|4|5|<br>
--------------------------------<br><br><br>
 
 
 
 After each round, Mars will look for object land on same box.  If found, Mars broadcast "CLASH" event.  
 Objects involved in this event have to respond.


 **Rover clash with Martian**
 Rover print message "Martian, watch out !!!!!"
 Martian will dodge (randomlly and diagonally move to new position).
 
  Example
--------------------------------
Round : 4
A action : R
B action : M
M action : R
M action : M
M action : L
M action : M
Martian, watch out !!!!!
M action : L
M action : M
M action : R
M action : M
Martian dodged the rover B.  Move from " 0 1" to "1 0"
+-+-+-+-+-+-+
5| | | | | |R|
+-+-+-+-+-+-+
4| | | | | | |
+-+-+-+-+-+-+
3| | | | | | |
+-+-+-+-+-+-+
2| | | | | | |
+-+-+-+-+-+-+
1|B| | | | | |
+-+-+-+-+-+-+
0| |M| |A| | |
+-+-+-+-+-+-+
 |0|1|2|3|4|5|
--------------------------------
  
  
  **Martian clash with rock** 
  Martian prints message "Martian kick away a rock.".
  The rock will randomly move to new location.
  
  Example
--------------------------------

Round : 45
A action : R
B action : R
M action : R
M action : M
M action : L
M action : M
Martian kick away a rock. 
+-+-+-+-+-+-+
5| | | | | | |
+-+-+-+-+-+-+
4| | | | | | |
+-+-+-+-+-+-+
3| | | | |A| |
+-+-+-+-+-+-+
2| | | |M|R| |
+-+-+-+-+-+-+
1| | | | | | |
+-+-+-+-+-+-+
0|B| | | | | |
+-+-+-+-+-+-+
 |0|1|2|3|4|5|

--------------------------------
  
  
  
   **Rover clash with rover** 
  Rover prints message "Rover A crashed. Mission Failed.".  Then **Game is over**.  
  The box where the rovers crashed will be marked as "X".
  
  Example
--------------------------------

Round : 39
A action : M
B action : M
M action : L
M action : M
M action : R
M action : M
Rover A crashed. Mission Failed.
Rover B crashed. Mission Failed.
+-+-+-+-+-+-+
5| | | | | | |
+-+-+-+-+-+-+
4| |X| | | | |
+-+-+-+-+-+-+
3| | | | |R| |
+-+-+-+-+-+-+
2| | | | | | |
+-+-+-+-+-+-+
1| | | |M| | |
+-+-+-+-+-+-+
0| | | | | | |
+-+-+-+-+-+-+
 |0|1|2|3|4|5|

--------------------------------
  
  
  
  **Rover clash with rock** 
  Rock does nothing.
  Rover prints message "Rover has found a rock.  Mission accomplish".  **Game is over**.
  The box where the rover found a rock will be marked with "@".
  
  Example
--------------------------------

Round : 57
A action : M
B action : M
M action : R
M action : M
M action : L
M action : M
Rover A has found a rock. Mission Accomplished.
+-+-+-+-+-+-+
5| &nbsp;| &nbsp;| | | |@|
+-+-+-+-+-+-+
4| | | | | | |
+-+-+-+-+-+-+
3| | | |B| | |
+-+-+-+-+-+-+
2| | | | | | |
+-+-+-+-+-+-+
1| | | | | | |
+-+-+-+-+-+-+
0| | | | | |M|
+-+-+-+-+-+-+
 |0|1|2|3|4|5|

--------------------------------
  



Please note if grid size is big, it may takes hundreds or thousands rounds to end the game.  
  
  
  
 
 
 
 
