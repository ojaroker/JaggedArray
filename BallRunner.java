import java.util.*;

class BallRunner {
  int numIterations = 10, numBins = 12, numElements=10;
  int[] countsArr;
  Ball[] packedArr, BFarr/*, JAarr*/;
  Ball[][] unpackedArr,JAarr;
  long exhaustiveTime, jaggedTime, jaggedTimeC;
  Random rand = new Random();
  //OJArrays OJA = new OJArrays();
  JaggedBallArray jaggedArr = new JaggedBallArray(12, 10); // 12 bins, 10 elements

  // randomly fill 2d unpackedarr with balls 
  public void randomize() {
    countsArr = new int[numBins];
    packedArr = new Ball[numElements];
    for (int i = 0; i < numElements; i++) {
      int pos = rand.nextInt(numBins);
      countsArr[pos]++;
      packedArr[i] = new Ball(pos);
    }
    unpackedArr = new Ball[numBins][];

    System.out.println("Originals:");
    for (Ball b : packedArr) {
      System.out.print(b.toString() + " ");
    }
    System.out.println();

    //build unpackedArr
    for (int i = 0; i < countsArr.length; i++) {
      if (countsArr[i] != 0) {
        unpackedArr[i] = new Ball[countsArr[i]];
        for (int j = 0; j < countsArr[i]; j++) {
          unpackedArr[i][j] = new Ball(i);
        }
      } else {
        unpackedArr[i] = null;
      }
    }

  }

  public void testBruteForce() {
    long startTime = System.nanoTime();
    ExhaustiveApproach approach1 = new ExhaustiveApproach();
    BFarr = approach1.collide(packedArr);
    for (int i = 0; i < numIterations-1; i++) {
      BFarr = approach1.collide(BFarr);
      // System.out.println("");
    }

    exhaustiveTime = System.nanoTime() - startTime;

    System.out.println("Exhaustive method time for "+numIterations+" iterations: " + (exhaustiveTime / 1000000.0) + " ms");
  }

  public void testJaggedUP() {
    // JAarrPacked = new Ball[unpackedArr.length];
    long startTime = System.nanoTime();
    JAarr = jaggedArr.collideUP(unpackedArr);
    //countsArr = jaggedArr.getCounts();
    for (int i = 0; i < numIterations-1; i++) {
      JAarr = jaggedArr.collideUP(JAarr);
      //countsArr = jaggedArr.getCounts();
    }
  /*  int c = 0;
    for (int i = 0; i < JAarr.length; i++) {
      if (JAarr[i] != null) {
        for (int j = 0; j < JAarr[i].length; j++) {
          JAarrPacked[c] = JAarr[i][j];
          c++;
        }
      }
    }*/

    jaggedTime = System.nanoTime() - startTime;

    System.out.println("Jagged Array time USING UNPACKED for "+numIterations+" iterations: " + (jaggedTime / 1000000.0) + " ms");
  }

  public void testJaggedC(){
    long startTime = System.nanoTime();
    countsArr = jaggedArr.collideC(countsArr);
    for (int i = 0; i < numIterations-1; i++) {
      countsArr = jaggedArr.collideC(countsArr);
      /*boolean stopped=true;
      for(int c : countsArr){
        if(c>1){
          stopped=false;
        }
      }
      if(stopped){
        System.out.println("BALLS STOPPED AFTER "+i+" ITERATIONS");
        break;
      }*/
    }
    jaggedTimeC = System.nanoTime() - startTime;

    System.out.println("Jagged Array time USING COUNTS for "+numIterations+" iterations: " + (jaggedTime / 1000000.0) + " ms");
  }

  public void printAll() {
    System.out.println("Exhaustive:");
    for (Ball b : BFarr) {
      if (b != null) {
        System.out.print(b.toString() + " ");
      }
    }
    System.out.println("\nJagged Unpacked:");
    for (Ball[] bArr : JAarr) {
      if (bArr != null) {
        for(Ball b : bArr){
          System.out.print(b.toString() + " ");
        }

      }
    }
    System.out.println("\nJagged Counts:");
    for(int c : countsArr){
      System.out.print(c+"  ");
    }
  }

  public void run() {
    // System.out.println("Randomly assigning ball locations...");
    randomize();
    testBruteForce();
    testJaggedUP();
    testJaggedC();
    printAll();

  }
}