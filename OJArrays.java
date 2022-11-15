public class OJArrays{

  public Ball[] subArray(Ball[] originalArray, int startVal, int endVal){
    if(startVal==endVal){
      return null;
    }
    Ball[] newArray = new Ball[endVal-startVal];
    for(int i=startVal;i<endVal;i++){
      newArray[i-startVal] = originalArray[i];
    }
    return newArray;

    
  }


  public Ball[] subArray(Ball[] originalArray, int startVal){
    if(startVal==originalArray.length){
      return null;
    }
    Ball[] newArray = new Ball[originalArray.length-startVal];
    for(int i=startVal;i<originalArray.length;i++){
      newArray[i-startVal] = originalArray[i];
    }
    return newArray;
  }

  public boolean contains(int[] arr, int num){
    for(int i : arr){
      if(i==num){
        return true;
      }
    }
    return false;
  }

  
}