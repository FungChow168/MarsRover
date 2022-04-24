# MarsRover

The main() is in Mars.java.  Run the main() to start the program.

The constructor of Mars take one string argument in form of "x y".  Then program will create a grid accordingly.
It is hardcoded to create two rovers, one martian and one rock on Mars.  Their positions are randomly set.
Information and the grid will be displayed in console.

**Example:**<br>
![example 1](./eg1.png)
<br>
<br> 
 
 "A" - rover A<br>
 "B" - rover B<br>
 "M" - martian<br>
 "R" - rock<br>
 0-5 are row numbers and column numbers<br>
 
 Every round all movable object will move or spin once.  Rock does not extend movable so it cannot move.<br>
 Rover may spin ("L", "R") or move ("m").  Martian does not spin but it moves diagonally and randomly.<br> 
 
 <br>
 <br>
 <br>
 
 
 After each round, if two or more objects land on same box, Mars broadcast "CLASH" event.  <br>
 Objects involved in this event have to respond.<br>
<br>
<br>
 **\[ Rover clash with Martian \]**<br>
 Rover print message "Martian, watch out !!!!!"<br>
 Martian will dodge (randomlly and diagonally move to new position).<br>
 <br>
  Example<br>
![example 1](./eg2.png)
  
 <br>
 <br>
 <br>
 
  **\[ Martian clash with rock \]** <br>
  Martian prints message "Martian kick away a rock.".<br>
  The rock will randomly move to new location.<br>
  <br>
  Example<br>
![example 1](./eg3.png)

 <br>
 <br>
 <br>
  
  
   **Rover clash with rover** <br>
  Rover prints message "Rover A crashed. Mission Failed.".  Then **Game is over**.  <br>
  The box where the rovers crashed will be marked as "X".<br>
  <br>
  Example<br>
![example 1](./eg6.png)


  <br>
  <br>
  <br>
  
  **\[ Rover clash with rock \]** <br>
  Rock does nothing.<br>
  Rover prints message "Rover has found a rock.  Mission accomplish".  **Game is over**.<br>
  The box where the rover found a rock will be marked with "@".<br>
  
  Example <br>
  ![example 1](./eg5.png)

  
<br>
<br>


Please note if grid size is big, it may takes hundreds or thousands rounds to end the game.  <br>
  
  
  
 
 
 
 
