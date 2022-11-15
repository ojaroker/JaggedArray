# JaggedArray
Jagged Array data structure is used here to optimize calculations of ball collisions within a 1D hallway.
Field is split up into bins, and balls are randomly dispersed.
If two or more balls share a position, a collision occurs and the balls are pushed in opposite directions, into the next bin.
Excecution of the program compares the usage of a Jagged Array against an exhaustive approach, which tests each ball against every other, checking if any share a common position.
