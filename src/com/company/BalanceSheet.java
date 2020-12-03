package com.company;

import java.util.List;

public class BalanceSheet {
//    private ExportHTML exportHTML = new ExportHTML();
//    private FetchDatabase fetchDatabase = new FetchDatabase();
    private FetchDatabase fetchDatabase = null;
    private ExportHTML exportHTML = null;
    private FetchWebService fetchWebService = null;
    private ExportPDF exportPDF = null;

    public void generateBalanceSheet(int inputMethod,int outputMethod){
        //inputMethod = 1 means database
        //inputMethod = 2 means WS
        //outputMethod = 1 means HTML
        //outputMethod = 2 means PDF
//        exportHTML.exportToHTML(fetchDatabase.fetchDataFromDatabase());
//        exportPDF.exportToPDF(fetchDatabase.fetchDataFromDatabase());
        if(inputMethod==1){
            fetchDatabase = new FetchDatabase();
        }else if(inputMethod==2){
            fetchWebService = new FetchWebService();
        }
        if(outputMethod==1){
            List<Object[]> dataLst =null;
            if(inputMethod==1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else if (inputMethod==2){
                dataLst = fetchWebService.fetchDataFromWS();
            }
            exportHTML.exportToHTML(dataLst);
        }else if (outputMethod==2){
            List<Object[]> dataLst =null;
            if(inputMethod==1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else if (inputMethod==2){
                dataLst = fetchWebService.fetchDataFromWS();
            }
            exportPDF.exportToPDF(dataLst);
        }
    }
}
