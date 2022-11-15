
import java.util.*;

public class JaggedBallArray {
  OJArrays OJA = new OJArrays();
  private int numBins, numElements;
  public Ball[][] unpackedValues;
  public Ball[] packedValues;
  public int[] offsets, counts;
  public boolean packed, unpacked;

  Scanner scan = new Scanner(System.in);

  public JaggedBallArray(int numBins, int numElements) {
    this.numBins = numBins;
    this.numElements = numElements;
  }

  // pack jagged array: store array of offsets, large array of packed values
  public void pack(Ball[][] unpackedValues, int[] counts) {
    packedValues = new Ball[numElements];
    offsets = new int[numBins];
    // fills packedValues array of all values
    int counter = 0;
    for (int i = 0; i < unpackedValues.length; i++) {

      for (int j = 0; unpackedValues[i] != null && j < unpackedValues[i].length; j++) {
        packedValues[counter] = unpackedValues[i][j];
        counter++;
      }
    }

    offsets[0] = 0;
    for (int i = 1; i < unpackedValues.length; i++) {
      offsets[i] = offsets[i - 1] + counts[i - 1];
    }

    packed = true;
    unpacked = false;
  }

  // unpack jagged array: store 2D array of unpacked values, array of counts
  // number of unique numbers in offsets = number of filled bins
  // j=i+1, bin i contains subArray[i,j)
  public void unpack(int[] offsets, Ball[] packedValues) {
    // numBins = offsets.length;
    // numElements = packedValues.length;

    counts = new int[offsets.length];
    unpackedValues = new Ball[offsets.length][];
    for (int i = 0; i < offsets.length - 1; i++) {
      int j = i + 1;
      unpackedValues[i] = OJA.subArray(packedValues, offsets[i], offsets[j]);
    }
    // fill last bin with all remaining elements
    unpackedValues[offsets.length - 1] = OJA.subArray(packedValues, offsets[offsets.length - 1]);

    // fill counts with lengths
    for (int i = 0; i < offsets.length; i++) {
      if (unpackedValues[i] != null) {
        counts[i] = unpackedValues[i].length;
      } else {
        counts[i] = 0;
      }

    }

    packed = false;
    unpacked = true;
  }

  // print out the UNPACKED array: counts array, unpacked values
  public void printUP() {
    System.out.print("Counts: ");
    for (int i : counts) {
      System.out.print(i + ", ");
    }
    System.out.println();
    System.out.println("Unpacked Values:");
    for (int j = 0; j < unpackedValues.length; j++) {
      System.out.print("Bin " + j + ": ");
      if (unpackedValues[j] != null) {
        for (int c = 0; c < unpackedValues[j].length; c++) {
          System.out.print(unpackedValues[j][c].toString());
        }
      } else {
        System.out.print("null");
      }

      System.out.println();
    }

  }

  // prints the PACKED structure: offsets, packed values
  public void printP() {

    System.out.println("Offsets: ");
    for (int i : offsets) {

      System.out.print(i + ", ");
    }
    System.out.println("\nPacked Values:");
    for (Ball b : packedValues) {
      System.out.print(b.toString());
    }
  }

  // return packed representation of collided balls given unpacked arr
  public Ball[][] collideUP(Ball[][] unpackedValues) {
    // System.out.println("counts: " + Arrays.toString(counts));
    int numBins = unpackedValues.length;
    int[] newCounts = new int[numBins];
    //Ball[] packedValues = new Ball[numBins];
    for (int i = 0; i < numBins; i++) {
      if (unpackedValues[i] != null) {
        if (unpackedValues[i].length <= 1) {
          newCounts[i] += unpackedValues[i].length;
        } else {
          int direction = 1;
          
          /*if((int)(10*Math.random())>4){
            direction=-1;
          }*///MAKE MORE RANDOM
          
          if (i == 0) {
            for (int c = 0; c < unpackedValues[i].length; c++) {
              newCounts[1]++;
            }
          } else if (i == numBins-1) {
            for (int c = 0; c < unpackedValues[i].length; c++) {
              newCounts[numBins-2]++;
            }
          } else {
            for (int c = 0; c < unpackedValues[i].length; c++) {
              newCounts[i + direction]++;
              direction *= -1;
            }
          }
        }
      }
    }
    // System.out.println("New counts: " + Arrays.toString(newCounts));
    //makes unpacked
    for(int i=0;i<newCounts.length;i++){
      if(newCounts[i]!=0){
        unpackedValues[i] = new Ball[newCounts[i]];
        for(int j=0;j<newCounts[i];j++){
          unpackedValues[i][j] = new Ball(i);
        }
      } else{
        unpackedValues[i] = null;
      }
    }

    counts = newCounts;
    return unpackedValues;
  }

  //collides using counts array, not unpacked
  public int[] collideC(int [] counts){
    // System.out.println("counts: " + Arrays.toString(counts));
    
    int numBins = counts.length;
    int[] newCounts = new int[numBins];
    //Ball[] packedValues = new Ball[numBins];
    for (int i = 0; i < numBins; i++) {
      //if (counts[i] != null) {
        if (counts[i] <= 1) {
          newCounts[i] += counts[i];
        } else {
          int direction = 1;
          
          /*if((int)(10*Math.random())>4){
            direction=-1;
          }*///MAKE MORE RANDOM
          
          if (i == 0) {
            for (int c = 0; c < counts[i]; c++) {
              newCounts[1]++;
            }
          } else if (i == numBins-1) {
            for (int c = 0; c < counts[i]; c++) {
              newCounts[numBins-2]++;
            }
          } else {
            for (int c = 0; c < counts[i]; c++) {
              newCounts[i + direction]++;
              direction *= -1;
            }
          }
        }
      //}
    }
    // System.out.println("New counts: " + Arrays.toString(newCounts));
   
    
    return newCounts;
  }
  

  public void setPackedValues(Ball[] arr) {
    packedValues = arr;
  }

  public void setUnpackedValues(Ball[][] arr) {
    unpackedValues = arr;
  }

  public void setCounts(int[] arr) {
    counts = arr;
  }

  public int[] getCounts() {
    return counts;
  }

  public int[] getOffsets() {
    return offsets;
  }

  public Ball[] getPackedValues() {
    return packedValues;
  }

  public Ball[][] getUnpackedValues() {
    return unpackedValues;
  }

  public boolean isPacked() {
    return packed;
  }

}