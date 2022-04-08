package com.klaipeda.assessment.uml;

/**
 * <p>
 *     This just a class for all static methods
 * </p>
 */
public class Global {

    /**
     * <p>This method checks if a particular element already exist in an array of  string elements.</p>
     * <p>This method returns <code>true</code> if the element is not found and return false if the element is found</p>
     * @param maxIndexToSearchTo The maximum number of index to search to, it may not necessarily be the entire array length.
     * @param elements the array to search through
     * @param element the element we are finding
     * @return  boolean
     */
    public static boolean elementIsNotYetRegistered(int maxIndexToSearchTo, String[] elements, String element){
        var isNotYetRegistered = true;
        for (int i = 0; i < maxIndexToSearchTo ; i++) {
            var s = elements[i];
            if(s==null){
                isNotYetRegistered = true;
            }else{
                isNotYetRegistered = !s.equalsIgnoreCase(element);

                if(!isNotYetRegistered){
                    break;
                }
            }
        }
        return isNotYetRegistered;
    }
}
