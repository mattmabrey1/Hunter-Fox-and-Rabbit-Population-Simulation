# Hunter-Fox-and-Rabbit-Population-Simulation
Final project for Object-oriented Programming &amp; Data Abstraction course at RCBC during the spring 2019 semester.
This project adds a new hunter class to a preexisting simulation grid with foxes and rabbits. The simulation simulates the population of 
hunters, foxes, and rabbits in a 2000x2000 grid. Each "actor" has a specific set of actions that may include eating, killing, moving, 
reproducing, and dying. Hunters randomly choose a new empty location and kill if there is an animal nearby and the hunter 
population stays the same as I assumed the number of people that hunt doesn't change that much from year to year. Foxes will kill a rabbit
if it is in the block next to them and will breed with another fox if it is next to it and both are of mating age. Rabbits will move from 
cell to cell and breed if they're nextto another rabbit and of mating age. If there is no space for a fox or rabbit to move to for a turn 
the animal will die. 
