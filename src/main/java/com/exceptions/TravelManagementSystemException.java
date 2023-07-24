package main.java.com.exceptions;

/**
 * Generic exception for general travel management system exceptions.
 */
public class TravelManagementSystemException  extends RuntimeException {

  public TravelManagementSystemException() {
  }

  public TravelManagementSystemException(String message) {
    super(message);
  }
}
