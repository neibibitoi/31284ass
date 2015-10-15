package soap.client;

public class ReviewServiceProxy implements soap.client.ReviewService {
  private String _endpoint = null;
  private soap.client.ReviewService reviewService = null;
  
  public ReviewServiceProxy() {
    _initReviewServiceProxy();
  }
  
  public ReviewServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initReviewServiceProxy();
  }
  
  private void _initReviewServiceProxy() {
    try {
      reviewService = (new soap.client.ReviewServiceServiceLocator()).getReviewServicePort();
      if (reviewService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reviewService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reviewService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reviewService != null)
      ((javax.xml.rpc.Stub)reviewService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.client.ReviewService getReviewService() {
    if (reviewService == null)
      _initReviewServiceProxy();
    return reviewService;
  }
  
  public int deleteReview(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (reviewService == null)
      _initReviewServiceProxy();
    return reviewService.deleteReview(arg0, arg1, arg2);
  }
  
  public soap.client.Review getReviewById(int arg0) throws java.rmi.RemoteException{
    if (reviewService == null)
      _initReviewServiceProxy();
    return reviewService.getReviewById(arg0);
  }
  
  public int postReview(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4, int arg5) throws java.rmi.RemoteException{
    if (reviewService == null)
      _initReviewServiceProxy();
    return reviewService.postReview(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public soap.client.Review[] getAllReviews(int arg0) throws java.rmi.RemoteException{
    if (reviewService == null)
      _initReviewServiceProxy();
    return reviewService.getAllReviews(arg0);
  }
  
  
}