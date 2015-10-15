package com.microsofttranslator.api.V2;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateArrayResponse;
import org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions;
import org.tempuri.SoapService;
import org.tempuri.SoapServiceLocator;

public class TranslationClient {

	public static String[] getAllSupportLanguages() {
		SoapService soap = new SoapServiceLocator();
		try {
			LanguageService service = soap.getBasicHttpBinding_LanguageService();

			TranslateOptions options = new TranslateOptions();
			options.setCategory("general");
			options.setContentType("text/plain");

			String accessToken = TranslateHelper.getAccessToken("31284ass",
					"5BdUHegD2bnSpG3BegN3jqfow97gl0n8ek8pJ0WiKJ8=");
			String appId = "Bearer " + accessToken;

			return service.getLanguagesForTranslate(appId);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String[] translate(String[] originalTextArray, String toLan) {
		SoapService soap = new SoapServiceLocator();
		try {
			LanguageService service = soap.getBasicHttpBinding_LanguageService();

			TranslateOptions options = new TranslateOptions();
			options.setCategory("general");
			options.setContentType("text/plain");

			String accessToken = TranslateHelper.getAccessToken("31284ass",
					"5BdUHegD2bnSpG3BegN3jqfow97gl0n8ek8pJ0WiKJ8=");
			String appId = "Bearer " + accessToken;

			TranslateArrayResponse[] result = service.translateArray(appId, originalTextArray, "en", toLan, options);

			String[] translateResultArray = new String[originalTextArray.length];
			for (int i = 0; i < result.length; i++) {
				translateResultArray[i] = result[i].getTranslatedText();
			}
			return translateResultArray;

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public static void main(String args[]) throws ServiceException,
	// RemoteException {
	// SoapService soap = new SoapServiceLocator();
	// LanguageService service = soap.getBasicHttpBinding_LanguageService();
	//
	// // String text = "Hello World.";
	// // String result2 = service.translate("Bearer " + authToken, text,
	// // "en", "ru", "text/plain", "general");
	// // System.out.println(result2);
	// TranslateOptions options = new TranslateOptions();
	// options.setCategory("general");
	// options.setContentType("text/plain");
	//
	// String accessToken = TranslateHelper.getAccessToken("31284ass",
	// "5BdUHegD2bnSpG3BegN3jqfow97gl0n8ek8pJ0WiKJ8=");
	// String appId = "Bearer " + accessToken;
	//
	// TranslateArrayResponse[] result = service.translateArray(appId, new
	// String[] { "您", "好" }, "zh-CHS", "en",
	// options);
	//
	// for (TranslateArrayResponse translateArrayResponse : result) {
	// System.out.println(translateArrayResponse.getTranslatedText());
	// }
	//
	// String supportLan[] = service.getLanguagesForTranslate(appId);
	// for (String lan : supportLan) {
	// System.out.println(lan);
	// }
	// }
}
