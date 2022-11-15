


// import java.util.Scanner;

// public class JaggedArray {
//   OJArrays OJA = new OJArrays();
//   private int numBins, numElements;
//   private int[][] unpackedValues;
//   private int[] packedValues, offsets, counts;
//   boolean packed,unpacked;

//   Scanner scan = new Scanner(System.in);

//   public JaggedArray(int numBins, int numElements) {
//     this.numBins = numBins;
//     this.numElements = numElements;
//   }



//   // pack jagged array: store array of offsets, large array of packed values
//   public void pack(int[][] unpackedValues, int[] counts) {
//     packedValues = new int[numElements];
//     offsets = new int[numBins];
//     //fills packedValues array of all values
//     int counter = 0;
//     for (int i = 0; i < unpackedValues.length; i++) {
      
//       for (int j = 0; unpackedValues[i] != null && j < unpackedValues[i].length; j++) {
//         packedValues[counter] = unpackedValues[i][j];
//         counter++;
//       }
//     }

//     offsets[0]=0;
//     for (int i = 1; i < unpackedValues.length; i++) {
//       offsets[i] =  offsets[i-1]+counts[i-1];
//     }

//     packed=true;
//     unpacked=false;
//   }

//   // unpack jagged array: store 2D array of unpacked values, array of counts
//   //number of unique numbers in offsets = number of filled bins
//   //j=i+1, bin i contains subArray[i,j)
//   public void unpack(int[] offsets, int[] packedValues) {
//     // numBins = offsets.length;
//     // numElements = packedValues.length;
    
//     counts = new int[offsets.length];
//     unpackedValues = new int[offsets.length][];
//     for(int i=0;i<offsets.length-1;i++){
//       int j=i+1;
//       unpackedValues[i] = OJA.subArray(packedValues, offsets[i], offsets[j]);
//     }
//     //fill last bin with all remaining elements
//     unpackedValues[offsets.length-1] = OJA.subArray(packedValues, offsets[offsets.length-1]);

//     //fill counts with lengths
//     for(int i=0;i<offsets.length;i++){
//       if(unpackedValues[i]!=null){
//         counts[i] = unpackedValues[i].length;
//       }
//       else{
//         counts[i] = 0;
//       }
      
//     }

//     packed=false;
//     unpacked=true;
//   }

//   // print out the UNPACKED array: counts array, unpacked values
//   public void printUP() {
//     System.out.print("Counts: ");
//     for (int i : counts) {
//       System.out.print(i + ", ");
//     }
//     System.out.println();
//     System.out.println("Unpacked Values:");
//     for (int j = 0; j < unpackedValues.length; j++) {
//       System.out.print("Bin " + j + ": ");
//       if(unpackedValues[j]!=null){
//         for (int c = 0; c < unpackedValues[j].length; c++) {
//         System.out.print(unpackedValues[j][c] + ", ");
//         }
//       }
//       else{
//         System.out.print("null");
//       }
      
//       System.out.println();
//     }

//   }

//   // prints the PACKED structure: offsets, packed values
//   public void printP() {

//     System.out.println("Offsets: ");
//     for(int i : offsets){
      
//       System.out.print(i+", ");
//     }
//     System.out.println("\nPacked Values:");
//     for(int j : packedValues){
//       System.out.print(j+",");
//     }
//     System.out.println();
//   }

//   public boolean isPacked(){
//     return packed;
//   }

// }