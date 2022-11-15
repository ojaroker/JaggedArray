// //Build the JaggedArray class that provides methods to initialize and populate a jagged array, as well as pack and unpack it.  Create a driver class which provides a menu for testing/printing.

// import java.util.Scanner;

// public class JaggedArrayDriver {

//   static Scanner scan = new Scanner(System.in);
//   static JaggedArray prog = new JaggedArray(4, 4);

//   public static void main(String[] args) {

//     printMenu();
//     int choice = scan.nextInt();
//     while (choice != 0) {
//       dispatch(choice);
//       printMenu();
//       choice = scan.nextInt();

//     }
//   }

//   // -------------------------------------------------------
//   // Do what the menu item calls for
//   // -------------------------------------------------------
//   public static void dispatch(int choice) {

//     switch (choice) {
//       case 0:
//         System.out.println("Bye!");
//         break;
//       case 1:
//         System.out.println("Number of bins?");
//         int numBins = scan.nextInt();
//         System.out.println("Number of elements?");
//         int numElements = scan.nextInt();

//         prog = new JaggedArray(numBins, numElements);
//         // prog.populate();
//         break;

//       case 4:
//         prog.printUP();
//         break;
//       case 5:
//         prog.printP();
//         break;

//       case 6:
//         System.out.println("Number of bins?");
//         numBins = scan.nextInt();
//         System.out.println("Number of elements?");
//         numElements = scan.nextInt();

//         prog = new JaggedArray(numBins, numElements);

//         int[] offsets = new int[numBins];
//         int[] packedValues = new int[numElements];
//         System.out.println("Input offsets separated by spaces");
//         for (int i = 0; i < numBins; i++) {
//           offsets[i] = Integer.valueOf(scan.next());
//         }
//         System.out.println("Input packed values separated by spaces");
//         for (int j = 0; j < numElements; j++) {
//           packedValues[j] = Integer.valueOf(scan.next());
//         }
//         prog.unpack(offsets, packedValues);
//         prog.printUP();
//         break;

//       case 7:
//         System.out.println("Number of bins?");
//         numBins = scan.nextInt();
//         System.out.println("Number of elements?");
//         numElements = scan.nextInt();

//         prog = new JaggedArray(numBins, numElements);
//         int[][] unpackedValues = new int[numBins][];
//         int[] counts = new int[numBins];
        
//         for (int i = 0; i < numBins; i++) {
//           System.out.println("How many elements in bin " + i);
//           int binSize = scan.nextInt();
//           counts[i] = binSize;
//           if (binSize != 0) {
//             unpackedValues[i] = new int[binSize];
//           } else {
//             unpackedValues[i] = null;
//           }
//         }
//         for (int j = 0; j < unpackedValues.length; j++) {

//           if (unpackedValues[j] != null) {
//             for (int c = 0; c < unpackedValues[j].length; c++) {
//               System.out.println("Input value for bin " + j);
//               unpackedValues[j][c] = scan.nextInt();
//             }
//           }
//         }
//         prog.pack(unpackedValues,counts);
//         prog.printP();

        
//         break;
//       default:
//         System.out.println("Sorry, invalid choice");
//     }
//   }

//   // -------------------------------------------------------
//   // Print the user's choices
//   // -------------------------------------------------------
//   public static void printMenu() {

//     System.out.println("\n   Menu   ");
//     System.out.println("   ====");
//     System.out.println("0: Quit");
//     System.out.println("1: Initialize a JaggedArray (** do this first!! **)");
//     System.out.println("2: Unpack the JaggedArray");
//     System.out.println("3: Pack the JaggedArray");
//     System.out.println("4: Print the *UNPACKED* JaggedArray");
//     System.out.println("5: Print the *PACKED* JaggedArray");
//     System.out
//         .println("6: Manually enter offsets and packed values. Unpacks and then prints counts and unpacked values");
//     System.out.println("7: Manually enter unpacked values and counts. Packs and then prints offsets, packed values");
//     System.out.print("\nEnter your choice: ");
//   }

// }
