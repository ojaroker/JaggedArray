class ExhaustiveApproach {
  

  public Ball[] collide(Ball[] origArray) {
    Ball[] newArray = new Ball[origArray.length];
    
    int counter = 0;
    
    for (int i = 0; i < origArray.length; i++) {
        
      int pos1 = origArray[i].getPos(); //position currently working with
      if(pos1!=-1){
        int numOfSamePos = 1;
        for (int j = 0; j < i; j++) {
          int pos2 = origArray[j].getPos(); //position testing against pos1
          // if positions are the same, count and eliminate it from consideration in next iteration
          if (pos1 != -1 && pos2!=-1 && pos2 == pos1) {
            numOfSamePos++;
            origArray[j].setPos(-1); //prevents it from being tested again
          }
        }
        
        for (int j = i + 1; j < origArray.length; j++) {
          int pos2 = origArray[j].getPos();
          if (pos1 != -1 && pos2!=-1 && pos2 == pos1) {
            numOfSamePos++;
            origArray[j].setPos(-1);
          }
        }
        
        //System.out.println("Number of same position " + pos1 + ": " + numOfSamePos);
        if (numOfSamePos > 1) {
          //System.out.println("more than one "+pos1);
          int direction=1;
          
          /*if((int)(10*Math.random())>4){
            direction=-1;
          }*///MAKE MORE RANDOM
          
          for (int k = 0; k < numOfSamePos; k++) {
            // catch pos 0 or 11 out of bounds
            if (pos1 == 0) {
              direction = 1;
            } else if (pos1 == 11) {
              direction = -1;
            }
            newArray[counter] = new Ball(pos1 + direction);
            //System.out.println("Made new ball counter: "+counter+", position: "+(pos1+direction));
            direction *= -1;
            counter++;
          }
        }
        else if(numOfSamePos==1){
          newArray[counter] = new Ball(pos1);
          counter++;
        }
      }
    }

    return newArray;
  }

}