/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CustomExceptions;

/**
 *
 * @author yousufkhan
 */
public class TerminateException extends Exception {
    //Parameterless Constructor
      public TerminateException() {}

      //Constructor that accepts a message
      public TerminateException(String message)
      {
         super(message);
      }
}
