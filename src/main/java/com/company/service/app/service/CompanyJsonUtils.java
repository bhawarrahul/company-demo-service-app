package com.company.service.app.service;

import com.company.service.app.model.Company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CompanyJsonUtils {

    private final static String COMPANY_JSON_FILE = "file_volume/companyData.json";

    /**
     * Read all company list from JSON file
     *
     * @return list company present in JSON file
     */
    public static List<Company> getAllCompany() {
        List<Company> companyList = null;
        createJsonFile();
        try (FileReader fileReader = new FileReader(COMPANY_JSON_FILE)) {
            final Gson gson = new Gson();
            companyList = gson.fromJson(fileReader, new TypeToken<ArrayList<Company>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    /**
     * Save company list in JSON file
     *
     * @param companyList
     */
    public static void saveCompany(final List<Company> companyList) {
        createJsonFile();
        try (FileWriter fileWriter = new FileWriter(COMPANY_JSON_FILE)) {
            final Gson gson = new Gson();
            final String json = gson.toJson(companyList);
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create file if not present in given path
     */
    private static void createJsonFile() {
        try {
            final File file = new File(COMPANY_JSON_FILE);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
