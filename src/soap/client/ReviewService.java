/**
 * ReviewService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap.client;

public interface ReviewService extends java.rmi.Remote {
    public int deleteReview(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException;
    public soap.client.Review getReviewById(int arg0) throws java.rmi.RemoteException;
    public int postReview(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4, int arg5) throws java.rmi.RemoteException;
    public soap.client.Review[] getAllReviews(int arg0) throws java.rmi.RemoteException;
}
